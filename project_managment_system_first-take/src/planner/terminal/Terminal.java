package planner.terminal;

import planner.app.Planner;

import java.util.Calendar;
import java.util.Scanner;

public class Terminal {

    //Terminal terminal;

    Planner planner = new Planner();
    Scanner input = new Scanner(System.in);

    String m = "";
    String d = "";


    public static void main(String[] args){
        Terminal terminal = new Terminal();
        System.out.println("test");
        terminal.startPrompt();


    }

    public void startPrompt() {
        System.out.println("Velkommen til SoftwareHuset A/S. Vælg venligst en funktion:");
        System.out.println("Indtast et nummer:");
        System.out.println("1: Log in");
        System.out.println("2: Registrer bruger");
        System.out.println("3: ??");

        String in = input.next();
        if (in.equals("1")){
            logIn();
        } else if (in.equals("2")) {
            registerUser();
        } else if (in.equals("3")) {

        } else {
            System.out.println("Ikke godt nok");
            startPrompt();
        }
    }

    private void registerUser() {

    }

    //TODO: Hvad er det vi har testet for i forhold til LOGIN ?
    public void logIn() {
        System.out.println("Indtast brugernavn:");
        String username = input.next();
        System.out.println("Indtast password:");
        String password = input.next();
        boolean error = false;
        try {
            planner.userLogIn(username,password);
        } catch (Exception e) {
            e.printStackTrace();
            error = true;
        }

        if (!error) {
            featureScreen();
        } else {
            logIn();
        }

    }

    private void featureScreen() {
        System.out.println("Indtast et nummer:");
        System.out.println("1: Registrer tid");
        System.out.println("2: Opret projekt");
        System.out.println("3: Opret aktivitet");
        System.out.println("4: ");

        String in = input.next();

        if (in.equals("1")){
            registerTime();
        } else if (in.equals("2")) {
            createProject();
        } else if (in.equals("3")) {
            createActivity();
        } else if (in.equals("4")) {

        } else {
            System.out.println("Ikke godt nok");
            featureScreen();
        }

    }

    private void createActivity() {
        System.out.println("Opretter projekt:");
        System.out.println("Indtast titel:");
        String titel = input.next();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Kendes start tidspunkt? Ja: 1, Nej: 2");
        String x = input.next();
        if (x.equals("1")){
            setTime();
            start.set(2018,Integer.parseInt(m),Integer.parseInt(d));
            
        } else  if (x.equals("2")) {
            //TODO: Create activity i planner ????
        } else {
            System.out.println("Forkerte information - prøv igen");
            createActivity();
        }
    }

    private void setTime() {
        System.out.println("Indtast måned:");
        System.out.println("Indtast -1 for at gå tilbage");
        System.out.println(" 0: Januar \n 1: Februar \n 2: Marts \n 3: April \n 4: Maj \n 5: Juni \n 6: Juli \n" +
                " 7: August \n 8: September \n 9: Oktober \n 10: November \n 11: December");
        m = input.next();

        if (m.matches("0|1|2|3|4|5|6|7|8|9|10|11")) {
            System.out.println("Hvilken dag i måneden?");
            System.out.println("1 - 31");
            d = input.next();
            if (!d.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31")) {
                System.out.println("Prøv igen");
                setTime();
            }
        } else if (m.equals("-1")) {
            createActivity();
        } else {
            System.out.println("Prøv igen");
            setTime();
        }

    }

    private void createProject() {

    }

    private void registerTime() {

    }


}
