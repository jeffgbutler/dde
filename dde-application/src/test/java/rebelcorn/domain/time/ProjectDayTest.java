package rebelcorn.domain.time;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import rebelcorn.domain.project.BugzillaTicket;
import rebelcorn.domain.time.ProjectDay;
import rebelcorn.domain.time.TimeEntry;
import rebelcorn.exception.TooManyMinutesException;

public class ProjectDayTest {

    @Test
    public void testTooManyMinutes() {
        ProjectDay pd = new ProjectDay(new Date());
        BugzillaTicket bt = new BugzillaTicket("Dummey Ticket", "ATT-TKT 6234");
        
        // make 24 hours worth of time entries - this should work
        for (int i = 0; i < 24; i++) {
            TimeEntry te = new TimeEntry(60, bt);
            try {
                pd.addTimeEntry(te);
            } catch (TooManyMinutesException e) {
                Assert.fail(e.getMessage());
            }
        }
        
        // now try to add one more minute - should fail
        TimeEntry te = new TimeEntry(1, bt);
        try {
            pd.addTimeEntry(te);
            Assert.fail("Project day allowed more than 24 hours");
        } catch (TooManyMinutesException e) {
            // this should happen
        }
    }
}
