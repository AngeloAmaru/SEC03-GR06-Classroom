



package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseQuizQuestionDTO;
import com.edutech.courses.entity.CourseQuizQuestion;
import org.springframework.stereotype.Component;

@Component
public class CourseQuizQuestionMapper {
    public CourseQuizQuestionDTO toDTO(CourseQuizQuestion entity) {
        if (entity == null) return null;
        CourseQuizQuestionDTO dto = new CourseQuizQuestionDTO();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuizId());
        dto.setQuestion(entity.getQuestion());
        dto.setType(entity.getType());
        dto.setOrder(entity.getOrder());
        return dto;
    }

    public CourseQuizQuestion toEntity(CourseQuizQuestionDTO dto) {
        if (dto == null) return null;
        CourseQuizQuestion entity = new CourseQuizQuestion();
        entity.setId(dto.getId());
        entity.setQuizId(dto.getQuizId());
        entity.setQuestion(dto.getQuestion());
        entity.setType(dto.getType());
        entity.setOrder(dto.getOrder());
        return entity;
    }
}
