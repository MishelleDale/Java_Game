package charts.whiteSide;

import java.util.List;

import System.Vector2;
import charts.Unit;

public class Sniper extends Unit{

    public Sniper(List<Unit> gang, int x, int y) {
        super(12, 10, 32, new int[]{8,10}, 15, 9, false, false, "Sniper");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override 
    public String getInfo() {
        return "Sniper " + super.getInfo();
    }
    
}
