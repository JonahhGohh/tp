package seedu.address.model.session;

import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Represents the date and time of the session
 */
public class SessionDate {

    public static final String MESSAGE_CONSTRAINTS = "Format of date and time "
            + "should be of the format "
            + "YYYY-MM-DD and HH:MM.";

    private LocalDateTime dateTime;

    /**
     * Constructs a {@code SessionDate}.
     * Guarantees that {@code dateValue} and {@code timeValue} creates a valid SessionDate
     *
     * @param dateValue string of date in YYYY-MM-DD format
     * @param timeValue string of time in HH:MM format
     */
    public SessionDate(String dateValue, String timeValue) {
        try {
            LocalDate localDate = LocalDate.parse(dateValue);
            LocalTime localTime = LocalTime.parse(timeValue);

            this.dateTime = localDate.atTime(localTime);
        } catch (DateTimeParseException e) {
            checkArgument(false, MESSAGE_CONSTRAINTS + e.getMessage());
        }
    }

    /**
     * Constructs a {@code SessionDate} based on combined dateTime argument
     * @param dateTime string of date and time in YYYY-MM-DDTHH:MM:SS (ISO8601 format)
     */
    public SessionDate(String dateTime) {
        try {
            this.dateTime = LocalDateTime.parse(dateTime);
        } catch (DateTimeParseException e) {
            checkArgument(false, MESSAGE_CONSTRAINTS + e.getMessage());
        }
    }

    /**
     * Constructs a {@code SessionDate} using a {@code LocalDateTime} object.
     */
    public SessionDate(LocalDateTime localDateTime) {
        requireAllNonNull(localDateTime);
        this.dateTime = localDateTime;
    }

    /**
     * Creates a new {@code SessionDate} representing the date time where the session ends.
     * @param duration duration of the session.
     * @return a new end {@code SessionDate}
     */
    public SessionDate getEndSessionDate(Duration duration) {
        return new SessionDate(this.dateTime.plusMinutes((long) duration.getValue()));
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public boolean isSameTime(SessionDate sessionDate) {
        return getTime().equals(sessionDate.getTime());
    }

    public SessionDate setDate(LocalDate localDate) {
        return new SessionDate(LocalDateTime.of(localDate, getTime()));
    }

    /**
     * Returns the number of calendar days between this inclusive, sessionDate exclusive.
     * @param sessionDate the other sessionDate
     * @return number of calendar days
     */
    public int numOfDayTo(SessionDate sessionDate) {
        return (int) ChronoUnit.DAYS.between(getDate(), sessionDate.getDate());
    }

    /**
     * Returns true if LocalTime and LocalDate of both objects are the same
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof SessionDate)) {
            return false;
        }

        SessionDate sessionDate = (SessionDate) other;

        return this.dateTime.toLocalDate().equals(sessionDate.dateTime.toLocalDate())
                && this.dateTime.toLocalTime().equals(sessionDate.dateTime.toLocalTime());
    }

    /**
     * Returns true if user input {@code dateValue} and {@code timeValue} makes a valid sessionDate.
     * @param dateValue the string date
     * @param timeValue the string value
     * @return true if valid SessionDate
     */
    public static boolean isValidSessionDate(String dateValue, String timeValue) {
        try {
            LocalDate localDate = LocalDate.parse(dateValue);
            LocalTime localTime = LocalTime.parse(timeValue);

            LocalDateTime localDateTime = localDate.atTime(localTime);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return dateTime.toString();
    }
}
