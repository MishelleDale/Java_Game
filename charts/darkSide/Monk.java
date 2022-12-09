package charts.darkSide;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import System.Vector2;
import charts.Unit;

public class Monk extends Unit{

    static int tmpInt = -1;

    public Monk(List<Unit> gang,  List<Unit> side, int x, int y) {
        super(12, 7, 0, new int[] {-4, -4}, 30, 5, false, true, "Monk");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.side = side;
        quantity = new Random().nextInt(2,5);
        }

    @Override 
    public String getInfo() {
        return "Monk " + super.getInfo();
    }

    @Override
    public void step(){
        Map<Integer, Double> healths = new HashMap<>();
        for (int i = 0; i < gang.size(); i++) {
            healths.put(i, gang.get(i).health / gang.get(i).maxHealth);
        }
        List<Double> a = new ArrayList<>(healths.values().stream().toList());
        Collections.sort(a);
        healths.forEach((index, value) -> {
            if (value.equals(a.get(0))){
                tmpInt = index;
            }
        });

        if(a.get(0) > 0.5) {
            double dist = 1;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
                if (side.get(i).action.equals("Dead")) {
                    continue;
                }
                if (side.get(i).health / side.get(i).maxHealth < dist){
                    dist = side.get(i).health / side.get(i).maxHealth;
                    index = 1;
                }
            }
            if (index < 0){
                index = 0;
            }
            side.get(index).getHit(damage[0] * -1);
            action = "Shooted into " + index;
            return;            
        }
        if (a.get(0).equals(0.0)){
            tmpInt = -1;
            healths.forEach((index, value) -> {
                if (value.equals(0.0)) {
                    if (gang.get(index).getName().equals("Xbowman") || gang.get(index).getName().equals("Monk")){
                        tmpInt = index;
                    }
                }
            });
            if (tmpInt >= 0){
                gang.get(tmpInt).health = 1;
                gang.get(tmpInt).action = "Stand";
                gang.get(tmpInt).quantity = 1;
                action = "Revived " + tmpInt;
            }
            return;
        }
        if (a.get(0) <= 0.5) {
            gang.get(tmpInt).health -= this.damage[0];
            if (gang.get(tmpInt).health > gang.get(tmpInt).maxHealth) {
                gang.get(tmpInt).health = gang.get(tmpInt).maxHealth;
            }
            action = "Treated " + tmpInt;
        }
    } 
}
