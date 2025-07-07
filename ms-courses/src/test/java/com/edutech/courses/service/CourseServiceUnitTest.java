package com.edutech.courses.service;

import com.edutech.common.dto.CourseDTO;
import com.edutech.courses.entity.Course;
import com.edutech.courses.repository.CourseRepository;
import com.edutech.courses.repository.CourseCategoryRepository;
import com.edutech.courses.mapper.CourseMapper;
import com.edutech.courses.client.UserClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CourseServiceUnitTest {
    @Mock
    private CourseRepository courseRepo;
    @Mock
    private CourseCategoryRepository categRepo;
    @Mock
    private CourseMapper courseMapper;
    @Mock
    private UserClient userClient;
    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllCourses() {
        Course entity = new Course();
        entity.setId(1);
        when(courseRepo.findAll()).thenReturn(java.util.List.of(entity));
        CourseDTO dto = getSampleDTO();
        when(courseMapper.toDTO(entity)).thenReturn(dto);
        var result = courseService.findAll();
        assertEquals(1, result.size());
        assertEquals("Curso Test", result.get(0).getTitle());
    }

    @Test
    void testFindById() {
        Course entity = new Course();
        entity.setId(1);
        when(courseRepo.findById(1)).thenReturn(Optional.of(entity));
        CourseDTO dto = getSampleDTO();
        when(courseMapper.toDTO(entity)).thenReturn(dto);
        var result = courseService.findById(1);
        assertEquals("Curso Test", result.getTitle());
    }

    @Test
    void testCreateCourse() {
        CourseDTO dto = getSampleDTO();
        Course entity = new Course();
        entity.setId(1);
        when(categRepo.findById(dto.getCategoryId())).thenReturn(Optional.of(new com.edutech.courses.entity.CourseCategory()));
        when(userClient.findById(dto.getManagerId())).thenReturn(new com.edutech.common.dto.UserDTO());
        when(userClient.findById(dto.getInstructorId())).thenReturn(new com.edutech.common.dto.UserDTO());
        when(courseMapper.toEntity(dto)).thenReturn(entity);
        when(courseRepo.save(any(Course.class))).thenReturn(entity);
        when(courseMapper.toDTO(entity)).thenReturn(dto);
        var result = courseService.create(dto);
        assertEquals("Curso Test", result.getTitle());
    }

    @Test
    void testUpdateCourse() {
        CourseDTO dto = getSampleDTO();
        Course entity = new Course();
        entity.setId(1);
        when(courseRepo.findById(1)).thenReturn(Optional.of(entity));
        when(courseMapper.toEntity(dto)).thenReturn(entity);
        when(courseRepo.save(any(Course.class))).thenReturn(entity);
        when(courseMapper.toDTO(entity)).thenReturn(dto);
        var result = courseService.update(1, dto);
        assertEquals("Curso Test", result.getTitle());
    }

    @Test
    void testDeleteCourse() {
        Course entity = new Course();
        entity.setId(1);
        when(courseRepo.findById(1)).thenReturn(Optional.of(entity));
        doNothing().when(courseRepo).delete(entity);
        assertDoesNotThrow(() -> courseService.delete(1));
        verify(courseRepo, times(1)).delete(entity);
    }

    private CourseDTO getSampleDTO() {
        CourseDTO dto = new CourseDTO();
        dto.setTitle("Curso Test");
        dto.setDescription("Descripción");
        dto.setCategoryId(1);
        dto.setManagerId(1);
        dto.setInstructorId(1);
        dto.setPublishDate(LocalDate.now());
        dto.setPrice(new BigDecimal("100.00"));
        dto.setImage("img.png");
        return dto;
    }
}
