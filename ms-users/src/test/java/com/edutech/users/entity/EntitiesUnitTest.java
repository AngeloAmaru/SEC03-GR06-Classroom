package com.edutech.users.entity;

import org.junit.jupiter.api.Test;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class EntitiesUnitTest {
    @Test
    void testUserEntity() {
        User u = new User();
        u.setId(1);
        u.setFirstName("Juan");
        u.setLastName("Pérez");
        u.setEmail("juan@test.com");
        u.setPasswordHash("hash");
        u.setRoleId(2);
        u.setIsActive(true);
        u.setCreatedAt(Instant.now());
        u.setUpdatedAt(Instant.now());
        assertEquals(1, u.getId());
        assertEquals("Juan", u.getFirstName());
        assertEquals("Pérez", u.getLastName());
        assertEquals("juan@test.com", u.getEmail());
        assertEquals("hash", u.getPasswordHash());
        assertEquals(2, u.getRoleId());
        assertTrue(u.getIsActive());
        assertNotNull(u.getCreatedAt());
        assertNotNull(u.getUpdatedAt());
    }

    @Test
    void testRoleEntity() {
        Role r = new Role();
        r.setId(1);
        r.setName("ADMIN");
        r.setDescription("Administrador");
        assertEquals(1, r.getId());
        assertEquals("ADMIN", r.getName());
        assertEquals("Administrador", r.getDescription());
    }
}
