/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lokerus2;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class SistemLogin {
   private Map<String, User> userDatabase = new HashMap();
   private Map<String, Job> jobDatabase = new HashMap();
   private Map<String, Job> selectedJobs = new HashMap();
   private String currentUserRole = "";
   private String currentUsername = "";

   SistemLogin() {
   }

   public void signUpCustomer(String username, String password) {
      this.signUp(username, password, "customer");
   }

   public void signUpCompany(String username, String password) {
      this.signUp(username, password, "company");
   }

   public void addJob(String jobId, String jobTitle, int jobQuota) {
      this.jobDatabase.put(jobId, new Job(jobId, jobTitle, jobQuota));
   }

   private void signUp(String username, String password, String role) {
      if (this.userDatabase.containsKey(username)) {
         System.out.println("Username sudah ada. Silahkan masukkan username yang berbeda");
      } else {
         if ("company".equalsIgnoreCase(role)) {
            this.userDatabase.put(username, new Company(username, password));
         } else {
            this.userDatabase.put(username, new User(username, password, role));
         }

         System.out.println("Sign up berhasil!");
         this.currentUserRole = role;
      }
   }

   public void logIn(String username, String password) {
      if (this.userDatabase.containsKey(username) && ((User)this.userDatabase.get(username)).getPassword().equals(password)) {
         System.out.println("Log in berhasil!");
         this.currentUsername = username;
         User currentUser = (User)this.userDatabase.get(username);
         if ("company".equalsIgnoreCase(currentUser.getRole())) {
            this.handleCompanyOptions();
         } else if ("customer".equalsIgnoreCase(currentUser.getRole())) {
            this.handleCustomerOptions();
         }
      } else {
         System.out.println("Username tidak valid. Silahkan coba lagi!");
      }

   }

   private void handleCustomerOptions() {
      while(true) {
         System.out.println("1. Lihat pekerjaan yang tersedia");
         System.out.println("2. Lihat pekerjaan yang dipilih");
         System.out.println("3. Kembali");
         System.out.print("Pilihan: ");
         Scanner scanner = new Scanner(System.in);
         int choice = scanner.nextInt();
         switch (choice) {
            case 1 -> this.showAvailableJobs();
            case 2 -> this.showSelectedJobs();
            case 3 -> {
                return;
              }
            default -> System.out.println("Pilihan tidak valid. Coba lagi");
         }
      }
   }

   private void handleCompanyOptions() {
      Company currentCompany = (Company)this.userDatabase.get(this.currentUsername);

      label21:
      while(true) {
         System.out.println("1. Tambah Pekerjaan");
         System.out.println("2. Lihat daftar pekerjaan");
         System.out.println("3. Kembali");
         System.out.print("Pilihan: ");
         Scanner scanner = new Scanner(System.in);
         int choice = scanner.nextInt();
         switch (choice) {
            case 1:
               System.out.print("Masukkan ID pekerjaan: ");
               String jobId = scanner.next();
               System.out.print("Masukkan nama pekerjaan: ");
               String jobTitle = scanner.next();
               System.out.print("Masukkan kuota pekerjaan: ");
               int jobQuota = scanner.nextInt();
               currentCompany.addJob(jobId, jobTitle, jobQuota);
               System.out.println("Pekerjaan berhasil ditambahkan!");
               break;
            case 2:
               System.out.println("Daftar Pekerjaan:");
               Iterator var8 = currentCompany.getJobList().values().iterator();

               while(true) {
                  if (!var8.hasNext()) {
                     continue label21;
                  }

                  Job job = (Job)var8.next();
                  PrintStream var10000 = System.out;
                  String var10001 = job.getJobId();
                  var10000.println(var10001 + ". " + job.getJobTitle() + " - Kuota: " + job.getJobQuota());
               }
            case 3:
               return;
            default:
               System.out.println("Pilihan tidak valid.Coba lagi.");
         }
      }
   }

   private void showAvailableJobs() {
      System.out.println("Pekerjaan yang tersedia:");
      Iterator var2 = this.jobDatabase.values().iterator();

      PrintStream var10000;
      String var10001;
      while(var2.hasNext()) {
         Job job = (Job)var2.next();
         var10000 = System.out;
         var10001 = job.getJobId();
         var10000.println(var10001 + ". " + job.getJobTitle() + " - Kuota: " + job.getJobQuota());
      }

      var2 = this.userDatabase.values().iterator();

      while(true) {
         User user;
         do {
            if (!var2.hasNext()) {
               System.out.print("Masukkan ID pekerjaan yang ingin dipilih (atau tekan '0' untuk kembali): ");
               Scanner scanner = new Scanner(System.in);
               String selectedJobId = scanner.next();
               if (!selectedJobId.equals("0")) {
                  if (this.jobDatabase.containsKey(selectedJobId)) {
                     Job selectedJob = (Job)this.jobDatabase.get(selectedJobId);
                     if (selectedJob.getJobQuota() > 0) {
                        this.selectedJobs.put(selectedJobId, selectedJob);
                        selectedJob.decrementQuota();
                        System.out.println("Berhasil memilih pekerjaan!");
                        this.notifyCompany(selectedJob);
                     } else {
                        System.out.println("Kuota pekerjaan sudah penuh. Silahkan pilih pekerjaan yang lain.");
                     }
                  } else {
                     Iterator var12 = this.userDatabase.values().iterator();

                     while(var12.hasNext()) {
                        User user = (User)var12.next();
                        if ("company".equalsIgnoreCase(user.getRole())) {
                           Company company = (Company)user;
                           if (company.getJobList().containsKey(selectedJobId)) {
                              Job selectedJob = (Job)company.getJobList().get(selectedJobId);
                              if (selectedJob.getJobQuota() > 0) {
                                 this.selectedJobs.put(selectedJobId, selectedJob);
                                 selectedJob.decrementQuota();
                                 System.out.println("Berhasil memilih pekerjaan!");
                                 this.notifyCompany(selectedJob);
                                 return;
                              }

                              System.out.println("Kuota pekerjaan sudah penuh. Silahkan pilih pekerjaan yang lain.");
                              return;
                           }
                        }
                     }

                     System.out.println("Pekerjaan tidak valid. Silahkan coba lagi.");
                  }
               }

               return;
            }

            user = (User)var2.next();
         } while(!"company".equalsIgnoreCase(user.getRole()));

         Company company = (Company)user;
         Iterator var5 = company.getJobList().values().iterator();

         while(var5.hasNext()) {
            Job companyJob = (Job)var5.next();
            var10000 = System.out;
            var10001 = companyJob.getJobId();
            var10000.println(var10001 + ". " + companyJob.getJobTitle() + " - Kuota: " + companyJob.getJobQuota() + " (Added by " + user.getUsername() + ")");
         }
      }
   }

   private void showSelectedJobs() {
      System.out.println("Pekerjaan yang dipilih:");
      Iterator var2 = this.selectedJobs.values().iterator();

      while(var2.hasNext()) {
         Job job = (Job)var2.next();
         PrintStream var10000 = System.out;
         String var10001 = job.getJobId();
         var10000.println(var10001 + ". " + job.getJobTitle());
      }

   }

   private void notifyCompany(Job selectedJob) {
      Iterator var3 = this.userDatabase.values().iterator();

      while(var3.hasNext()) {
         User user = (User)var3.next();
         if ("company".equalsIgnoreCase(user.getRole())) {
            Company company = (Company)user;
            if (company.getJobList().containsKey(selectedJob.getJobId())) {
               String var10001 = this.currentUsername;
               System.out.println("Customer " + var10001 + " has selected job: " + selectedJob.getJobTitle());
               company.acceptSelectedJob(selectedJob.getJobId());
            }
         }
      }
    }
}
