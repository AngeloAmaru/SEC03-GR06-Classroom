package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseQuizDTO;
import com.edutech.courses.entity.CourseQuiz;
import org.springframework.stereotype.Component;

@Component
public class CourseQuizMapper {
    public CourseQuizDTO toDTO(CourseQuiz entity) {
        if (entity == null) return null;
        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourseId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setQuizType(entity.getQuizType());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseQuiz toEntity(CourseQuizDTO dto) {
        if (dto == null) return null;
        CourseQuiz entity = new CourseQuiz();
        entity.setId(dto.getId());
        entity.setCourseId(dto.getCourseId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setQuizType(dto.getQuizType());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
