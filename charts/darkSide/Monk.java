package charts.darkSide;
import java.util.List;

import System.Vector2;
import charts.Unit;

public class Monk extends Unit{
    public Monk(List<Unit> gang, int x, int y) {
        super(12, 7, 0, new int[] {-4, -4}, 30, 5, false, true, "Monk");
        super.gang = gang;
        super.position = new Vector2(x, y);
        }

    @Override 
    public String getInfo() {
        return "Monk " + super.getInfo();
    }

    // @Override
    // public void step(){
    //     float minHealth = Integer.MAX_VALUE;
    //     int minIndex = -1;
    //     for (int i = 0; i < gang.size(); i++) {
    //         if (gang.get(i).health < gang.get(i).maxHealth){
    //             if (gang.get(i).health < minHealth) {
    //                 minHealth = gang.get(i).health;
    //                 minIndex = i;
    //             }
    //         }
    //     }
    //     if (minHealth >= 0) {
    //         gang.get(minIndex).health -= this.damage[0];
    //         if (gang.get(minIndex).health > gang.get(minIndex).maxHealth){
    //             gang.get(minIndex).health = gang.get(minIndex).maxHealth;
    //         }
    //     }
    // }   
}
