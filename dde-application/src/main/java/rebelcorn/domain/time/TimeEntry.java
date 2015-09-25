package rebelcorn.domain.time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rebelcorn.domain.project.AbstractProject;

public class TimeEntry {

    private int minutes;
    private List<AbstractProject> projects = new ArrayList<>();
    
    public TimeEntry(int minutes, AbstractProject project) {
        this.minutes = minutes;
        addProject(project);
    }

    public int getMinutes() {
        return minutes;
    }
    
    public void addProject(AbstractProject project) {
        projects.add(project);
    }
    
    public List<AbstractProject> getProjects() {
        return Collections.unmodifiableList(projects);
    }
}
