package assignment9;

public abstract class Employee {
    public abstract void calculatingSalary();
    public abstract void employeeInformation();

}


package assignment9;

public class HourlyEmployee extends Employee {
    private String name;
    private long id;
    private int hours;
    private double wage;

    public HourlyEmployee(int hours, long id, String name, double wage) {
        this.hours = hours;
        this.id = id;
        this.name = name;
        this.wage = wage;
    }

    public HourlyEmployee() {
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }


    @Override
    public void calculatingSalary() {
        double totalsalary=hours*wage;
        System.out.println(totalsalary);
    }

    @Override
    public void employeeInformation() {
        System.out.println(name+" "+id);
    }
}



package assignment9;

public class SalariedEmployee extends Employee {
    private String name;
    private int id;
    private int days;
    private double salary;

    public SalariedEmployee(int days, int id, String name, double salary) {
        this.days = days;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public SalariedEmployee() {
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void calculatingSalary() {
        double totalsalary=salary*days;
        System.out.println(totalsalary);
    }

    @Override
    public void employeeInformation() {
        System.out.println(name+" "+id );
    }
}
