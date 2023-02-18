package com.example.updesk.ModelClasses;

public class Employee {
    private  String EmployeeID, EmployeeName,EmployeeEmail,EmployeeOC,
            EmployeePassword,EmployeeProfilePhotoUrl;

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        EmployeeEmail = employeeEmail;
    }

    public String getEmployeeOC() {
        return EmployeeOC;
    }

    public void setEmployeeOC(String employeeOC) {
        EmployeeOC = employeeOC;
    }

    public String getEmployeePassword() {
        return EmployeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        EmployeePassword = employeePassword;
    }

    public String getEmployeeProfilePhotoUrl() {
        return EmployeeProfilePhotoUrl;
    }

    public void setEmployeeProfilePhotoUrl(String employeeProfilePhotoUrl) {
        EmployeeProfilePhotoUrl = employeeProfilePhotoUrl;
    }

    public Employee(String employeeID, String employeeName, String employeeEmail, String employeeOC, String employeePassword, String employeeProfilePhotoUrl) {
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        EmployeeEmail = employeeEmail;
        EmployeeOC = employeeOC;
        EmployeePassword = employeePassword;
        EmployeeProfilePhotoUrl = employeeProfilePhotoUrl;
    }
}
