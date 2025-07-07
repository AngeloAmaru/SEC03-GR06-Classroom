



package com.edutech.courses.mapper;

import com.edutech.common.dto.CourseContentDTO;
import com.edutech.courses.entity.CourseContent;
import org.springframework.stereotype.Component;

@Component
public class CourseContentMapper {
    public CourseContentDTO toDTO(CourseContent entity) {
        if (entity == null) return null;
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourseId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setOrder(entity.getOrder());
        return dto;
    }

    public CourseContent toEntity(CourseContentDTO dto) {
        if (dto == null) return null;
        CourseContent entity = new CourseContent();
        entity.setId(dto.getId());
        entity.setCourseId(dto.getCourseId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setOrder(dto.getOrder());
        return entity;
    }
}
