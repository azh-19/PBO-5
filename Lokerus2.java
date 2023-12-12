/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lokerus2;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.Scanner;

public class Lokerus2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemLogin sistemLogin = new SistemLogin();

        // Menambahkan contoh pekerjaan
        sistemLogin.addJob("1", "Software Engineer", 3);
        sistemLogin.addJob("2", "Data Scientist", 2);

        while (true) {
            System.out.println("Select your role:");
            System.out.println("1. Customer");
            System.out.println("2. Company");
            System.out.println("3. Exit");
            System.out.print("Choose your role: ");
            int roleChoice = scanner.nextInt();

            switch (roleChoice) {
                case 1:
                    handleCustomerOptions(scanner, sistemLogin);
                    break;
                case 2:
                    handleCompanyOptions(scanner, sistemLogin);
                    break;
                case 3:
                    System.out.println("EProgram berakhir. Terimakasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi");
            }
        }
    }

    private static void handleCustomerOptions(Scanner scanner, SistemLogin sistemLogin) {
        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Kembali");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Masukkan username: ");
                    String customerUsername = scanner.next();
                    System.out.print("Masukkan password: ");
                    String customerPassword = scanner.next();
                    sistemLogin.signUpCustomer(customerUsername, customerPassword);
                }
                case 2 -> {
                    System.out.print("Masukkan username: ");
                    String customerLoginUsername = scanner.next();
                    System.out.print("Masukkan password: ");
                    String customerLoginPassword = scanner.next();
                    sistemLogin.logIn(customerLoginUsername, customerLoginPassword);
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silahkan coba lagi");
            }
        }
    }

    private static void handleCompanyOptions(Scanner scanner, SistemLogin sistemLogin) {
        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Kembali");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Masukkan username: ");
                    String companyUsername = scanner.next();
                    System.out.print("Masukkan password: ");
                    String companyPassword = scanner.next();
                    sistemLogin.signUpCompany(companyUsername, companyPassword);
                }
                case 2 -> {
                    System.out.print("Masukkan username: ");
                    String companyLoginUsername = scanner.next();
                    System.out.print("Masukkan password: ");
                    String companyLoginPassword = scanner.next();
                    sistemLogin.logIn(companyLoginUsername, companyLoginPassword);
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silahkan coba lagi");
            }
        }
    }
}
