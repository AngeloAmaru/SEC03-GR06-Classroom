package com.edutech.grades.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    @GetMapping("/hateoas-example/{id}")
    public ResponseEntity<EntityModel<String>> hateoasExample(@PathVariable Integer id) {
        String grade = "Nota de ejemplo para el estudiante " + id;
        EntityModel<String> resource = EntityModel.of(grade,
                linkTo(methodOn(GradeController.class).hateoasExample(id)).withSelfRel(),
                linkTo(methodOn(GradeController.class).allGrades()).withRel("all-grades")
        );
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<String> allGrades() {
        return ResponseEntity.ok("Listado de notas (ejemplo)");
    }
} 