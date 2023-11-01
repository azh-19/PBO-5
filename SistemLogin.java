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


public class SistemLogin {
    private List<User> users;

    public SistemLogin() {
        this.users = new ArrayList<>();
    }

    public void addAccount(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}