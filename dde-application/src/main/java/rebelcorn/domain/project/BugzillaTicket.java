package rebelcorn.domain.project;

public class BugzillaTicket extends AbstractProject {

    private String ticketNumber;
    
    public BugzillaTicket(String description, String ticketNumber) {
        super(description);
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
}
