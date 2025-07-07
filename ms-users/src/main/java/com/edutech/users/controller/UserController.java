package com.edutech.users.controller;

import com.edutech.common.dto.UserDTO;
import com.edutech.users.entity.User;
import com.edutech.users.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.edutech.users.repository.UserRepository;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.edutech.users.client.CourseClient;
import com.edutech.common.dto.CourseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final UserRepository userRepository;
    private final CourseClient courseClient;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UserDTO>> findById(@PathVariable Integer id) {
        UserDTO user = userService.findById(id);
        EntityModel<UserDTO> resource = EntityModel.of(user,
                linkTo(methodOn(UserController.class).findById(id)).withSelfRel(),
                linkTo(methodOn(UserController.class).findAll()).withRel("all-users"),
                linkTo(methodOn(UserController.class).findUserCourses(id)).withRel("courses")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public List<User> test() {
        return userRepository.findAll();
    }

    // Ejemplo de endpoint para cursos de un usuario (solo para el ejemplo de HATEOAS)
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseDTO>> findUserCourses(@PathVariable Integer id) {
        List<CourseDTO> courses = courseClient.findCoursesByUserId(id);
        return ResponseEntity.ok(courses);
    }

}
