package com.edutech.courses.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourseEntityTest {
    @Mock
    private List<Course> courseList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        courseList = new ArrayList<>();
    }

    @Test
    void testCreateCourse() {
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
        courseList.add(c);
        assertEquals(1, courseList.size());
        assertEquals("Test", courseList.get(0).getTitle());
    }

    @Test
    void testReadCourse() {
        Course c = new Course();
        c.setId(2);
        c.setTitle("Math");
        c.setDescription("Matemáticas");
        courseList.add(c);
        Course found = courseList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("Math", found.getTitle());
    }

    @Test
    void testUpdateCourse() {
        Course c = new Course();
        c.setId(3);
        c.setTitle("Physics");
        c.setDescription("Física");
        courseList.add(c);
        Course toUpdate = courseList.get(0);
        toUpdate.setTitle("Physics II");
        toUpdate.setDescription("Física Avanzada");
        assertEquals("Physics II", courseList.get(0).getTitle());
        assertEquals("Física Avanzada", courseList.get(0).getDescription());
    }

    @Test
    void testDeleteCourse() {
        Course c = new Course();
        c.setId(4);
        c.setTitle("History");
        c.setDescription("Historia");
        courseList.add(c);
        assertEquals(1, courseList.size());
        courseList.removeIf(x -> x.getId() == 4);
        assertEquals(0, courseList.size());
    }
}
