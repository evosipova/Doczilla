package org.example.manager;

import org.example.response.StudentResponse;
import org.example.request.StudentRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class DatabaseManager {

    private Connection connection;

    public StudentResponse addStudent(StudentRequest studentRequest) {

        String query = """
                INSERT INTO students (uid, first_name, last_name, middle_name, birth_date, student_group)
                 VALUES (?, ?, ?, ?, ?, ?)""";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            UUID uuid = UUID.randomUUID();

            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, studentRequest.getFirstName());
            preparedStatement.setString(3, studentRequest.getLastName());
            preparedStatement.setString(4, studentRequest.getMiddleName());
            preparedStatement.setDate(5, Date.valueOf(studentRequest.getBirthDate()));
            preparedStatement.setString(6, studentRequest.getGroup());

            preparedStatement.executeUpdate();
            return new StudentResponse().mapper(studentRequest, uuid);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteStudentById(UUID studentId) {
        String query = "DELETE FROM students WHERE uid = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, studentId.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentResponse> getAllStudent() {

        List<StudentResponse> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                StudentResponse student = new StudentResponse();
                student.setId(UUID.fromString(resultSet.getString("uid")));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
                student.setGroup(resultSet.getString("student_group"));
                students.add(student);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;

    }

    private Connection openConnection() {
        try {
            Properties properties = new Properties();
            String PATH_PROPERTIES = "/application.properties";
            properties.load(DatabaseManager.class.getResourceAsStream(PATH_PROPERTIES));

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/students_db";
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Connection getConnection() {
        if (connection == null) {
            connection = openConnection();
        }
        return connection;
    }

}
