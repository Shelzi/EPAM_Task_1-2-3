package by.epam.lab.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    private static final int FIRST_SCAN_VALUE = 0;
    private static final int SECOND_SCAN_VALUE = 1;
    private static final int THIRD_SCAN_VALUE = 2;

    public static void main(String[] args) {
        Purchase[] PURCHASES_NUMBER = new Purchase[]{};
        String filepath = "src\\in.txt";
        try (Scanner scan = new Scanner(new FileReader(filepath))) {
            scan.useLocale(Locale.ENGLISH);
            if (scan.hasNext() && scan.hasNextInt()) {
                PURCHASES_NUMBER = new Purchase[scan.nextInt()];
                scan.useDelimiter("\r\n");
                if (PURCHASES_NUMBER.length != 0) {
                    for (int i = 0; i < PURCHASES_NUMBER.length; i++) {
                        String[] line = scan.next().split(" ");
                        PURCHASES_NUMBER[i] = new Purchase(Integer.parseInt(line[FIRST_SCAN_VALUE]),
                                Integer.parseInt(line[SECOND_SCAN_VALUE]),
                                WeekDay.values()[Integer.parseInt(line[THIRD_SCAN_VALUE])]);
                    }
                } else {
                    System.out.println("PURCHASES NUMBER is 0");
                }
            }
            for (Purchase a : PURCHASES_NUMBER) {
                System.out.println(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

