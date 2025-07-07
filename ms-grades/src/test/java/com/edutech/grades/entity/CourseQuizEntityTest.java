package com.edutech.grades.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourseQuizEntityTest {
    @Mock
    private List<CourseQuiz> quizList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        quizList = new ArrayList<>();
    }

    @Test
    void testCreateQuiz() {
        CourseQuiz q = new CourseQuiz();
        q.setId(1);
        q.setCourseId(2);
        q.setTitle("Quiz");
        q.setDescription("Desc");
        q.setQuizType("AUTO");
        q.setCreatedAt(Instant.now());
        quizList.add(q);
        assertEquals(1, quizList.size());
        assertEquals("Quiz", quizList.get(0).getTitle());
    }

    @Test
    void testReadQuiz() {
        CourseQuiz q = new CourseQuiz();
        q.setId(2);
        q.setTitle("Leer");
        quizList.add(q);
        CourseQuiz found = quizList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("Leer", found.getTitle());
    }

    @Test
    void testUpdateQuiz() {
        CourseQuiz q = new CourseQuiz();
        q.setId(3);
        q.setTitle("Old");
        quizList.add(q);
        CourseQuiz toUpdate = quizList.get(0);
        toUpdate.setTitle("New");
        assertEquals("New", quizList.get(0).getTitle());
    }

    @Test
    void testDeleteQuiz() {
        CourseQuiz q = new CourseQuiz();
        q.setId(4);
        q.setTitle("Borrar");
        quizList.add(q);
        assertEquals(1, quizList.size());
        quizList.removeIf(x -> x.getId() == 4);
        assertEquals(0, quizList.size());
    }
}
