package org.example.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.response.StudentResponse;
import org.example.manager.DatabaseManager;
import org.example.request.StudentRequest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class StudentService {

    private final DatabaseManager databaseManager = new DatabaseManager();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public StudentService() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void createStudent(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("application/json");
            StudentRequest studentRequest = objectMapper.readValue(request.getInputStream(), StudentRequest.class);

            StudentResponse studentResponse = databaseManager.addStudent(studentRequest);
            if (studentResponse != null) {
                response.setStatus(HttpServletResponse.SC_CREATED);
                objectMapper.writeValue(response.getWriter(), studentResponse);
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (JsonMappingException | JsonParseException | JsonGenerationException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");

        if (id != null) {

            UUID uuid = UUID.fromString(id);
            databaseManager.deleteStudentById(uuid);
            response.setStatus(HttpServletResponse.SC_OK);

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    public void getStudents(HttpServletResponse response) {

        try {

            response.setContentType("application/json");
            List<StudentResponse> allStudent = databaseManager.getAllStudent();

            objectMapper.writeValue(response.getWriter(), allStudent);
            response.setStatus(HttpServletResponse.SC_OK);

        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

}
