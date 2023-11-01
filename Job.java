/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lokerus;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.ArrayList;
import java.util.List;

public class Job {
    public String jobName;
    public String description;
    private List<String> applicants;

    public Job(String jobName, String description) {
        this.jobName = jobName;
        this.description = description;
    }

    public String getJobName() {
        return jobName;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getApplicants() {
        return applicants;
    }

    @Override
    public String toString() {
        return jobName + ": " + description;
    }

}