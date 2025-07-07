package com.edutech.users.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoleEntityTest {
    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");
        role.setDescription("User role");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1, role.getId());
        assertEquals("ROLE_USER", role.getName());
        assertEquals("User role", role.getDescription());
    }

    @Test
    public void testEqualsAndHashCode() {
        Role role2 = new Role();
        role2.setId(1);
        role2.setName("ROLE_USER");
        role2.setDescription("User role");
        assertEquals(role, role2);
        assertEquals(role.hashCode(), role2.hashCode());
    }

    @Test
    public void testToString() {
        String str = role.toString();
        assertTrue(str.contains("ROLE_USER"));
        assertTrue(str.contains("User role"));
    }
}
