package by.gsu.epamlab.task1;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTripsArray = {
                new BusinessTrip("Alexey Agrarov", 1, 1),
                new BusinessTrip("Vadim Soroj", 2, 4),
                null,
                new BusinessTrip("Gena Bykin", 560, 9),
                new BusinessTrip()};

        int maxCost = 0;
        BusinessTrip tripWithMaxCost = new BusinessTrip();
        for (BusinessTrip businessTrip : businessTripsArray) {
            if (businessTrip != null) {
                System.out.printf("Business trip:%n");
                businessTrip.show();
                System.out.printf("%n");
                if (businessTrip.getTotal() > maxCost) {
                    maxCost = businessTrip.getTotal();
                    tripWithMaxCost = businessTrip;
                }
            }
        }
        System.out.println("This is trip with max cost:");
        tripWithMaxCost.show();

        businessTripsArray[businessTripsArray.length - 1].setExpenses(300);

        System.out.printf("Duration: %d%n", businessTripsArray[0].getDaysNumber() +
                businessTripsArray[1].getDaysNumber());

        for (BusinessTrip businessTrip : businessTripsArray) {
            if (businessTrip != null) {
                System.out.printf("%s%n", businessTrip);
            }
        }
    }
}
