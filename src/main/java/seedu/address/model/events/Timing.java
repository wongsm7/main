//shawns version
package seedu.address.model.events;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a Date time in the schedule.
 * Guarantees: immutable; is valid as declared in {@link #isValidTimingFromCurrentTime(DateTime, DateTime)}
 */
public class Timing implements Comparable<Timing> {

    public static final String MESSAGE_CONSTRAINTS =
            "The event start timing must be before the end timing and after current dateTime.";

    private final DateTime startTiming;
    private final DateTime endTiming;

    /**
     * Constructs a {@code Timing}.
     *
     * @param startTiming A valid dateTime describing the start of event.
     * @param endTiming   A valid dateTime describing the end of event.
     */
    public Timing(DateTime startTiming, DateTime endTiming) {
        requireAllNonNull(startTiming, endTiming);
        checkArgument(isValidTiming(startTiming, endTiming), MESSAGE_CONSTRAINTS);

        this.startTiming = startTiming;
        this.endTiming = endTiming;
    }

    /**
     * Returns true if the start dateTime is before the end dateTime.
     */
    public static boolean isValidTiming(DateTime testStart, DateTime testEnd) {
        requireAllNonNull(testStart, testEnd);
        return testStart.getTime().before(testEnd.getTime());
    }

    /**
     * Returns true if the start dateTime is before the end dateTime.
     */
    public static boolean isValidTimingFromCurrentTime(DateTime testStart, DateTime testEnd) {
        Date current = new Date();
        return isValidTiming(testStart, testEnd) && testStart.getTime().after(current);
    }

    public DateTime getStartTime() {
        return startTiming;
    }

    public DateTime getEndTime() {
        return endTiming;
    }

    /**
     * Returns true if the endtime is before current time.
     */
    public Boolean hasMissedTiming() {
        Date current = new Date();
        return getEndTime().getTime().before(current);
    }

    /**
     * Returns true if the another timing is staggering within the start or end dateTime.
     */
    public boolean conflictsWith(Timing other) {
        requireNonNull(other);
        return other != this
                && getStartTime().before(other.getEndTime())
                && other.getStartTime().before(getEndTime());
    }

    @Override
    public String toString() {
        return String.format("%s - %s", startTiming.toString(), endTiming.toString());
    }

    @Override
    public int compareTo(Timing t) {
        requireNonNull(t);
        int cmpStartTimingResult = t.getStartTime().compareTo(getStartTime());
        if (cmpStartTimingResult != 0) {
            return cmpStartTimingResult;
        }

        return t.getEndTime().compareTo(getEndTime());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Timing)) {
            return false;
        }

        Timing otherTiming = (Timing) other;
        return otherTiming.getStartTime().equals(getStartTime())
                && otherTiming.getEndTime().equals(getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTiming, endTiming);
    }
}
