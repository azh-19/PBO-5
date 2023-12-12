/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lokerus2;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.HashMap;
import java.util.Map;

class Company extends User {
private final Map<String, Job> jobList = new HashMap();

   public Company(String username, String password) {
      super(username, password, "company");
   }

   public Map<String, Job> getJobList() {
      return this.jobList;
   }

   public void addJob(String jobId, String jobTitle, int jobQuota) {
      this.jobList.put(jobId, new Job(jobId, jobTitle, jobQuota));
   }

   public void acceptSelectedJob(String jobId) {
      if (this.jobList.containsKey(jobId)) {
         Job selectedJob = (Job)this.jobList.get(jobId);
         selectedJob.acceptJob();
         System.out.println("Job '" + selectedJob.getJobTitle() + "' accepted from customer!");
      } else {
         System.out.println("Invalid job ID");
      }

   }
}
