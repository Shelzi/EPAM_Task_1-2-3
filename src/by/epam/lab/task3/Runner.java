package by.epam.lab.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Purchase[] PURCHASES_NUMBER = new Purchase[]{};

        String filepath = "src\\in.txt";
        try (Scanner scan = new Scanner(new FileReader(filepath))) {
            scan.useLocale(Locale.ENGLISH);
            if (scan.hasNext() && scan.hasNextInt()) {
                PURCHASES_NUMBER = new Purchase[scan.nextInt()];
                if (PURCHASES_NUMBER.length != 0) {
                    for (int i = 0; i < PURCHASES_NUMBER.length; i++) {
                        PURCHASES_NUMBER[i] = new Purchase();
                        String test = scan.next();
                        if (scan.hasNextInt()) {
                            PURCHASES_NUMBER[i].setNumber(scan.nextInt());
                        }
                        if (scan.hasNextInt()) {
                            PURCHASES_NUMBER[i].setPercent(scan.nextInt());
                        }
                        if (scan.hasNextInt()) {
                            scan.nextInt(); // для корректной работы на данный момент
                            PURCHASES_NUMBER[i].setWeekDay(WeekDay.values()[scan.nextInt()]);
                        }
                    }
                } else {
                    System.out.println("PURCHASES NUMBER is 0");
                }
            }
            if (PURCHASES_NUMBER != null) {
                for (Purchase a : PURCHASES_NUMBER) {
                    System.out.println(a);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        WeekDay day = WeekDay.values()[5];
        System.out.println(day);
        System.out.println(WeekDay.MONDAY);
    }
}

