package by.epam.lab.task3;

import org.jetbrains.annotations.NotNull;

public class Purchase implements Comparable<Purchase> {
    private final String name = "Beer";
    private final int price = 500;
    private int number;
    private int percent;
    private WeekDay weekDay;

    public Purchase() {
    }

    public Purchase(int number, int discount, WeekDay weekDay) {
        this.number = number;
        this.percent = discount;
        this.weekDay = weekDay;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getCost() {
        return price * number * (100 - percent) / 100;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    //public void setWeekDayByOrder(int)

    @Override
    public String toString() {
        return String.format("%s;%d;%d;%d", name, price, number, percent);
    }

    @Override
    public int compareTo(@NotNull Purchase purchase) {
        return number - purchase.number;
    }
}
