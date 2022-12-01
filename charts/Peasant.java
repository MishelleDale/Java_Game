package charts;

import java.util.List;
import System.Vector2;

public class Peasant extends Unit{

    public Peasant(List<Unit> gang, List<Unit> side, int x, int y) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false, "Peasant");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
    }

    @Override 
    public String getInfo() {
        return "Peasant " + super.getInfo();
    }

    @Override
    public void step() {
        if (action.equals("Used")) {
            action = "Stand";
        }
    }
}
