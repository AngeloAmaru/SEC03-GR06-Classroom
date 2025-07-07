package com.edutech.courses.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourseCategoryEntityTest {
    @Mock
    private List<CourseCategory> categoryList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryList = new ArrayList<>();
    }

    @Test
    void testCreateCategory() {
        CourseCategory cat = new CourseCategory();
        cat.setId(1);
        cat.setName("Robots");
        cat.setDescription("Categoria");
        categoryList.add(cat);
        assertEquals(1, categoryList.size());
        assertEquals("Robots", categoryList.get(0).getName());
    }

    @Test
    void testReadCategory() {
        CourseCategory cat = new CourseCategory();
        cat.setId(2);
        cat.setName("IA");
        cat.setDescription("Inteligencia Artificial");
        categoryList.add(cat);
        CourseCategory found = categoryList.stream().filter(c -> c.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("IA", found.getName());
    }

    @Test
    void testUpdateCategory() {
        CourseCategory cat = new CourseCategory();
        cat.setId(3);
        cat.setName("Data");
        cat.setDescription("Datos");
        categoryList.add(cat);
        CourseCategory toUpdate = categoryList.get(0);
        toUpdate.setName("Data Science");
        toUpdate.setDescription("Ciencia de Datos");
        assertEquals("Data Science", categoryList.get(0).getName());
        assertEquals("Ciencia de Datos", categoryList.get(0).getDescription());
    }

    @Test
    void testDeleteCategory() {
        CourseCategory cat = new CourseCategory();
        cat.setId(4);
        cat.setName("Math");
        cat.setDescription("Matemáticas");
        categoryList.add(cat);
        assertEquals(1, categoryList.size());
        categoryList.removeIf(c -> c.getId() == 4);
        assertEquals(0, categoryList.size());
    }
}