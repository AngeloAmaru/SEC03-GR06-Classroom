package com.edutech.grades.service;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.grades.entity.CourseQuizQuestion;
import com.edutech.grades.mapper.CourseQuizQuestionMapperManual;
import com.edutech.grades.repository.CourseQuizQuestionRepository;
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
class CourseQuizQuestionServiceTest {
    @Mock
    private CourseQuizQuestionRepository courseQuizQuestionRepository;
    @Mock
    private CourseQuizQuestionMapperManual courseQuizQuestionMapper;
    @InjectMocks
    private CourseQuizQuestionService courseQuizQuestionService;

    private CourseQuizQuestion courseQuizQuestion;
    private CourseQuizQuestionDTO courseQuizQuestionDTO;

    @BeforeEach
    void setUp() {
        courseQuizQuestion = new CourseQuizQuestion();
        courseQuizQuestion.setId(1);
        courseQuizQuestion.setQuizId(2);
        courseQuizQuestion.setQuestionText("Q?");
        courseQuizQuestion.setOptionA("A");
        courseQuizQuestion.setOptionB("B");
        courseQuizQuestion.setOptionC("C");
        courseQuizQuestion.setOptionD("D");
        courseQuizQuestion.setOptionE("E");
        courseQuizQuestion.setCorrectAnswer("A");
        courseQuizQuestion.setCorrectOption("A");
        courseQuizQuestion.setOrderIndex(1);
        courseQuizQuestion.setCreatedAt(Instant.now());

        courseQuizQuestionDTO = new CourseQuizQuestionDTO();
        courseQuizQuestionDTO.setId(1);
        courseQuizQuestionDTO.setQuizId(2);
        courseQuizQuestionDTO.setQuestionText("Q?");
        courseQuizQuestionDTO.setOptionA("A");
        courseQuizQuestionDTO.setOptionB("B");
        courseQuizQuestionDTO.setOptionC("C");
        courseQuizQuestionDTO.setOptionD("D");
        courseQuizQuestionDTO.setOptionE("E");
        courseQuizQuestionDTO.setCorrectAnswer("A");
        courseQuizQuestionDTO.setCorrectOption("A");
        courseQuizQuestionDTO.setOrderIndex(1);
        courseQuizQuestionDTO.setCreatedAt(courseQuizQuestion.getCreatedAt());
    }

    @Test
    void testFindAll_Success() {
        List<CourseQuizQuestion> questions = Arrays.asList(courseQuizQuestion);
        when(courseQuizQuestionRepository.findAll()).thenReturn(questions);
        when(courseQuizQuestionMapper.toDTO(courseQuizQuestion)).thenReturn(courseQuizQuestionDTO);
        List<CourseQuizQuestionDTO> result = courseQuizQuestionService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Q?", result.get(0).getQuestionText());
        verify(courseQuizQuestionRepository).findAll();
    }

    @Test
    void testFindById_Success() {
        when(courseQuizQuestionRepository.findById(1)).thenReturn(Optional.of(courseQuizQuestion));
        when(courseQuizQuestionMapper.toDTO(courseQuizQuestion)).thenReturn(courseQuizQuestionDTO);
        CourseQuizQuestionDTO result = courseQuizQuestionService.findById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(courseQuizQuestionRepository).findById(1);
    }

    @Test
    void testFindById_NotFound() {
        when(courseQuizQuestionRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> courseQuizQuestionService.findById(99));
    }
}
