package com.edutech.support.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {
    @GetMapping("/hateoas-example/{id}")
    public ResponseEntity<EntityModel<String>> hateoasExample(@PathVariable Integer id) {
        String ticket = "Ticket de soporte de ejemplo con ID " + id;
        EntityModel<String> resource = EntityModel.of(ticket,
                linkTo(methodOn(SupportTicketController.class).hateoasExample(id)).withSelfRel(),
                linkTo(methodOn(SupportTicketController.class).allTickets()).withRel("all-tickets")
        );
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<String> allTickets() {
        return ResponseEntity.ok("Listado de tickets de soporte (ejemplo)");
    }
} 