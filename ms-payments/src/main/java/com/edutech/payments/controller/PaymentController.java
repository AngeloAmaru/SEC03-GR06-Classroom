package com.edutech.payments.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @GetMapping("/hateoas-example/{id}")
    public ResponseEntity<EntityModel<String>> hateoasExample(@PathVariable Integer id) {
        String payment = "Pago de ejemplo con ID " + id;
        EntityModel<String> resource = EntityModel.of(payment,
                linkTo(methodOn(PaymentController.class).hateoasExample(id)).withSelfRel(),
                linkTo(methodOn(PaymentController.class).allPayments()).withRel("all-payments")
        );
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<String> allPayments() {
        return ResponseEntity.ok("Listado de pagos (ejemplo)");
    }
} 