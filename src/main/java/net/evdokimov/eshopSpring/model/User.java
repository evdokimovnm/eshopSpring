package net.evdokimov.eshopSpring.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    @Length(min = 3, max = 14, message = "Login should have 3-14 letters")
    private String login;
    @NotBlank
    @Length(min = 4, max = 16, message = "Password should have 4-16 letters")
    private String password;
    private String email;
    private String role = "customer";

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
