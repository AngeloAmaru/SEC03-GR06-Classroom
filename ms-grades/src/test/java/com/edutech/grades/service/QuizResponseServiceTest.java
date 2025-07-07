package com.edutech.grades.service;

import com.edutech.common.dto.QuizResponseDTO;
import com.edutech.grades.entity.QuizResponse;
import com.edutech.grades.mapper.QuizResponseMapperManual;
import com.edutech.grades.repository.QuizResponseRepository;
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
class QuizResponseServiceTest {
    @Mock
    private QuizResponseRepository quizResponseRepository;
    @Mock
    private QuizResponseMapperManual quizResponseMapper;
    @InjectMocks
    private QuizResponseService quizResponseService;

    private QuizResponse quizResponse;
    private QuizResponseDTO quizResponseDTO;

    @BeforeEach
    void setUp() {
        quizResponse = new QuizResponse();
        quizResponse.setId(1);
        quizResponse.setQuizId(2);
        quizResponse.setStudentId(3);
        quizResponse.setSelectedOption("A");
        quizResponse.setResponseContent("Respuesta");
        quizResponse.setAssignmentUrl("url");
        quizResponse.setSubmittedAt(Instant.now());

        quizResponseDTO = new QuizResponseDTO();
        quizResponseDTO.setId(1);
        quizResponseDTO.setQuizId(2);
        quizResponseDTO.setStudentId(3);
        quizResponseDTO.setSelectedOption("A");
        quizResponseDTO.setResponseContent("Respuesta");
        quizResponseDTO.setAssignmentUrl("url");
        quizResponseDTO.setSubmittedAt(quizResponse.getSubmittedAt());
    }

    @Test
    void testFindAll_Success() {
        List<QuizResponse> responses = Arrays.asList(quizResponse);
        when(quizResponseRepository.findAll()).thenReturn(responses);
        when(quizResponseMapper.toDTO(quizResponse)).thenReturn(quizResponseDTO);
        List<QuizResponseDTO> result = quizResponseService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Respuesta", result.get(0).getResponseContent());
        verify(quizResponseRepository).findAll();
    }

    @Test
    void testFindById_Success() {
        when(quizResponseRepository.findById(1)).thenReturn(Optional.of(quizResponse));
        when(quizResponseMapper.toDTO(quizResponse)).thenReturn(quizResponseDTO);
        QuizResponseDTO result = quizResponseService.findById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(quizResponseRepository).findById(1);
    }

    @Test
    void testFindById_NotFound() {
        when(quizResponseRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> quizResponseService.findById(99));
    }
}
