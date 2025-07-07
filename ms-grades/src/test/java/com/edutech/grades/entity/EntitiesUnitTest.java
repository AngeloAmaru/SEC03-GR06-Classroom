package com.edutech.grades.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class EntitiesUnitTest {
    @Test
    void testStudentMarkEntity() {
        StudentMark sm = new StudentMark();
        sm.setId(1);
        sm.setQuizId(2);
        sm.setStudentId(3);
        sm.setMark(new BigDecimal("95.5"));
        sm.setComments("Buen trabajo");
        sm.setGradedAt(Instant.now());
        assertEquals(1, sm.getId());
        assertEquals(2, sm.getQuizId());
        assertEquals(3, sm.getStudentId());
        assertEquals(new BigDecimal("95.5"), sm.getMark());
        assertEquals("Buen trabajo", sm.getComments());
        assertNotNull(sm.getGradedAt());
    }

    @Test
    void testQuizResponseEntity() {
        QuizResponse qr = new QuizResponse();
        qr.setId(1);
        qr.setQuizId(2);
        qr.setStudentId(3);
        qr.setSelectedOption("A");
        qr.setResponseContent("Respuesta");
        qr.setAssignmentUrl("url");
        qr.setSubmittedAt(Instant.now());
        assertEquals(1, qr.getId());
        assertEquals(2, qr.getQuizId());
        assertEquals(3, qr.getStudentId());
        assertEquals("A", qr.getSelectedOption());
        assertEquals("Respuesta", qr.getResponseContent());
        assertEquals("url", qr.getAssignmentUrl());
        assertNotNull(qr.getSubmittedAt());
    }

    @Test
    void testCourseQuizEntity() {
        CourseQuiz quiz = new CourseQuiz();
        quiz.setId(1);
        quiz.setCourseId(2);
        quiz.setTitle("Quiz");
        quiz.setDescription("Desc");
        quiz.setQuizType("AUTO");
        quiz.setCreatedAt(Instant.now());
        assertEquals(1, quiz.getId());
        assertEquals(2, quiz.getCourseId());
        assertEquals("Quiz", quiz.getTitle());
        assertEquals("Desc", quiz.getDescription());
        assertEquals("AUTO", quiz.getQuizType());
        assertNotNull(quiz.getCreatedAt());
    }

    @Test
    void testCourseQuizQuestionEntity() {
        CourseQuizQuestion q = new CourseQuizQuestion();
        q.setId(1);
        q.setQuizId(2);
        q.setQuestionText("Q?");
        q.setOptionA("A");
        q.setOptionB("B");
        q.setOptionC("C");
        q.setOptionD("D");
        q.setOptionE("E");
        q.setCorrectAnswer("A");
        q.setCorrectOption("A");
        q.setOrderIndex(1);
        q.setCreatedAt(Instant.now());
        assertEquals(1, q.getId());
        assertEquals(2, q.getQuizId());
        assertEquals("Q?", q.getQuestionText());
        assertEquals("A", q.getOptionA());
        assertEquals("B", q.getOptionB());
        assertEquals("C", q.getOptionC());
        assertEquals("D", q.getOptionD());
        assertEquals("E", q.getOptionE());
        assertEquals("A", q.getCorrectAnswer());
        assertEquals("A", q.getCorrectOption());
        assertEquals(1, q.getOrderIndex());
        assertNotNull(q.getCreatedAt());
    }
}
