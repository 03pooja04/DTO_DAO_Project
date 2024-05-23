package Util;

import ConnectionHelper.ConnectionHelper;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO  implements StudentImplementation {
    private static Connection con = ConnectionHelper.createConnection();
    private static String insertDataQuery = "insert into student values(?,?,?,?)";
    private static String updateDataQuery = "update student set student_Per=? where student_rollNumber= ?";
    private static String deleteDataQuery = "delete student where student_rollNumber=rollNumber";

    public int insertData(Student s) {
        try {
            PreparedStatement pstmt = con.prepareStatement(insertDataQuery);
            pstmt.setInt(1, 0);
            pstmt.setString(2, s.getStudentName());
            pstmt.setString(3, s.getStudentAddress());
            pstmt.setDouble(4, s.getStudentPer());
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int updateData(Student s) {

        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(updateDataQuery);
            pstmt.setDouble(1, s.getStudentPer());


            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int deleteData(Student s) {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(deleteDataQuery);
            pstmt.setInt(1, s.getStudentRollNumber());
            pstmt.setString(1, s.getStudentName());
            int count = pstmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public String displayData() {
        ArrayList<Student> studentList = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(displayData());
            ResultSet rs = pstmt.executeQuery();

              Student s1 = null;

            while (rs.next()) {
            s1=new Student();

            s1.setStudentRollNumber(rs.getInt(1));
            s1.setStudentName(rs.getString(2));
            s1.setStudentAddress(rs.getString(3));
            s1.setStudentPer(rs.getDouble(4));

            studentList.add(s1);
            }
           return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

