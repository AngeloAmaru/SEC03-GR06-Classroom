package com.edutech.courses.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourseCommentEntityTest {
    @Mock
    private List<CourseComment> commentList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        commentList = new ArrayList<>();
    }

    @Test
    void testCreateComment() {
        CourseComment cc = new CourseComment();
        cc.setId(1);
        cc.setCourseId(2);
        cc.setUserId(3);
        cc.setCommentText("Comentario");
        cc.setRating(5);
        cc.setCreatedAt(Instant.now());
        commentList.add(cc);
        assertEquals(1, commentList.size());
        assertEquals("Comentario", commentList.get(0).getCommentText());
    }

    @Test
    void testReadComment() {
        CourseComment cc = new CourseComment();
        cc.setId(2);
        cc.setCommentText("Leer");
        commentList.add(cc);
        CourseComment found = commentList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("Leer", found.getCommentText());
    }

    @Test
    void testUpdateComment() {
        CourseComment cc = new CourseComment();
        cc.setId(3);
        cc.setCommentText("Old");
        commentList.add(cc);
        CourseComment toUpdate = commentList.get(0);
        toUpdate.setCommentText("New");
        assertEquals("New", commentList.get(0).getCommentText());
    }

    @Test
    void testDeleteComment() {
        CourseComment cc = new CourseComment();
        cc.setId(4);
        cc.setCommentText("Borrar");
        commentList.add(cc);
        assertEquals(1, commentList.size());
        commentList.removeIf(x -> x.getId() == 4);
        assertEquals(0, commentList.size());
    }
}
