package assignment9;

public class Person {
    private String name;
    private long id;
    private String number;

    public Person() {
    }

    public Person(long id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void  displayInfo(){
        System.out.println(id+" "+number+" "+name);
    }

}


package assignment9;

public class Student extends Person{
    String rollno;

    public Student(String rollno) {
        this.rollno = rollno;
    }

    public Student(long id, String name, String number, String rollno) {
        super(id, name, number);
        this.rollno = rollno;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
}


package assignment9;

public class Teacher extends Person{
   private String subject;

    public Teacher(String subject) {
        this.subject = subject;
    }

    public Teacher(long id, String name, String number, String subject) {
        super(id, name, number);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
