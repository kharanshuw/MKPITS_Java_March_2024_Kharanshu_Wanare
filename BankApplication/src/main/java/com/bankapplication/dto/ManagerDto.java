package com.bankapplication.dto;

public class ManagerDto {

    private int id;

    private String fname;

    private String lname;

    private String rolename;

    public ManagerDto(int id, String rolename, String fname, String lname) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.rolename = rolename;
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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "ManagerDto [id=" + id + ", fname=" + fname + ", lname=" + lname + ", rolename=" + rolename + "]";
    }

    public ManagerDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String concatName() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fname);
        stringBuffer.append(" ");
        stringBuffer.append(lname);
        return stringBuffer.toString();
    }

}
