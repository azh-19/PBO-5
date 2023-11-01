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

public class Company extends User {
    private List<Job> jobList;

    public Company(String username, String password, String role) {
        super(username, password, role);
        this.jobList = new ArrayList<>();
    }

    public void addJob(Job job) {
        jobList.add(job);
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void viewApplicants(Job job) {
        if (jobList.contains(job)) {
            System.out.println("Applicants for " + job.getJobName() + ": " + job.getApplicants());
        } else {
            System.out.println("Job not found.");
        }
    }
}