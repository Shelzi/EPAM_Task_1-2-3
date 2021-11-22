package by.epam.lab.task3;

import org.jetbrains.annotations.NotNull;

public class Purchase implements Comparable<Purchase>{
    private String name;
    private int price;
    private int number;
    private int percent;

    public Purchase() {

    }

    public Purchase(String name, int price, int number, int discount) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.percent = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
       return price * number * (100 - percent)/100;
    }

    @Override
    public String toString() {
        return name + ';' +
                price + ';' +
                number + ';' +
                percent;
    }

    @Override
    public int compareTo(@NotNull Purchase o) {
        return 0;
    }
}
