package by.epam.lab.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    private static final int FIRST_SCAN_VALUE = 0;
    private static final int SECOND_SCAN_VALUE = 1;
    private static final int THIRD_SCAN_VALUE = 2;
    private static final int SEARCH_NUMBER_VALUE = 5;

    public static void main(String[] args) {
        Purchase[] purchases = parsePurchaseFromTxt();
        for (Purchase a : purchases) {
            System.out.println(a);
        }
        calculatePurchasesStatistic(purchases);
        Arrays.sort(purchases);
        System.out.printf("Name = %s%nPrice = %d%n", Purchase.NAME, Purchase.PRICE);
        for (Purchase purchase : purchases) {
            purchase.showOrder();
        }
        Purchase key = new Purchase(SEARCH_NUMBER_VALUE, 0, 0);
        System.out.println(purchases[Arrays.binarySearch(purchases, key)]);
    }

    private static Purchase[] parsePurchaseFromTxt() {
        Purchase[] purchases = new Purchase[]{};
        String filepath = "src\\in.txt";
        try (Scanner scan = new Scanner(new FileReader(filepath))) {
            scan.useLocale(Locale.ENGLISH);
            if (scan.hasNext() && scan.hasNextInt()) {
                purchases = new Purchase[scan.nextInt()];
                scan.useDelimiter("\r\n");
                if (purchases.length != 0) {
                    for (int i = 0; i < purchases.length; i++) {
                        String[] line = scan.next().split(" ");
                        purchases[i] = new Purchase(Integer.parseInt(line[FIRST_SCAN_VALUE]),
                                Double.parseDouble(line[SECOND_SCAN_VALUE]),
                                WeekDay.values()[Integer.parseInt(line[THIRD_SCAN_VALUE])]);
                    }
                } else {
                    System.out.println("PURCHASES NUMBER is 0");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return purchases;
    }

    private static void calculatePurchasesStatistic(Purchase[] purchases) {
        System.out.printf("Name = %s%nPrice = %d%n", Purchase.NAME, Purchase.PRICE);
        int totalCost = 0;
        int totalCostMonday = 0;
        int maxCost = 0;
        WeekDay weekDayMaxCost = null;
        if (purchases.length != 0) {
            for (Purchase purchase : purchases) {
                purchase.showOrder();
            }
            for (Purchase purchase : purchases) {
                int tempCost = purchase.findCost();
                if (tempCost > maxCost) {
                    maxCost = tempCost;
                    weekDayMaxCost = purchase.getWeekDay();
                }
                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    totalCostMonday += tempCost;
                }
                totalCost += tempCost;
            }
        }
        double meanCost = purchases.length != 0 ? (double) totalCost / purchases.length : 0.0;
        System.out.printf("Mean cost = %s%n" +
                        "Total cost on Mondays= %s%n" +
                        "Day with max cost = %s%n" +
                        "Max cost = %s%n",
                Converter.pennyToRuble(meanCost),
                Converter.pennyToRuble(totalCostMonday),
                weekDayMaxCost,
                Converter.pennyToRuble(maxCost));
    }
}