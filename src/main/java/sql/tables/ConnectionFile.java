package sql.tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFile {

    public static final String DB_NAME = "basedata.db";
    public static final String CONNECTION_STRING =  "jdbc:sqlite:D:\\JavaProjekty\\DeansSystem\\" + DB_NAME;
    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_STUDENT_STUDENT_ID = "studentId";
    public static final String COLUMN_STUDENT_NAME = "name";
    public static final String COLUMN_STUDENT_LASTNAME = "lastName";
    public static final String COLUMN_STUDENT_FIELD_OF_STUDY = "fieldOfStudy";
    public static final String COLUMN_STUDENT_YEAR_OF_START = "yearOfStart";
    public static final String TABLE_SENSITIVE_DATA = "sensitiveData";
    public static final String COLUMN_SENSITIVE_DATA_ID = "_id";
    public static final String COLUMN_SENSITIVE_DATA_PESEL = "PESEL";
    public static final String COLUMN_SENSITIVE_DATA_DATE_OF_BIRTH = "dateOfBirth";
    public static final String COLUMN_SENSITIVE_DATA_PLACE_OF_BIRTH = "placeOfBirth";
    public static final String COLUMN_SENSITIVE_DATA_MOTHER_NAME = "motherName";
    public static final String COLUMN_SENSITIVE_DATA_FATHER_NAME = "fatherName";
    public static final String TABLE_SUBJECTS = "subjects";
    public static final String COLUMN_SUBJECTS_SUBJECT_ID = "subjectId";
    public static final String COLUMN_SUBJECTS_SUBJECT_NAME = "subjectName";
    public static final String TABLE_FIELDS = "fields";
    public static final String COLUMN_FIELDS_FIELD_ID = "fieldId";
    public static final String COLUMN_FIELDS_FILED_NAME = "fieldName";
    public static final String TABLE_FIELD_SUBJECT = "FieldSubject";
    public static final String COLUMN_FIELD_SUBJECT_FIELD_ID = "fieldId";
    public static final String COLUMN_FILED_SUBJECT_SUBJECT_ID = "subjectId";


    private Connection conn;

    public boolean open(){
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;

        } catch (SQLException e) {

            System.out.println("Couldn't connect: " + e.getMessage());
            return false;
        }

    }

    public Connection getConn() {
        return conn;
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

}
