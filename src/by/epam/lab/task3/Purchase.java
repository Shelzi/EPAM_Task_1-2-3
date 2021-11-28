package by.epam.lab.task3;

import org.jetbrains.annotations.NotNull;

public class Purchase implements Comparable<Purchase> {
    public static final String NAME = "Beer";
    public static final int PRICE = 499;
    private int number;
    private double percent;
    private WeekDay weekDay;

    public Purchase() {
    }

    public Purchase(int number, double discount, int day) {
        this(number, discount, WeekDay.values()[day]);
    }

    public Purchase(int number, double discount, WeekDay weekDay) {
        this.number = number;
        this.percent = discount;
        this.weekDay = weekDay;
    }

    public String getName() {
        return NAME;
    }

    public int getPrice() {
        return PRICE;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public void setWeekDay(int weekDayByOrder) {
        this.weekDay = WeekDay.values()[weekDayByOrder];
    }

    public void showOrder() {
        System.out.printf("Amount = %d, Discount = %.2f%%, Order day = %s%n", number, percent, weekDay.toString());
    }

    public int findCost() {
        return (int) Math.round(PRICE * number * (100 - percent) / 100);
    }

    @Override
    public String toString() {
        return String.format("%d;%.2f;%s;%d", number, percent, weekDay.toString(), findCost());
    }

    @Override
    public int compareTo(@NotNull Purchase purchase) {
        return (number - purchase.number);
    }
}