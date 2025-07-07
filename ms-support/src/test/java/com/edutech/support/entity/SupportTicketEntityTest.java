package com.edutech.support.entity;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class SupportTicketEntityTest {
    @Test
    void testSupportTicketEntity_CRUD() {
        SupportTicket ticket = new SupportTicket();
        ticket.setId(1);
        ticket.setUserId(2);
        ticket.setSupportUserId(3);
        ticket.setSubject("Ayuda");
        ticket.setDescription("Necesito soporte");
        ticket.setStatus("OPEN");
        ticket.setCreatedAt(Instant.now());
        ticket.setClosedAt(Instant.now());
        assertEquals(1, ticket.getId());
        assertEquals(2, ticket.getUserId());
        assertEquals(3, ticket.getSupportUserId());
        assertEquals("Ayuda", ticket.getSubject());
        assertEquals("Necesito soporte", ticket.getDescription());
        assertEquals("OPEN", ticket.getStatus());
        assertNotNull(ticket.getCreatedAt());
        assertNotNull(ticket.getClosedAt());
    }
}
