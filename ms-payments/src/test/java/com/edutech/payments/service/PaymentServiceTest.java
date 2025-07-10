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

import java.util.Arrays;
import java.util.List;

import com.edutech.payments.client.UserClient;

class PaymentServiceTest {
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private PaymentMapper paymentMapper;
    @Mock
    private UserClient userClient;
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
    void testFindAll() {
        Payment payment = new Payment();
        payment.setId(1);
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(1);
        when(paymentRepository.findAll()).thenReturn(Arrays.asList(payment));
        when(paymentMapper.toDTO(any(Payment.class))).thenReturn(paymentDTO);
        List<PaymentDTO> result = paymentService.findAll();
        assertEquals(1, result.size());
        verify(paymentRepository).findAll();
    }

    @Test
    void testCreate() {
        Payment payment = new Payment();
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setUserId(1);
        com.edutech.common.dto.UserDTO user = new com.edutech.common.dto.UserDTO();
        user.setId(1);
        when(userClient.findById(anyInt())).thenReturn(user);
        when(paymentMapper.toEntity(any(PaymentDTO.class))).thenReturn(payment);
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
        when(paymentMapper.toDTO(any(Payment.class))).thenReturn(paymentDTO);
        PaymentDTO result = paymentService.create(paymentDTO);
        assertNotNull(result);
        verify(paymentRepository).save(any(Payment.class));
    }

    @Test
    void testUpdate() {
        Payment payment = new Payment();
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setUserId(1);
        com.edutech.common.dto.UserDTO user = new com.edutech.common.dto.UserDTO();
        user.setId(1);
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        when(userClient.findById(anyInt())).thenReturn(user);
        when(paymentMapper.toEntity(any(PaymentDTO.class))).thenReturn(payment);
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
        when(paymentMapper.toDTO(any(Payment.class))).thenReturn(paymentDTO);
        PaymentDTO result = paymentService.update(1, paymentDTO);
        assertNotNull(result);
        verify(paymentRepository).save(any(Payment.class));
    }

    @Test
    void testDelete() {
        Payment payment = new Payment();
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        doNothing().when(paymentRepository).delete(any(Payment.class));
        paymentService.delete(1);
        verify(paymentRepository).delete(any(Payment.class));
    }

    @Test
    void findById_throwsException_whenNotFound() {
        Integer id = 99;
        when(paymentRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> paymentService.findById(id));
        verify(paymentRepository, times(1)).findById(id);
    }
}
