/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lokerus2;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.ArrayList;
import java.util.List;

class Job {
   private String jobId;
   private String jobTitle;
   private int jobQuota;
   private boolean accepted;

   public Job(String jobId, String jobTitle, int jobQuota) {
      this.jobId = jobId;
      this.jobTitle = jobTitle;
      this.jobQuota = jobQuota;
      this.accepted = false;
   }

   public String getJobId() {
      return this.jobId;
   }

   public String getJobTitle() {
      return this.jobTitle;
   }

   public int getJobQuota() {
      return this.jobQuota;
   }

   public boolean isAccepted() {
      return this.accepted;
   }

   public void acceptJob() {
      this.accepted = true;
   }

   public void decrementQuota() {
      --this.jobQuota;
   }
}
