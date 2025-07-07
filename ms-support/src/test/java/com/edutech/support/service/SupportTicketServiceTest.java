package com.edutech.support.service;

import com.edutech.support.entity.SupportTicket;
import com.edutech.support.repository.SupportTicketRepository;
import com.edutech.support.mapper.SupportTicketMapper;
import com.edutech.common.dto.SupportTicketDTO;
import com.edutech.support.client.UserClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.Instant;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SupportTicketServiceTest {
    @Mock
    private SupportTicketRepository supportTicketRepository;
    @Mock
    private SupportTicketMapper supportTicketMapper;
    @Mock
    private UserClient userClient;
    @InjectMocks
    private SupportTicketService supportTicketService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_returnsSupportTicketDTO_whenExists() {
        Integer id = 1;
        SupportTicket ticket = new SupportTicket();
        ticket.setId(id);
        ticket.setSubject("Ayuda");
        ticket.setCreatedAt(Instant.now());
        SupportTicketDTO dto = new SupportTicketDTO();
        dto.setId(id);
        dto.setSubject("Ayuda");
        dto.setCreatedAt(ticket.getCreatedAt());
        when(supportTicketRepository.findById(id)).thenReturn(Optional.of(ticket));
        when(supportTicketMapper.toDTO(ticket)).thenReturn(dto);
        SupportTicketDTO result = supportTicketService.findById(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(supportTicketRepository, times(1)).findById(id);
        verify(supportTicketMapper, times(1)).toDTO(ticket);
    }

    @Test
    void findById_throwsException_whenNotFound() {
        Integer id = 99;
        when(supportTicketRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> supportTicketService.findById(id));
        verify(supportTicketRepository, times(1)).findById(id);
    }
}
