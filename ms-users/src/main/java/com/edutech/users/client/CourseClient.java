package com.edutech.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.edutech.common.dto.CourseDTO;

@FeignClient(name = "ms-courses")
public interface CourseClient {
    @GetMapping("/api/courses/user/{userId}")
    List<CourseDTO> findCoursesByUserId(@PathVariable("userId") Integer userId);
} 