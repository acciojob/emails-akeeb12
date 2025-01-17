package com.driver;

public class Email {
    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!oldPassword.equals(this.password)) {
            System.out.println("Old password is incorrect");
            return;
        }
        if (isValidPassword(newPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully");
        } else {
            System.out.println("New password does not meet the criteria");
        }
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isLowerCase(c)) hasLowercase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecialChar = true;
        }
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
