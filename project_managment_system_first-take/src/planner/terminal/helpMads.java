package planner.terminal;

import java.util.Scanner;

public class helpMads {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String x = scanner.next();
        System.out.println(x.matches("1|2|3"));

    }

}
