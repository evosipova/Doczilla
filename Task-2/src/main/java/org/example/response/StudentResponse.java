package org.example.response;

import org.example.request.StudentRequest;

import java.time.LocalDate;
import java.util.UUID;

@SuppressWarnings("unused")
public class StudentResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String group;

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public StudentResponse mapper(StudentRequest studentRequest, UUID studentId) {
        this.id = studentId;
        this.firstName = studentRequest.getFirstName();
        this.lastName = studentRequest.getLastName();
        this.middleName = studentRequest.getMiddleName();
        this.birthDate = studentRequest.getBirthDate();
        this.group = studentRequest.getGroup();
        return this;
    }

    public UUID getId() {
        return id;
    }
}
