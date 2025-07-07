package com.edutech.grades.service;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.grades.entity.Enrollment;
import com.edutech.grades.mapper.EnrollmentMapper;
import com.edutech.grades.repository.EnrollmentRepository;
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
class EnrollmentServiceTest {
    @Mock
    private EnrollmentRepository enrollmentRepository;
    @Mock
    private EnrollmentMapper enrollmentMapper;
    @InjectMocks
    private EnrollmentService enrollmentService;

    private Enrollment enrollment;
    private EnrollmentDTO enrollmentDTO;

    @BeforeEach
    void setUp() {
        enrollment = new Enrollment();
        enrollment.setId(1);
        enrollment.setStudentId(3);
        enrollment.setCourseId(2);
        enrollment.setEnrolledAt(Instant.now());
        enrollment.setStatus("Enabled");

        enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setId(1);
        enrollmentDTO.setStudentId(3);
        enrollmentDTO.setCourseId(2);
        enrollmentDTO.setEnrolledAt(enrollment.getEnrolledAt());
        enrollmentDTO.setStatus("Enabled");
    }

    @Test
    void testFindAll_Success() {
        List<Enrollment> enrollments = Arrays.asList(enrollment);
        when(enrollmentRepository.findAll()).thenReturn(enrollments);
        when(enrollmentMapper.toDTO(enrollment)).thenReturn(enrollmentDTO);
        List<EnrollmentDTO> result = enrollmentService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Enabled", result.get(0).getStatus());
        verify(enrollmentRepository).findAll();
    }

    @Test
    void testFindById_Success() {
        when(enrollmentRepository.findById(1)).thenReturn(Optional.of(enrollment));
        when(enrollmentMapper.toDTO(enrollment)).thenReturn(enrollmentDTO);
        EnrollmentDTO result = enrollmentService.findById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(enrollmentRepository).findById(1);
    }

    @Test
    void testFindById_NotFound() {
        when(enrollmentRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> enrollmentService.findById(99));
    }
}
