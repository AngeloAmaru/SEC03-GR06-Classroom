package com.edutech.users;

import com.edutech.common.dto.UserDTO;
import com.edutech.users.entity.User;
import com.edutech.users.mapper.UserMapper;
import com.edutech.users.repository.UserRepository;
import com.edutech.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_returnsUserDTO_whenUserExists() {
        // Arrange
        Integer userId = 1;
        User user = new User();
        user.setId(userId);
        user.setEmail("test@example.com");
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userId);
        userDTO.setEmail("test@example.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(user)).thenReturn(userDTO);

        // Act
        UserDTO result = userService.findById(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("test@example.com", result.getEmail());
        verify(userRepository, times(1)).findById(userId);
        verify(userMapper, times(1)).toDTO(user);
    }

    @Test
    void findById_throwsException_whenUserNotFound() {
        // Arrange
        Integer userId = 99;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> userService.findById(userId));
        assertTrue(exception.getMessage().contains("Usuario"));
        verify(userRepository, times(1)).findById(userId);
    }
} 