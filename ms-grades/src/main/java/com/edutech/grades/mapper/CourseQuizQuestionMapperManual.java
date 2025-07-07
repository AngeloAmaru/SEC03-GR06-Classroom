package com.edutech.grades.mapper;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.grades.entity.CourseQuizQuestion;
import org.springframework.stereotype.Component;

/**
 * Manual mapper for CourseQuizQuestion entity and DTO
 * Replaces MapStruct with manual implementation
 */
@Component
public class CourseQuizQuestionMapperManual {

    /**
     * Convert CourseQuizQuestion entity to CourseQuizQuestionDTO
     */
    public CourseQuizQuestionDTO toDTO(CourseQuizQuestion entity) {
        if (entity == null) {
            return null;
        }
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuizId());
        dto.setQuestionText(entity.getQuestionText());
        dto.setOptionA(entity.getOptionA());
        dto.setOptionB(entity.getOptionB());
        dto.setOptionC(entity.getOptionC());
        dto.setOptionD(entity.getOptionD());
        dto.setOptionE(entity.getOptionE());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setCorrectOption(entity.getCorrectOption());
        dto.setOrderIndex(entity.getOrderIndex());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    /**
     * Convert CourseQuizQuestionDTO to CourseQuizQuestion entity
     */
    public CourseQuizQuestion toEntity(CourseQuizQuestionDTO dto) {
        if (dto == null) {
            return null;
        }
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(dto.getId());
        entity.setQuizId(dto.getQuizId());
        entity.setQuestionText(dto.getQuestionText());
        entity.setOptionA(dto.getOptionA());
        entity.setOptionB(dto.getOptionB());
        entity.setOptionC(dto.getOptionC());
        entity.setOptionD(dto.getOptionD());
        entity.setOptionE(dto.getOptionE());
        entity.setCorrectAnswer(dto.getCorrectAnswer());
        entity.setCorrectOption(dto.getCorrectOption());
        entity.setOrderIndex(dto.getOrderIndex());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
