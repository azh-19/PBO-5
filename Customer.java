/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lokerus;

/**
 *
 * @author Azhar Nurulhaifa
 */
public class Customer extends User {
    private String qualification;

    public Customer(String username, String password, String role, String qualification) {
        super(username, password, role);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role='" + getRole() + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}