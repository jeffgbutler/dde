package rebelcorn.domain.project;

public abstract class AbstractProject {
    private String description;
    
    public AbstractProject (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
