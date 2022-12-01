package charts.whiteSide;

import java.util.List;

import System.Vector2;
import charts.Unit;

public class Sniper extends Unit{

    public Sniper(List<Unit> gang, List<Unit> side, int x, int y) {
        super(12, 10, 32, new int[]{8,10}, 15, 9, false, false, "Sniper");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
    }

    @Override
    public void step() {
        for (Unit unit : super.gang) {
            if (unit.getName().equals("Крестьянин")) {
                shoot++;
                unit.setAction("Занят");
                break;
            }
        }
        if (shoot > 0) {
            double dist = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
                double tmp = side.get(i).getPosition().getDist(this.position);
                if (dist > tmp && !side.get(i).getAction().equals("Мертв")) {
                    dist = tmp;
                    index = i;
                }
            }
            if (index >= 0) {
                side.get(index).getHit(speed > dist ? calcDamage(side.get(index)) : calcDamage(side.get(index)) / 2);
                shoot--;
            }
        }
    }
    @Override 
    public String getInfo() {
        return "Sniper " + super.getInfo();
    }
    
}
