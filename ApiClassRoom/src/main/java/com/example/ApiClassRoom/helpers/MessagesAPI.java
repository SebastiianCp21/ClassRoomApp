package com.example.ApiClassRoom.helpers;

public enum MessagesAPI {

    ATTENDANCE_NOT_FOUND("Attendance record not found"),

    COURSE_NOT_FOUND("Course not found in database"),

    ENROLLMENT_NOT_FOUND("Enrollment not found in database"),

    QUALIFICATION_NOT_FOUND("Qualification not found in database"),

    SUBJECT_NOT_FOUND("Subject not found in database"),

    USER_NOT_FOUND("The user you are looking for is not in the database."),

    STUDENT_NOT_FOUND("The student you are looking for is not in the database."),

    TEACHER_NOT_FOUND("The teacher you are looking for is not in the database.");

    private String text;

    MessagesAPI(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
