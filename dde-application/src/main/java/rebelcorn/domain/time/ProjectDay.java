package rebelcorn.domain.time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import rebelcorn.exception.TooManyMinutesException;

public class ProjectDay {

    private static final int MINUTES_IN_A_DAY = 24 * 60;
    private List<TimeEntry> timeEntries = new ArrayList<>();
    private Date date;

    public ProjectDay(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void addTimeEntry(TimeEntry timeEntry) throws TooManyMinutesException {
        int totalTime = timeEntries.stream().mapToInt(te -> te.getMinutes()).sum();
        if (totalTime + timeEntry.getMinutes() > MINUTES_IN_A_DAY) {
            throw new TooManyMinutesException("Entries cannot total more than 24 hours per day");
        }
        timeEntries.add(timeEntry);
    }

    public List<TimeEntry> getTimeEntries() {
        return Collections.unmodifiableList(timeEntries);
    }

    /**
     * This method will calculate a summary for the day
     * 
     */
    public void calculateDailySummary() {

    }
}
