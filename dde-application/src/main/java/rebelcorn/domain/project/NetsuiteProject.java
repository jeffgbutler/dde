package rebelcorn.domain.project;

public class NetsuiteProject extends AbstractProject {

    private String projectNumber;
    
    public NetsuiteProject(String description, String projectNumber) {
        super(description);
        this.projectNumber = projectNumber;
    }

    public String getProjectNumber() {
        return projectNumber;
    }
}
