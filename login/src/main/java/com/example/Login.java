package com.example;

public class Login {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public boolean LogOn(String emailInput, String passwordInput) {
        if (getEmail() == emailInput && getPassword() == passwordInput) {
            return true;
        } else if (getEmail() == emailInput && getPassword() != passwordInput) {
            return false;
        } else {
            return false;
        }
    }

}
