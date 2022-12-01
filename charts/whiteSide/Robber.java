package charts.whiteSide;

import java.util.List;

import System.Vector2;
import charts.Unit;

public class Robber extends Unit {
    
    public Robber(List<Unit> gang, int x, int y) {
        super(8, 3, 0, new int[]{2,4}, 10, 6, false, false, "Robber");
        super.gang = gang;
        super.position = new Vector2(x, y);

    }

    @Override 
    public String getInfo() {
        return "Robber " + super.getInfo();
    }
}
