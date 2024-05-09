CREATE TABLE IF NOT EXISTS students (
    uid VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    birth_date DATE NOT NULL,
    student_group VARCHAR(50) NOT NULL
);