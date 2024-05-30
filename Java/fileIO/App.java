import java.util.Scanner;
import java.util.*;
import myfile.Fileoperations;

import myfile.Student;

public class App { 
    public static void main(String[] args)  {
        Student student=null;
        Scanner scanner=new Scanner(System.in);
        Fileoperations fileoperations=new Fileoperations();
        try {
           int choice=0;
            while (choice !=3) {
                System.out.println("enter choices 1.add student 2.display 3.exit");
                 choice=scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("emter name id gpa rollnumber ");
                        String nameString=scanner.next();
                        String idString=scanner.next();
                        String gpaString=scanner.next();
                        String rollString=scanner.next();
                        Student student1=new Student(nameString, idString, gpaString, rollString);
                        fileoperations.writeStudent(student1);
                        break;
                    case 2:
                    //Student student3=fileoperations.readstudent();
                    //System.out.println(student3.toString());
                    List <Student> student3=fileoperations.readAllStudents();
                    for (Student student2 : student3) {
                        System.out.println(student2);
                    }
                    break;
                    case 3 :
                    System.exit(0);
                    default:
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}