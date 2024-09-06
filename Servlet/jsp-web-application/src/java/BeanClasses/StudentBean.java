/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

/**
 *
 * @author Kharanshu
 */
public class StudentBean {

    private String nameString;

    private String rollnoString;

    private int marks;

    public StudentBean(String nameString, String rollnoString, int marks) {
	this.nameString = nameString;
	this.rollnoString = rollnoString;
	this.marks = marks;
    }

    public StudentBean() {
    }

    public String getNameString() {
	return nameString;
    }

    public String getRollnoString() {
	return rollnoString;
    }

    public int getMarks() {
	return marks;
    }

    public void setNameString(String nameString) {
	this.nameString = nameString;
    }

    public void setRollnoString(String rollnoString) {
	this.rollnoString = rollnoString;
    }

    public void setMarks(int marks) {
	this.marks = marks;
    }

    public String checkpass() {
	if (marks > 35) {
	    return "pass";
	} else {
	    return "fail";
	}
    }

}
