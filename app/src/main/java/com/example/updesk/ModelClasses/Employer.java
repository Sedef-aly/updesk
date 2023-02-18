package com.example.updesk.ModelClasses;

public class Employer {
        private  String EmployerID, EmployerName,EmployerEmail,EmployerOC,
                EmployerPassword,EmployerProfilePhotoUrl;

    public Employer(String employerID, String employerName, String employerEmail, String employerOC, String employerPassword, String employerProfilePhotoUrl) {
        EmployerID = employerID;
        EmployerName = employerName;
        EmployerEmail = employerEmail;
        EmployerOC = employerOC;
        EmployerPassword = employerPassword;
        EmployerProfilePhotoUrl = employerProfilePhotoUrl;
    }

    public String getEmployerID() {
        return EmployerID;
    }

    public void setEmployerID(String employerID) {
        EmployerID = employerID;
    }

    public String getEmployerName() {
        return EmployerName;
    }

    public void setEmployerName(String employerName) {
        EmployerName = employerName;
    }

    public String getEmployerEmail() {
        return EmployerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        EmployerEmail = employerEmail;
    }

    public String getEmployerOC() {
        return EmployerOC;
    }

    public void setEmployerOC(String employerOC) {
        EmployerOC = employerOC;
    }

    public String getEmployerPassword() {
        return EmployerPassword;
    }

    public void setEmployerPassword(String employerPassword) {
        EmployerPassword = employerPassword;
    }

    public String getEmployerProfilePhotoUrl() {
        return EmployerProfilePhotoUrl;
    }

    public void setEmployerProfilePhotoUrl(String employerProfilePhotoUrl) {
        EmployerProfilePhotoUrl = employerProfilePhotoUrl;
    }
}
