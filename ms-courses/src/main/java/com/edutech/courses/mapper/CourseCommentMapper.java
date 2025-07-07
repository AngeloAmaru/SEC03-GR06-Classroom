



package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.courses.entity.CourseComment;
import org.springframework.stereotype.Component;

@Component
public class CourseCommentMapper {
    public CourseCommentDTO toDTO(CourseComment entity) {
        if (entity == null) return null;
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourseId());
        dto.setUserId(entity.getUserId());
        dto.setComment(entity.getComment());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public CourseComment toEntity(CourseCommentDTO dto) {
        if (dto == null) return null;
        CourseComment entity = new CourseComment();
        entity.setId(dto.getId());
        entity.setCourseId(dto.getCourseId());
        entity.setUserId(dto.getUserId());
        entity.setComment(dto.getComment());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
