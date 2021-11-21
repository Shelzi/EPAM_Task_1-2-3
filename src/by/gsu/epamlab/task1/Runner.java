package by.gsu.epamlab.task1;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTripsArray = {
                new BusinessTrip("Alexey Agrarov", 150, 6),
                new BusinessTrip("Vadim Soroj", 234, 12),
                null,
                new BusinessTrip("Gena Bykin", 560, 9),
                new BusinessTrip()};

        for (BusinessTrip businessTrip : businessTripsArray) {
            if (businessTrip != null) {
                System.out.printf("Business trip:%n");
                businessTrip.show();
                System.out.printf("%n");
            }
        }

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
