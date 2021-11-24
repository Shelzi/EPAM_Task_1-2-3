package by.epam.lab.task3;

import java.util.Locale;

public enum WeekDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public String toString() {
        return this.name().toLowerCase();
    }
}
