package com.edutech.grades.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class QuizResponseEntityTest {
    @Mock
    private List<QuizResponse> responseList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        responseList = new ArrayList<>();
    }

    @Test
    void testCreateQuizResponse() {
        QuizResponse qr = new QuizResponse();
        qr.setId(1);
        qr.setQuizId(2);
        qr.setStudentId(3);
        qr.setSelectedOption("A");
        qr.setResponseContent("Respuesta");
        qr.setAssignmentUrl("url");
        qr.setSubmittedAt(Instant.now());
        responseList.add(qr);
        assertEquals(1, responseList.size());
        assertEquals("A", responseList.get(0).getSelectedOption());
    }

    @Test
    void testReadQuizResponse() {
        QuizResponse qr = new QuizResponse();
        qr.setId(2);
        qr.setResponseContent("Leer");
        responseList.add(qr);
        QuizResponse found = responseList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("Leer", found.getResponseContent());
    }

    @Test
    void testUpdateQuizResponse() {
        QuizResponse qr = new QuizResponse();
        qr.setId(3);
        qr.setResponseContent("Old");
        responseList.add(qr);
        QuizResponse toUpdate = responseList.get(0);
        toUpdate.setResponseContent("New");
        assertEquals("New", responseList.get(0).getResponseContent());
    }

    @Test
    void testDeleteQuizResponse() {
        QuizResponse qr = new QuizResponse();
        qr.setId(4);
        qr.setResponseContent("Borrar");
        responseList.add(qr);
        assertEquals(1, responseList.size());
        responseList.removeIf(x -> x.getId() == 4);
        assertEquals(0, responseList.size());
    }
}
