package com.edutech.courses.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntitiesUnitTest {
    @Test
    void testCourseEntity() {
        Course c = new Course();
        c.setId(1);
        c.setTitle("Test");
        c.setDescription("Desc");
        c.setCategoryId(2);
        c.setManagerId(3);
        c.setInstructorId(4);
        c.setPublishDate(LocalDate.now());
        c.setPrice(new BigDecimal("99.99"));
        c.setImage("img.png");
        c.setStatus("ACTIVE");
        assertEquals(1, c.getId());
        assertEquals("Test", c.getTitle());
        assertEquals("Desc", c.getDescription());
        assertEquals(2, c.getCategoryId());
        assertEquals(3, c.getManagerId());
        assertEquals(4, c.getInstructorId());
        assertNotNull(c.getPublishDate());
        assertEquals(new BigDecimal("99.99"), c.getPrice());
        assertEquals("img.png", c.getImage());
        assertEquals("ACTIVE", c.getStatus());
    }

    @Test
    void testCourseCategoryEntity() {
        CourseCategory cat = new CourseCategory();
        cat.setId(1);
        cat.setName("Robots");
        cat.setDescription("Categoria");
        assertEquals(1, cat.getId());
        assertEquals("Robots", cat.getName());
        assertEquals("Categoria", cat.getDescription());
    }

    @Test
    void testCourseContentEntity() {
        CourseContent cc = new CourseContent();
        cc.setId(1);
        cc.setCourseId(2);
        cc.setTitle("Intro");
        cc.setContentType("Video");
        cc.setUrl("url");
        cc.setOrderIndex(1);
        assertEquals(1, cc.getId());
        assertEquals(2, cc.getCourseId());
        assertEquals("Intro", cc.getTitle());
        assertEquals("Video", cc.getContentType());
        assertEquals("url", cc.getUrl());
        assertEquals(1, cc.getOrderIndex());
    }

    @Test
    void testCourseCommentEntity() {
        CourseComment cc = new CourseComment();
        cc.setId(1);
        cc.setCourseId(2);
        cc.setUserId(3);
        cc.setCommentText("Comentario");
        cc.setRating(5);
        cc.setCreatedAt(Instant.now());
        assertEquals(1, cc.getId());
        assertEquals(2, cc.getCourseId());
        assertEquals(3, cc.getUserId());
        assertEquals("Comentario", cc.getCommentText());
        assertEquals(5, cc.getRating());
        assertNotNull(cc.getCreatedAt());
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

    @Test
    void testEnrollmentEntity() {
        Enrollment e = new Enrollment();
        e.setId(1);
        e.setStudentId(2);
        e.setCourseId(3);
        e.setEnrolledAt(Instant.now());
        e.setStatus("ACTIVE");
        assertEquals(1, e.getId());
        assertEquals(2, e.getStudentId());
        assertEquals(3, e.getCourseId());
        assertNotNull(e.getEnrolledAt());
        assertEquals("ACTIVE", e.getStatus());
    }
}
