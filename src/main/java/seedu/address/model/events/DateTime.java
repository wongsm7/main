package seedu.address.model.events;

import static java.util.Objects.requireNonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Date Time.
 * Guarantees: Date time is validate and immutable.
 */
public class DateTime implements Comparable<DateTime> {

    public static final String DATETIME_FORMAT = "dd/MM/yy HHmm";
    public static final String MESSAGE_CONSTRAINTS =
            "date time must be follow the format of'" + DATETIME_FORMAT + "'.";
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATETIME_FORMAT);
    private final Date time;

    public DateTime(Date date) {
        requireNonNull(date);
        time = date;
    }

    public Date getTime() {
        return time;
    }

    /**
     * Parses a simple date format as described by {@code DATETIME_FORMAT}, else returns null.
     *
     * @param dateString a simple date format
     * @return a {@code DateTime} if valid, otherwise, returns null.
     */
    public static DateTime tryParseSimpleDateFormat(String dateString) {
        requireNonNull(dateString);

        DateTime parsedDateTime;
        try {
            if (dateString.length() != DATETIME_FORMAT.length()) {
                throw new ParseException("invalid date format", -1);
            }
            DATE_FORMATTER.setLenient(false);
            Date parseDate = DATE_FORMATTER.parse(dateString);
            parsedDateTime = new DateTime(parseDate);
        } catch (ParseException ex) {
            parsedDateTime = null;
        }
        return parsedDateTime;
    }

    public boolean before(DateTime other) {
        return compareTo(other) < 0;
    }

    public boolean beforeOrEqual(DateTime other) {
        return compareTo(other) <= 0;
    }

    @Override
    public int compareTo(DateTime d) {
        requireNonNull(d);
        return getTime().compareTo(d.getTime());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DateTime)) {
            return false;
        }

        DateTime otherTiming = (DateTime) other;
        return getTime().equals(otherTiming.getTime());
    }


    @Override
    public String toString() {
        return DATE_FORMATTER.format(time);
    }

}
