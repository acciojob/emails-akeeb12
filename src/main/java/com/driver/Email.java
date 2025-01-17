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
        if(oldPassword.equals(this.password) && newPassword.length() >= 8){
            if(check(newPassword) == true){
                this.password = newPassword;
                System.out.println("Password changed successfylly.");
            }
        }
    }

    private boolean check(String newPassword) {
       int Upper = 0,Lower = 0,Digit = 0, Specialc=0;
       for(int i = 0; i < newPassword.length(); i++){
        char ch = newPassword.charAt(i);
        if(ch >= 'A' && ch <= 'Z'){
            Upper++;
        }else if(ch >= 'a' && ch <= 'z'){
            Lower++;
        }else if(ch >= '0' && ch <= '9'){
            Digit++;
        }else{
            Specialc++;
        }
       }
       if(Upper >= 1 && Lower >= 1 && Digit >= 1 && Specialc >= 1){
        return true;
       }
       return false;
    }
}
