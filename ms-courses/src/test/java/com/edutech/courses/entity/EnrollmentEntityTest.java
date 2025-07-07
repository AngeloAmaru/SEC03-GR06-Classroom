package com.edutech.courses.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentEntityTest {
    @Mock
    private List<Enrollment> enrollmentList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        enrollmentList = new ArrayList<>();
    }

    @Test
    void testCreateEnrollment() {
        Enrollment e = new Enrollment();
        e.setId(1);
        e.setStudentId(2);
        e.setCourseId(3);
        e.setEnrolledAt(Instant.now());
        e.setStatus("ACTIVE");
        enrollmentList.add(e);
        assertEquals(1, enrollmentList.size());
        assertEquals("ACTIVE", enrollmentList.get(0).getStatus());
    }

    @Test
    void testReadEnrollment() {
        Enrollment e = new Enrollment();
        e.setId(2);
        e.setStatus("READ");
        enrollmentList.add(e);
        Enrollment found = enrollmentList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("READ", found.getStatus());
    }

    @Test
    void testUpdateEnrollment() {
        Enrollment e = new Enrollment();
        e.setId(3);
        e.setStatus("Old");
        enrollmentList.add(e);
        Enrollment toUpdate = enrollmentList.get(0);
        toUpdate.setStatus("New");
        assertEquals("New", enrollmentList.get(0).getStatus());
    }

    @Test
    void testDeleteEnrollment() {
        Enrollment e = new Enrollment();
        e.setId(4);
        e.setStatus("Borrar");
        enrollmentList.add(e);
        assertEquals(1, enrollmentList.size());
        enrollmentList.removeIf(x -> x.getId() == 4);
        assertEquals(0, enrollmentList.size());
    }
}
