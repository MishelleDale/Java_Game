package charts.whiteSide;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Random;

import System.Vector2;
import charts.Unit;

public class Robber extends Unit {
    
    public Robber(List<Unit> gang,List<Unit> side, int x, int y) {
        super(8, 3, 0, new int[]{2,4}, 10, 6, false, false, "Robber");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(8,12);

    }

    @Override
    public void step(){
        double dist = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i <side.size(); i++) {
            if (side.get(i).action.equals("Dead")) {
                continue;
            }

            double tmp = side.get(i).getPosition().getDist(this.getPosition());
            if (dist > tmp) {
                dist = tmp;
                index = i;
            }
        }
        if (index >= 0) {
            if (dist < 2){
                side.get(index).getHit(calcDamage(side.get(index)));
            } else {
                Vector2 enemyPos = side.get(index).getPosition();
                Vector2 newPos = new Vector2(0, 0);
                if (enemyPos.y == position.y) {
                    newPos.y = position.y;
                    if (position.x - enemyPos.x < 0) {
                        newPos.x = position.x+1;
                    } else {
                        newPos.x = position.x-1;
                    }
                } else{
                    newPos.x = position.x;
                    if (enemyPos.y - position.y > 0){
                        newPos.y = position.y + 1;
                    } else {
                        newPos.y = position.y - 1;
                    }
                }
                AtomicBoolean empty = new AtomicBoolean(true);
                gang.forEach(unit -> {
                    if (unit.getPosition().isEquals(newPos)) {
                        empty.set(false);;
                    }
                });
                if (empty.get()) {
                    position = newPos;
                }
            }
        }
    }

    @Override 
    public String getInfo() {
        return "Robber " + super.getInfo();
    }
}
