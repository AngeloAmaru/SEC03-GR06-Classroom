package com.edutech.support.entity;

import org.junit.jupiter.api.Test;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class EntitiesUnitTest {
    @Test
    void testSupportTicketEntity() {
        SupportTicket t = new SupportTicket();
        t.setId(1);
        t.setUserId(2);
        t.setSupportUserId(3);
        t.setSubject("Ayuda");
        t.setDescription("No funciona");
        t.setStatus("ABIERTO");
        t.setCreatedAt(Instant.now());
        t.setClosedAt(Instant.now());
        assertEquals(1, t.getId());
        assertEquals(2, t.getUserId());
        assertEquals(3, t.getSupportUserId());
        assertEquals("Ayuda", t.getSubject());
        assertEquals("No funciona", t.getDescription());
        assertEquals("ABIERTO", t.getStatus());
        assertNotNull(t.getCreatedAt());
        assertNotNull(t.getClosedAt());
    }
}
