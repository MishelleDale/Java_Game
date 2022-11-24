import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main{
    private static final int GANG_SIZE = 5;
    public static void main(String[] args) {
        List<Unit> whiteSide = new ArrayList<>();
        List<Unit> darkSide = new ArrayList<>();
        while (whiteSide.size() < GANG_SIZE) {
            whiteSide.add(getUnit(0, whiteSide));
            darkSide.add(getUnit(3, darkSide));
            
        }

        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        darkSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        whiteSide.forEach(Unit::step);
        darkSide.forEach(Unit::step);
        System.out.println();
        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        darkSide.forEach(unit -> System.out.println(unit.getInfo()));

        
    }

    private static Unit getUnit(int origin, List<Unit> side) {
        int num = new Random().nextInt(origin, origin +4);
        switch (num) {
            case 0:
                return new Monk(side);
            case 1:
                return new Robber();
            case 2:
                return new Sniper();
            case 3:
                return new Peasant();
            case 4:
                return new Spearman();
            case 5:
                return new Wizard(side);
            default:
                return new Xbowman();
        }
    }

    private static void getType(List<Unit> units, String type) {
        for (Unit unit: units) {
            if (unit.toString().split(" ")[0].equals(type)){
                System.out.println(unit);
            }
        }

    }
}