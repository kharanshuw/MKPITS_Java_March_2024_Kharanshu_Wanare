package com.bankapplication.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class ResponseBranchDto {

    private int id;

    @NotNull(message = "branch name should not be empty")
    @Column(name = "branch_name", unique = true)
    @NotEmpty(message = "branch name should not be empty")
    @Size(min = 2, max = 50, message = "branch name must be between 2 to 50 characters")
    private String branchName;

    @NotNull(message = "contact number should not be empty")
    @Size(min = 10, max = 10, message = "contact number must be 10 digits")
    @Pattern(regexp = "^\\d{10}$", message = "invalid phone number format")
    @Column(name = "contact_no")
    private String contactNo;

    private String cityName;

    @Email(message = "Invalid email address")
    @NotNull(message = "email should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "invalid email format")
    private String email;

    private String managerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "branch name should not be empty") @NotEmpty(message = "branch name should not be empty") @Size(min = 2, max = 50, message = "branch name must be between 2 to 50 characters") String getBranchName() {
        return branchName;
    }

    public void setBranchName(@NotNull(message = "branch name should not be empty") @NotEmpty(message = "branch name should not be empty") @Size(min = 2, max = 50, message = "branch name must be between 2 to 50 characters") String branchName) {
        this.branchName = branchName;
    }

    public @NotNull(message = "contact number should not be empty") @Size(min = 10, max = 10, message = "contact number must be 10 digits") @Pattern(regexp = "^\\d{10}$", message = "invalid phone number format") String getContactNo() {
        return contactNo;
    }

    public void setContactNo(@NotNull(message = "contact number should not be empty") @Size(min = 10, max = 10, message = "contact number must be 10 digits") @Pattern(regexp = "^\\d{10}$", message = "invalid phone number format") String contactNo) {
        this.contactNo = contactNo;
    }


    public @Email(message = "Invalid email address") @NotNull(message = "email should not be empty") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email address") @NotNull(message = "email should not be empty") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "invalid email format") String email) {
        this.email = email;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "ResponseBranchDto{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", cityName='" + cityName + '\'' +
                ", email='" + email + '\'' +
                ", managerId='" + managerId + '\'' +
                '}';
    }
}
