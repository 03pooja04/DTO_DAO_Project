package Util;
import Model.Student;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class MainApp {

    private static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        operation();
    }

    private static void operation() {
        boolean status = true;
        while (status) {

            System.out.println("1. SAVE DATA   ");
            System.out.println("2. UPDATE DATA   ");
            System.out.println("3. DELETE DATA   ");
            System.out.println("4. DISPLAY DATA   ");
            System.out.println("ENTER YOUR CHOICE");
            System.out.println("-------------------");
            int choice = sc1.nextInt();
            switch (choice) {
                case 1:
                    saveData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    deleteData();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("THANK U FOR VISITING");
                    status = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        }
    }

    private static void saveData() {
        System.out.println("ENTER YOUR FULL NAME");
        String fullName = sc1.nextLine().toUpperCase();
        System.out.println("ENTER YOUR ADDRESS");
        String address = sc1.nextLine().toUpperCase();
        System.out.println("ENTER YOUR PERCENTAGE");
        double percentage = sc1.nextDouble();


        Student s1 = new Student();
        s1.setStudentName(fullName);
        s1.setStudentAddress(address);
        s1.setStudentPer(percentage);

        DAO dao = new DAO();
        int result = dao.insertData(s1);

        if (result > 0) {
            System.out.println("DATA INSERTED SUCCESSFULLY");
        } else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }

    private static void updateData() {
        System.out.println("ENTER STUDENT ROLLNUMBER");
        int rollNumber = sc1.nextInt();
        System.out.println("ENTER PERCENTAGE");
        double per = sc1.nextDouble();

        Student s1 = new Student();
        s1.setStudentRollNumber(rollNumber);
        s1.setStudentPer(per);

        StudentImplementation si = new DAO();
        int result = si.updateData(s1);

        if (result > 0) {
            System.out.println(result + "DATA UPLOADED SUCCESSFULLY");
        } else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }
    private static void deleteData() {
        System.out.println("ENTER STUDENT ROLLNUMBER");
        int id = sc1.nextInt();

        Student s1 = new Student();
        s1.setStudentRollNumber(id);

        StudentImplementation si = new DAO() ;
        int result = si.deleteData(s1);

        if (result > 0) {
            System.out.println(result + " DATA DELETED SUCCESSFULLY");
        } else {
            System.out.println("SOMETHING WENT WRONG");
        }
    }


    private static void displayData(){
        StudentImplementation s1=new DAO();
        ArrayList<Student> studentData=new ArrayList<>();
        System.out.println("ROLL NO\t \t NAME\t\t ADDRESS \t\t PERCENTAGE");
        for (Student s:studentData){
            System.out.println(s.getStudentRollNumber()+"\t\t"+s.getStudentName()+"\t\t"+s.getStudentAddress()+"\t\t"+s.getStudentPer());

        }
        System.out.println("-----------------------------------------");
    }
}


