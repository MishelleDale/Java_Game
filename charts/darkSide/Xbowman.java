package charts.darkSide;

import java.util.List;

import System.Vector2;
import charts.Unit;

public class Xbowman extends Unit{
    public Xbowman(List<Unit> gang, int x, int y) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, false, false, "Xbowman");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override 
    public String getInfo() {
        return "Xbowman " + super.getInfo();
    }
}
