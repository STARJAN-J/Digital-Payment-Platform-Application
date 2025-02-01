package StarjanProject.Digital_Payment_Platform_App.exceptionHandling;

import java.util.Random;
import java.util.Scanner;

 

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExceptionHandling {
    public static Scanner sc = new Scanner(System.in);
    public static Random r = new Random();

    // getInt
    public static int Int(String message) {
        while (true) {
            try {
                System.out.print(message);
                int enter = sc.nextInt();
                return enter;
            } catch (Exception e) {
                System.out.println("Enter Only Digit");
                sc.nextLine();
            }
        }
    }

    // getString
    public static String string(String message) {
        
        System.out.print(message);
        String enter = sc.nextLine();
        System.out.println();
        return enter;
    }

    // getChar
    public static char character(String message) {
        
        while (true) {
            try {
                System.out.print(message);
                char enter = sc.next().charAt(0);
                return enter;
            } catch (Exception e) {
                System.out.println("Enter single character");
                sc.nextLine();
            }
        }
    }

    // getDouble
    public static double Double(String message) {
        while (true) {
            try {
                System.out.print(message);
                double enter = sc.nextDouble();
                return enter;
            } catch (Exception e) {
                System.out.println("Enter Only Digit");
                sc.nextLine();
            }
        }
    }

    // clearConsole
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // For Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Linux/Unix/MacOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Unable to clear console.");
        }
    }

    // String to Date format
    public static LocalDate date(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {

            try {
                LocalDate currentDate = LocalDate.parse(date, format);
                // System.out.println(currentDate);
                return currentDate;
                
            } catch (DateTimeParseException e) {
                date = ExceptionHandling.string("Invalid Date Format \nFormat should be dd/MM/yyyy: ");
            }
        }
    }

    // Live date
    public static LocalDate todayDate() {
        return LocalDate.now();
    }







}
