
package com.edutech.grades.mapper;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.grades.entity.Enrollment;
import org.springframework.stereotype.Component;

/**
 * Manual mapper for Enrollment entity and DTO
 * Replaces MapStruct with manual implementation
 */
@Component
public class EnrollmentMapper {

    /**
     * Convert Enrollment entity to EnrollmentDTO
     */
    public EnrollmentDTO toDTO(Enrollment entity) {
        if (entity == null) {
            return null;
        }
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudentId());
        dto.setCourseId(entity.getCourseId());
        dto.setEnrolledAt(entity.getEnrolledAt());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    /**
     * Convert EnrollmentDTO to Enrollment entity
     */
    public Enrollment toEntity(EnrollmentDTO dto) {
        if (dto == null) {
            return null;
        }
        Enrollment entity = new Enrollment();
        entity.setId(dto.getId());
        entity.setStudentId(dto.getStudentId());
        entity.setCourseId(dto.getCourseId());
        entity.setEnrolledAt(dto.getEnrolledAt());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
