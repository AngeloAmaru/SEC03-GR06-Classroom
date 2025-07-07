package com.edutech.grades.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StudentMarkEntityTest {
    @Mock
    private List<StudentMark> markList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        markList = new ArrayList<>();
    }

    @Test
    void testCreateStudentMark() {
        StudentMark sm = new StudentMark();
        sm.setId(1);
        sm.setQuizId(2);
        sm.setStudentId(3);
        sm.setMark(new BigDecimal("95.5"));
        sm.setComments("Buen trabajo");
        sm.setGradedAt(Instant.now());
        markList.add(sm);
        assertEquals(1, markList.size());
        assertEquals("Buen trabajo", markList.get(0).getComments());
    }

    @Test
    void testReadStudentMark() {
        StudentMark sm = new StudentMark();
        sm.setId(2);
        sm.setQuizId(3);
        sm.setStudentId(4);
        sm.setMark(new BigDecimal("88.0"));
        sm.setComments("Comentario");
        sm.setGradedAt(Instant.now());
        markList.add(sm);
        StudentMark found = markList.stream().filter(m -> m.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("Comentario", found.getComments());
    }

    @Test
    void testUpdateStudentMark() {
        StudentMark sm = new StudentMark();
        sm.setId(3);
        sm.setQuizId(4);
        sm.setStudentId(5);
        sm.setMark(new BigDecimal("70.0"));
        sm.setComments("Old");
        sm.setGradedAt(Instant.now());
        markList.add(sm);
        StudentMark toUpdate = markList.get(0);
        toUpdate.setComments("Updated");
        toUpdate.setMark(new BigDecimal("99.0"));
        assertEquals("Updated", markList.get(0).getComments());
        assertEquals(new BigDecimal("99.0"), markList.get(0).getMark());
    }

    @Test
    void testDeleteStudentMark() {
        StudentMark sm = new StudentMark();
        sm.setId(4);
        sm.setQuizId(5);
        sm.setStudentId(6);
        sm.setMark(new BigDecimal("60.0"));
        sm.setComments("ToDelete");
        sm.setGradedAt(Instant.now());
        markList.add(sm);
        assertEquals(1, markList.size());
        markList.removeIf(m -> m.getId() == 4);
        assertEquals(0, markList.size());
    }
}
