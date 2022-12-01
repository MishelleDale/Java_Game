package charts.darkSide;

import java.util.List;

import System.Vector2;
import charts.Unit;

public class Spearman extends Unit{
    public Spearman(List<Unit> gang, List<Unit> side, int x, int y) {
        super(4, 5, 0, new int[] {1, 3}, 10, 4, false, false, "Spearman");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
    }   
    
    @Override 
    public String getInfo() {
        return "Spearman " + super.getInfo();
    }
}
