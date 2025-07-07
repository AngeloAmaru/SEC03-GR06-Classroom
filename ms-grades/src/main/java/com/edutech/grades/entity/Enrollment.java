package com.edutech.grades.entity;

import java.time.Instant;

/**
 * Entity for enrollment table, matching the DB structure.
 */
public class Enrollment {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Instant enrolledAt;
    private String status;

    public Enrollment() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public Instant getEnrolledAt() {
        return enrolledAt;
    }
    public void setEnrolledAt(Instant enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
