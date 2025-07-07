package com.edutech.users.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;

public class UserEntityTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPasswordHash("hashedpassword");
        user.setRoleId(2);
        user.setIsActive(true);
        Instant now = Instant.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1, user.getId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("hashedpassword", user.getPasswordHash());
        assertEquals(2, user.getRoleId());
        assertTrue(user.getIsActive());
        assertNotNull(user.getCreatedAt());
        assertNotNull(user.getUpdatedAt());
    }

    @Test
    public void testEqualsAndHashCode() {
        User user2 = new User();
        user2.setId(1);
        user2.setEmail("john.doe@example.com");
        assertEquals(user, user2);
        assertEquals(user.hashCode(), user2.hashCode());
    }

    @Test
    public void testToString() {
        String str = user.toString();
        assertTrue(str.contains("John"));
        assertTrue(str.contains("Doe"));
        assertTrue(str.contains("john.doe@example.com"));
    }
}
