package com.edutech.grades.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.common.exception.ResourceNotFoundException;
import com.edutech.grades.entity.Enrollment;
import com.edutech.grades.mapper.EnrollmentMapper;
import com.edutech.grades.repository.EnrollmentRepository;

import static com.edutech.common.exception.ExceptionUtils.orThrow;

/**
 * Service for managing enrollments
 * Handles business logic for enrollment operations
 */
@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    /**
     * Get all enrollments
     */
    public List<EnrollmentDTO> findAll() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get enrollment by ID
     */
    public EnrollmentDTO findById(Integer id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));
        return enrollmentMapper.toDTO(enrollment);
    }

    /**
     * Get enrollments by student ID
     */
    public List<EnrollmentDTO> findByStudentId(Integer studentId) {
        return enrollmentRepository.findByStudentId(studentId)
                .stream()
                .map(enrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get enrollments by course ID
     */
    public List<EnrollmentDTO> findByCourseId(Integer courseId) {
        return enrollmentRepository.findByCourseId(courseId)
                .stream()
                .map(enrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Create new enrollment
     */
    public EnrollmentDTO create(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDTO);
        // Set creation timestamp if not provided
        if (enrollment.getEnrolledAt() == null) {
            enrollment.setEnrolledAt(Instant.now());
        }
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toDTO(savedEnrollment);
    }

    /**
     * Update existing enrollment
     */
    public EnrollmentDTO update(Integer id, EnrollmentDTO enrollmentDTO) {
        if (!enrollmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Enrollment not found with id: " + id);
        }
        Enrollment updatedEnrollment = enrollmentMapper.toEntity(enrollmentDTO);
        updatedEnrollment.setId(id);
        Enrollment savedEnrollment = enrollmentRepository.save(updatedEnrollment);
        return enrollmentMapper.toDTO(savedEnrollment);
    }

    /**
     * Delete enrollment
     */
    public void delete(Integer id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));
        enrollmentRepository.delete(enrollment);
    }

    /**
     * Check if enrollment exists by ID
     */
    public boolean existsById(Integer id) {
        if (id == null) {
            return false;
        }
        return enrollmentRepository.existsById(id);
    }

    /**
     * Count enrollments by course ID
     */
    public long countByCourseId(Integer courseId) {
        if (courseId == null) {
            return 0L;
        }
        return enrollmentRepository.findByCourseId(courseId).size();
    }

    /**
     * Check if course has any enrollments
     */
    public boolean existsByCourseId(Integer courseId) {
        if (courseId == null) {
            return false;
        }
        return !enrollmentRepository.findByCourseId(courseId).isEmpty();
    }
}
