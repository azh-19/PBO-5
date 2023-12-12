/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lokerus2;

/**
 *
 * @author Azhar Nurulhaifa
 */
class User {
   private String username;
   private String password;
   private String role;

   public User(String username, String password, String role) {
      this.username = username;
      this.password = password;
      this.role = role;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }

   public String getRole() {
      return this.role;
   }
}