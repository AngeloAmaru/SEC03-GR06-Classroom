package com.edutech.courses.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourseContentEntityTest {
    @Mock
    private List<CourseContent> contentList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contentList = new ArrayList<>();
    }

    @Test
    void testCreateContent() {
        CourseContent cc = new CourseContent();
        cc.setId(1);
        cc.setCourseId(2);
        cc.setTitle("Intro");
        cc.setContentType("Video");
        cc.setUrl("url");
        cc.setOrderIndex(1);
        contentList.add(cc);
        assertEquals(1, contentList.size());
        assertEquals("Intro", contentList.get(0).getTitle());
    }

    @Test
    void testReadContent() {
        CourseContent cc = new CourseContent();
        cc.setId(2);
        cc.setTitle("Tema 2");
        contentList.add(cc);
        CourseContent found = contentList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("Tema 2", found.getTitle());
    }

    @Test
    void testUpdateContent() {
        CourseContent cc = new CourseContent();
        cc.setId(3);
        cc.setTitle("Old");
        contentList.add(cc);
        CourseContent toUpdate = contentList.get(0);
        toUpdate.setTitle("New");
        assertEquals("New", contentList.get(0).getTitle());
    }

    @Test
    void testDeleteContent() {
        CourseContent cc = new CourseContent();
        cc.setId(4);
        cc.setTitle("Borrar");
        contentList.add(cc);
        assertEquals(1, contentList.size());
        contentList.removeIf(x -> x.getId() == 4);
        assertEquals(0, contentList.size());
    }
}
