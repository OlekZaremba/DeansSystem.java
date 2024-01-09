package sql.dao;

import com.example.deanssystem.model.SensitiveData;
import com.example.deanssystem.model.Student;
import sql.tables.ConnectionFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private ConnectionFile connectionFile = new ConnectionFile();
    private Connection connection;

    public boolean addStudentAndSensitiveData(Connection conn, Student student, SensitiveData sensitiveData) {
        String insertStudentSQL = "INSERT INTO " + ConnectionFile.TABLE_STUDENT + " ("
                + ConnectionFile.COLUMN_STUDENT_NAME + ", "
                + ConnectionFile.COLUMN_STUDENT_LASTNAME + ", "
                + ConnectionFile.COLUMN_STUDENT_FIELD_OF_STUDY + ", "
                + ConnectionFile.COLUMN_STUDENT_YEAR_OF_START
                + ") VALUES (?, ?, ?, ?)";

        String insertSensitiveDataSQL = "INSERT INTO " + ConnectionFile.TABLE_SENSITIVE_DATA + " ("
                + ConnectionFile.COLUMN_SENSITIVE_DATA_ID + ", "
                + ConnectionFile.COLUMN_SENSITIVE_DATA_PESEL + ", "
                + ConnectionFile.COLUMN_SENSITIVE_DATA_DATE_OF_BIRTH + ", "
                + ConnectionFile.COLUMN_SENSITIVE_DATA_PLACE_OF_BIRTH + ", "
                + ConnectionFile.COLUMN_SENSITIVE_DATA_MOTHER_NAME + ", "
                + ConnectionFile.COLUMN_SENSITIVE_DATA_FATHER_NAME
                + ") VALUES (?, ?, ?, ?, ?, ?)";


        try {
            conn.setAutoCommit(false);

            PreparedStatement pstmtStudent = conn.prepareStatement(insertStudentSQL, Statement.RETURN_GENERATED_KEYS);
            pstmtStudent.setString(1, student.getName());
            pstmtStudent.setString(2, student.getLastName());
            pstmtStudent.setInt(3, student.getFieldOfStudy());
            pstmtStudent.setInt(4, student.getYearOfStart());
            pstmtStudent.executeUpdate();

            ResultSet rs = pstmtStudent.getGeneratedKeys();
            int generatedStudentId = -1;
            if (rs.next()) {
                generatedStudentId = rs.getInt(1);
            }

            if (generatedStudentId != -1) {
                PreparedStatement pstmtSensitiveData = conn.prepareStatement(insertSensitiveDataSQL);
                pstmtSensitiveData.setInt(1, generatedStudentId);
                pstmtSensitiveData.setString(2, sensitiveData.getPESEL());
                pstmtSensitiveData.setString(3, sensitiveData.getDateOfBirth());
                pstmtSensitiveData.setString(4, sensitiveData.getPlaceOfBirth());
                pstmtSensitiveData.setString(5, sensitiveData.getMotherName());
                pstmtSensitiveData.setString(6, sensitiveData.getFatherName());
                pstmtSensitiveData.executeUpdate();

                conn.commit();
            } else {
                conn.rollback();
                throw new SQLException("Failed to get generated student ID");
            }
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }



        public List<Student> getAllStudents() {
            List<Student> students = new ArrayList<>();
            ConnectionFile connectionFile1 = new ConnectionFile();
            connectionFile1.open();
            try {
                String query = "SELECT * FROM students";
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt(ConnectionFile.COLUMN_STUDENT_STUDENT_ID);
                    String name = rs.getString(ConnectionFile.COLUMN_STUDENT_NAME);
                    String lastName = rs.getString(ConnectionFile.COLUMN_STUDENT_LASTNAME);
                    int fieldOfStudy = rs.getInt(ConnectionFile.COLUMN_STUDENT_FIELD_OF_STUDY);
                    int yearOfStart = rs.getInt(ConnectionFile.COLUMN_STUDENT_YEAR_OF_START);

                    Student student = new Student(id ,name, lastName, fieldOfStudy, yearOfStart);
                    students.add(student);
                }

            } catch (SQLException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }

            return students;
        }
    }

