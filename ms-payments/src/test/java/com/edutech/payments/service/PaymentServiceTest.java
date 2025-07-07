package com.edutech.payments.service;

import com.edutech.payments.entity.Payment;
import com.edutech.payments.repository.PaymentRepository;
import com.edutech.payments.mapper.PaymentMapper;
import com.edutech.common.dto.PaymentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceTest {
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private PaymentMapper paymentMapper;
    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_returnsPayment_whenExists() {
        Integer id = 1;
        Payment payment = new Payment();
        payment.setId(id);
        payment.setAmount(new BigDecimal("100.50"));
        payment.setPaymentDate(Instant.now());
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(id);
        paymentDTO.setAmount(new BigDecimal("100.50"));
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));
        when(paymentMapper.toDTO(payment)).thenReturn(paymentDTO);
        PaymentDTO result = paymentService.findById(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(paymentRepository, times(1)).findById(id);
        verify(paymentMapper, times(1)).toDTO(payment);
    }

    @Test
    void findById_throwsException_whenNotFound() {
        Integer id = 99;
        when(paymentRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> paymentService.findById(id));
        verify(paymentRepository, times(1)).findById(id);
    }
}
