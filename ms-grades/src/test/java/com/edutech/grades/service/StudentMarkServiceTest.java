package com.edutech.grades.service;

import com.edutech.common.dto.StudentMarkDTO;
import com.edutech.grades.entity.StudentMark;
import com.edutech.grades.mapper.StudentMarkMapperManual;
import com.edutech.grades.repository.StudentMarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentMarkServiceTest {
    @Mock
    private StudentMarkRepository studentMarkRepository;
    @Mock
    private StudentMarkMapperManual studentMarkMapper;
    @InjectMocks
    private StudentMarkService studentMarkService;

    private StudentMark studentMark;
    private StudentMarkDTO studentMarkDTO;

    @BeforeEach
    void setUp() {
        studentMark = new StudentMark();
        studentMark.setId(1);
        studentMark.setQuizId(2);
        studentMark.setStudentId(3);
        studentMark.setMark(new BigDecimal("95.5"));
        studentMark.setComments("Buen trabajo");
        studentMark.setGradedAt(Instant.now());

        studentMarkDTO = new StudentMarkDTO();
        studentMarkDTO.setId(1);
        studentMarkDTO.setQuizId(2);
        studentMarkDTO.setStudentId(3);
        studentMarkDTO.setMark(new BigDecimal("95.5"));
        studentMarkDTO.setComments("Buen trabajo");
        studentMarkDTO.setGradedAt(studentMark.getGradedAt());
    }

    @Test
    void testFindAll_Success() {
        List<StudentMark> marks = Arrays.asList(studentMark);
        when(studentMarkRepository.findAll()).thenReturn(marks);
        when(studentMarkMapper.toDTO(studentMark)).thenReturn(studentMarkDTO);
        List<StudentMarkDTO> result = studentMarkService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Buen trabajo", result.get(0).getComments());
        verify(studentMarkRepository).findAll();
    }

    @Test
    void testFindById_Success() {
        when(studentMarkRepository.findById(1)).thenReturn(Optional.of(studentMark));
        when(studentMarkMapper.toDTO(studentMark)).thenReturn(studentMarkDTO);
        StudentMarkDTO result = studentMarkService.findById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(studentMarkRepository).findById(1);
    }

    @Test
    void testFindById_NotFound() {
        when(studentMarkRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> studentMarkService.findById(99));
    }
}
