/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lokerus;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LokerUs {
    public static void main(String[] args) {
        SistemLogin sistemLogin = new SistemLogin();
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job ("Job 1", "Description 1"));
        jobs.add(new Job ("Job 2", "Description 2"));
        
        boolean isLoggedIn = false;
        String username = "";
        String password = "";
        String role = "";
        
        while (true) {
            System.out.println("Selamat datang di Sistem Login");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Keluar");
            System.out.print("Pilih tindakan (1/2/3): ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka 1, 2, atau 3.");
                continue;
            }

            if (choice == 1) {
                System.out.print("Masukkan username: ");
                username = scanner.next();
                System.out.print("Masukkan password: ");
                password = scanner.next();
                
                isLoggedIn = true;
                System.out.println("Selamat datang, " + username + "!");

                User loggedInAccount = sistemLogin.login(username, password);

                if (loggedInAccount != null) {
                    System.out.println("Login berhasil sebagai " + loggedInAccount.getRole() + ": " + loggedInAccount.getUsername());
                    // Implementasikan logika setelah login (customer atau company)
                    if (loggedInAccount.getRole().equals("customer")) {
                        Customer loggedInCustomer = (Customer) loggedInAccount;
                        System.out.println("Kualifikasi: " + loggedInCustomer.getQualification());
                        // Logika interaksi dengan akun pelanggan
                    } else if (loggedInAccount.getRole().equals("company")) {
                        Company loggedInCompany = (Company) loggedInAccount;
                        System.out.println("Anda telah login sebagai perusahaan.");
                        System.out.println("1. Keluar");
                        System.out.println("2. Lanjutkan sebagai perusahaan");

                        int companyChoice = Integer.parseInt(scanner.nextLine());
                        if (companyChoice == 1) {
                            break; 
                        } else if (companyChoice == 2) {
                            // Implementasikan logika interaksi dengan akun perusahaan di sini
                        } else {
                            System.out.println("Pilihan tidak valid. Harap masukkan 1 atau 2.");
                        }
                    }
                } else {
                    System.out.println("Username atau password salah. Silakan coba lagi.");
                }
            } else if (choice == 2) {
                System.out.print("Masukkan username: ");
                username = scanner.next();
                System.out.print("Masukkan password: ");
                password = scanner.next();
                
                isLoggedIn = true;
                System.out.println("Selamat datang, " + username + "!");

                System.out.println("Pilih peran: ");
                System.out.println("1. Customer");
                System.out.println("2. Company");
                role = scanner.next();
                
                if (role.equalsIgnoreCase("customer")) {
                    System.out.println("Daftar pekerjaan yang tersedia:");
                    for(int i=0; i<jobs.size(); i++) {
                        System.out.println((i+1) + ". " + jobs.get(i).jobName);
                    }
                    
                    System.out.println("Pilih pekerjaan yang ingin anda ambil:");
                    int jobChoice = scanner.nextInt();
                    
                    if (jobChoice >= 1 && jobChoice <= jobs.size()) {
                        Job selectedJob = jobs.get(jobChoice - 1);
                        System.out.println("Anda telah memilih pekerjaan: " + selectedJob.jobName);
                        System.out.println("Deskripsi pekerjaan: " + selectedJob.description);
                    } else {
                        System.out.println("Pilihan tidak valid");
                    }
                } else if (role.equalsIgnoreCase("Company")) {
                    System.out.println("Masukkan judul pekerjaan baru: ");
                    scanner.nextLine();
                    String newJobName = scanner.nextLine();
                    System.out.println("Masukkan deskripsi pekerjaan baru: ");
                    String newJobDescription = scanner.nextLine();
                    
                    Job newJob = new Job(newJobName, newJobDescription);
                    jobs.add(newJob);
                } else {
                    System.out.println("Pilihan peran tidak valid");
                }

            } else if (choice == 3) {
                System.out.println("Terima kasih telah menggunakan Sistem Login.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan 1, 2, atau 3.");
            }
        }

        scanner.close();
    }
}