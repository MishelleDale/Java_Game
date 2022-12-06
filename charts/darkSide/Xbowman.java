package charts.darkSide;

import java.util.List;
import java.util.Random;
import System.Vector2;
import charts.Unit;

public class Xbowman extends Unit{
    public Xbowman(List<Unit> gang, List<Unit> side, int x, int y) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, false, false, "Xbowman");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(2, 8);
    }

    @Override
    public void step() {
        for (Unit unit : super.gang) {
            if (unit.getName().equals("Peasant")) {
                if (!unit.getAction().equals("Used") && !unit.getAction().equals("Dead")) {
                    shoot++;
                    unit.setAction("Used");
                    break;
                }
            }
        }
        if (shoot > 0) {
            double dist = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
                double tmp = side.get(i).getPosition().getDist(this.position);
                if (dist > tmp && !side.get(i).getAction().equals("Dead")) {
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
        return "Xbowman " + super.getInfo();
    }
}
