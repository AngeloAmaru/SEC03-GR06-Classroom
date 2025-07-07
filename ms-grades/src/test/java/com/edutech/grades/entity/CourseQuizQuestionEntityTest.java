package com.edutech.grades.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourseQuizQuestionEntityTest {
    @Mock
    private List<CourseQuizQuestion> questionList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        questionList = new ArrayList<>();
    }

    @Test
    void testCreateQuizQuestion() {
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
        questionList.add(q);
        assertEquals(1, questionList.size());
        assertEquals("Q?", questionList.get(0).getQuestionText());
    }

    @Test
    void testReadQuizQuestion() {
        CourseQuizQuestion q = new CourseQuizQuestion();
        q.setId(2);
        q.setQuestionText("Leer");
        questionList.add(q);
        CourseQuizQuestion found = questionList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("Leer", found.getQuestionText());
    }

    @Test
    void testUpdateQuizQuestion() {
        CourseQuizQuestion q = new CourseQuizQuestion();
        q.setId(3);
        q.setQuestionText("Old");
        questionList.add(q);
        CourseQuizQuestion toUpdate = questionList.get(0);
        toUpdate.setQuestionText("New");
        assertEquals("New", questionList.get(0).getQuestionText());
    }

    @Test
    void testDeleteQuizQuestion() {
        CourseQuizQuestion q = new CourseQuizQuestion();
        q.setId(4);
        q.setQuestionText("Borrar");
        questionList.add(q);
        assertEquals(1, questionList.size());
        questionList.removeIf(x -> x.getId() == 4);
        assertEquals(0, questionList.size());
    }
}
