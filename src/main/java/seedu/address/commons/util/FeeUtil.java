package seedu.address.commons.util;

import java.time.LocalDateTime;

import seedu.address.model.session.RecurringSession;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionDate;
import seedu.address.model.student.Student;

/**
 * Util to calculate the fees
 */
public class FeeUtil {

    /**
     * Gets the total fee between 2 time period for a particular student from {@code startPeriod} to {@code endPeriod}.
     * @param startPeriod Start of time period.
     * @param endPeriod End of time period.
     * @return Total fee between the 2 time period.
     */
    public static double getFeePerStudent(Student student, LocalDateTime startPeriod, LocalDateTime endPeriod) {
        double fee = 0;
        for (Session session : student.getListOfSessions()) {
            if (session instanceof RecurringSession) {
                fee += getRecurringSessionFee((RecurringSession) session, startPeriod, endPeriod);
            } else {
                fee += getSingleSessionFee(session, startPeriod, endPeriod);
            }
        }
        return fee;
    }

    private static double getRecurringSessionFee(RecurringSession recurringSession, LocalDateTime startPeriod,
        LocalDateTime endPeriod) {
        SessionDate startDate = new SessionDate(startPeriod);
        SessionDate endDate = new SessionDate(endPeriod);
        int numOfSession = recurringSession.numOfSessionBetween(startDate, endDate);

        // Ensures that there is more than 0 session, so we can get the fees accordingly
        if (numOfSession > 0) {
            return recurringSession.getFee().getFee() * numOfSession;
        }
        return 0;

    }

    private static double getSingleSessionFee(Session session, LocalDateTime startPeriod, LocalDateTime endPeriod) {
        LocalDateTime dateTime = session.getSessionDate().getDateTime();
        if (dateTime.compareTo(startPeriod) >= 0 && dateTime.compareTo(endPeriod) < 0) {
            // This session date is within the period
            return session.getFee().getFee();
        }
        return 0;
    }
}
