package charts.whiteSide;
import java.util.List;
import java.util.Random;
import System.Vector2;
import charts.Unit;

public class Wizard extends Unit{

    public Wizard(List<Unit> gang, List<Unit> side, int x, int y) {
        super(17, 12, 0, new int[]{-5,-5}, 30, 9, false, true, "Wizard");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(1,4);
    }

    @Override 
    public String getInfo() {
        return "Wizard " + super.getInfo();
    }

    @Override
    public void step(){
        double minHealth = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).health > 0 && gang.get(i).health < gang.get(i).maxHealth) {
                if (gang.get(i).health < minHealth) {
                    minHealth = gang.get(i).health;
                    minIndex = i;
                }
            }
        }
        if (minIndex >= 0) {
            gang.get(minIndex).health -= this.damage[0];
            if (gang.get(minIndex).health > gang.get(minIndex).maxHealth) {
                gang.get(minIndex).health = gang.get(minIndex).maxHealth;
            }
        }
    }     
}
