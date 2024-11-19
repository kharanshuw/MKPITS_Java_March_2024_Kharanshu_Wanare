package com.bankapplication.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "userdetails")
@EntityListeners(AuditingEntityListener.class)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 to 50 characters")
    private String fname;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 to 50 characters")
    private String lname;

    @Column(name = "phoneno", unique = true)
    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phoneno;

    @Column(name = "date_of_birth")
    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate dob;

    @Column(name = "gender")
    @NotEmpty(message = "gender should not be empty")
    private String gender;

    // created date should be inserted 1st time only
    // update not
    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createdate;

    // lastmodified date should be updated only
    // insert date not allowd
    @LastModifiedDate
    @Column(name = "lastmodified_at", insertable = false)
    private LocalDateTime lastmodified;

    // created by should be inserted 1st time only
    // update not
    @CreatedBy
    @Column(name = "create_by", nullable = false, updatable = false)
    private Integer createBy;

    // modifiability should be updated only
    // insert not
    @LastModifiedBy
    @Column(name = "lastmodified_by", insertable = false)
    private Integer lastmodifiedby;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDetails")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    @JsonManagedReference
    private City city;


    @PrePersist
    public void prepersist() {
        this.createBy = getcurrentuserid();
        this.createdate = LocalDateTime.now();
    }

    public Integer getcurrentuserid() {
        Integer idInteger = users.getId();
        return idInteger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    public LocalDateTime getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(LocalDateTime lastmodified) {
        this.lastmodified = lastmodified;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(Integer lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }


    public @Past(message = "Date of birth must be in the past") LocalDate getDob() {
        return dob;
    }

    public void setDob(@Past(message = "Date of birth must be in the past") LocalDate dob) {
        this.dob = dob;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
        users.setUserDetails(this);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
