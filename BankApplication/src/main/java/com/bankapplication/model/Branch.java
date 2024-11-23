package com.bankapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Table(name = "branch")
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Email(message = "Invalid email address")
    @NotNull(message = "email should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "invalid email format")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = true)
    private UserDetails managerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public @NotNull(message = "contact number should not be empty") @Size(min = 10, max = 10, message = "contact number must be 10 digits") @Pattern(regexp = "^\\d{10}$", message = "invalid phone number format") String getContactNo() {
        return contactNo;
    }

    public void setContactNo(@NotNull(message = "contact number should not be empty") @Size(min = 10, max = 10, message = "contact number must be 10 digits") @Pattern(regexp = "^\\d{10}$", message = "invalid phone number format") String contactNo) {
        this.contactNo = contactNo;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public @Email(message = "Invalid email address") @NotNull(message = "email should not be empty") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email address") @NotNull(message = "email should not be empty") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "invalid email format") String email) {
        this.email = email;
    }

    public UserDetails getManagerId() {
        return managerId;
    }


    public void setManagerId(UserDetails managerId) {
        this.managerId = managerId;
    }

    /**
     * Retrieves the full name of the manager by concatenating their first and last names.
     *
     * @return the full name of the manager
     */
    public String getManagerNameString() {
        String managerFirstName = "";
        String managerLastName = "";
        try {
            // Retrieve manager's first name
            managerFirstName = managerId.getFname();
            if (managerFirstName.isEmpty() || managerFirstName == null) {
                managerFirstName = "No";
            }

            // Retrieve manager's last name
            managerLastName = managerId.getLname();
            if (managerLastName.isEmpty() || managerLastName == null) {
                managerLastName = "Manager Assigned";
            }
        } catch (NullPointerException e) {
            // Log exception and return a default value or handle appropriately
            System.err.println("Exception occurred while retrieving manager's name: " + e.getMessage());

            return "No Manager Assigned";
        }
        // Using StringBuilder for better performance in single-threaded contexts
        StringBuilder managerName = new StringBuilder();
        managerName.append(managerFirstName);
        managerName.append(" ").append(managerLastName);


        return managerName.toString();
    }

    public String getCityName() {
        return city.getCityName();
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", city=" + city +
                ", email='" + email + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}
