package System;
import Main;
import java.util.Collections;
import java.util.List;


import charts.Unit;

public class ConsoleView {

    
    private static int step = 1;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view() {
        if (step ==1 ){
            System.out.println(AnsiColors.ANSI_RED+"First step."+AnsiColors.ANSI_RESET);
        } else {
            System.out.println(AnsiColors.ANSI_RED+"Step №" + step +"."+AnsiColors.ANSI_RESET);
        }
        step++;
        System.out.println(ConsoleView.top10);

        int step = 0;
        for (int i = 1; i <= Main.GANG_SIZE-1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }

            System.out.print("|  " ); 
            if (step < Main.GANG_SIZE-1) {
                System.out.print(AnsiColors.ANSI_GREEN + Main.whiteSide.get(step).getCharacter() + "    ");
                System.out.println(AnsiColors.ANSI_BLUE + Main.darkSide.get(step).getCharacter() + AnsiColors.ANSI_RESET);
                step++;
            }
           
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, 10)));
        }
        System.out.println("|  " + AnsiColors.ANSI_GREEN + Main.whiteSide.get(step).getCharacter() + "    " + AnsiColors.ANSI_BLUE + Main.darkSide.get(step).getCharacter() + AnsiColors.ANSI_RESET);


        System.out.println(ConsoleView.bottom10);
        System.out.println("Press Enter.");

        System.out.println();

    }

    public static String formatDiv(String str){
        return str.replace('a', '\u250c')
            .replace('b', '\u252c')
            .replace('c', '\u2510')
            .replace('d', '\u251c')
            .replace('e', '\u253c')
            .replace('f', '\u2524')
            .replace('g', '\u2514')
            .replace('h', '\u2534')
            .replace('i', '\u2518')
            .replace('-', '\u2500');       

    }

    private static String getChar(Vector2 position){
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEquals(position)) str = "|"+AnsiColors.ANSI_BLUE + Main.darkSide.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
            if (Main.whiteSide.get(i).getPosition().isEquals(position)) str = "|" + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
        }
        return str;
    }

       private static String getCharacher(List<Unit> name){
        return null;
    }

    
}
