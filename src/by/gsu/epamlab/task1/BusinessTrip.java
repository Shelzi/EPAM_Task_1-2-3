package by.gsu.epamlab.task1;

public class BusinessTrip {

    public static final int DAILY_RATE = 3;
    private String account;
    private int expenses;
    private int daysNumber;

    public BusinessTrip() {

    }

    public BusinessTrip(String accountId, int transportExpenses, int numberOfDays) {
        this.account = accountId;
        this.expenses = transportExpenses;
        this.daysNumber = numberOfDays;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        this.daysNumber = daysNumber;
    }

    public int getTotal() {
        return expenses + DAILY_RATE * daysNumber;
    }

    public void show() {
        System.out.printf("rate = %s %naccount = %s %ntransport = %s %ndays = %d %ntotal = %s%n",
                pennyToRuble(DAILY_RATE),
                account,
                pennyToRuble(expenses),
                daysNumber,
                pennyToRuble(getTotal()));
    }

    public static String pennyToRuble(int pennyToConvert) {
        return String.format("%d.%02d", pennyToConvert / 100, pennyToConvert % 100);
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%s", account, pennyToRuble(expenses), daysNumber, pennyToRuble(this.getTotal()));
    }
}
