package com.edutech.grades.service;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.grades.entity.CourseQuiz;
import com.edutech.grades.mapper.CourseQuizMapperManual;
import com.edutech.grades.repository.CourseQuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseQuizServiceTest {
    @Mock
    private CourseQuizRepository courseQuizRepository;
    @Mock
    private CourseQuizMapperManual courseQuizMapper;
    @InjectMocks
    private CourseQuizService courseQuizService;

    private CourseQuiz courseQuiz;
    private CourseQuizDTO courseQuizDTO;

    @BeforeEach
    void setUp() {
        courseQuiz = new CourseQuiz();
        courseQuiz.setId(1);
        courseQuiz.setCourseId(2);
        courseQuiz.setTitle("Quiz");
        courseQuiz.setDescription("Desc");
        courseQuiz.setQuizType("AUTO");
        courseQuiz.setCreatedAt(Instant.now());

        courseQuizDTO = new CourseQuizDTO();
        courseQuizDTO.setId(1);
        courseQuizDTO.setCourseId(2);
        courseQuizDTO.setTitle("Quiz");
        courseQuizDTO.setDescription("Desc");
        courseQuizDTO.setQuizType("AUTO");
        courseQuizDTO.setCreatedAt(courseQuiz.getCreatedAt());
    }

    @Test
    void testFindAll_Success() {
        List<CourseQuiz> quizzes = Arrays.asList(courseQuiz);
        when(courseQuizRepository.findAll()).thenReturn(quizzes);
        when(courseQuizMapper.toDTO(courseQuiz)).thenReturn(courseQuizDTO);
        List<CourseQuizDTO> result = courseQuizService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Quiz", result.get(0).getTitle());
        verify(courseQuizRepository).findAll();
    }

    @Test
    void testFindById_Success() {
        when(courseQuizRepository.findById(1)).thenReturn(Optional.of(courseQuiz));
        when(courseQuizMapper.toDTO(courseQuiz)).thenReturn(courseQuizDTO);
        CourseQuizDTO result = courseQuizService.findById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(courseQuizRepository).findById(1);
    }

    @Test
    void testFindById_NotFound() {
        when(courseQuizRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> courseQuizService.findById(99));
    }
}
