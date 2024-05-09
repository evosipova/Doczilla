package org.example.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private String group;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGroup() {
        return group;
    }
}
