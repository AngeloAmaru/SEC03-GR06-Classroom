package com.edutech.payments.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PaymentEntityTest {
    private List<Payment> paymentList;

    @BeforeEach
    void setUp() {
        paymentList = new ArrayList<>();
    }

    @Test
    void testCreatePayment() {
        Payment p = new Payment();
        p.setId(1);
        p.setUserId(10);
        p.setAmount(new BigDecimal("100.00"));
        p.setPaymentDate(Instant.now());
        p.setPaymentMethod("CARD");
        p.setPaymentInstitution("VISA");
        p.setTransactionId("TX123");
        p.setStatus("COMPLETED");
        paymentList.add(p);
        assertEquals(1, paymentList.size());
        assertEquals("CARD", paymentList.get(0).getPaymentMethod());
    }

    @Test
    void testReadPayment() {
        Payment p = new Payment();
        p.setId(2);
        p.setUserId(20);
        paymentList.add(p);
        Payment found = paymentList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals(20, found.getUserId());
    }

    @Test
    void testUpdatePayment() {
        Payment p = new Payment();
        p.setId(3);
        p.setStatus("PENDING");
        paymentList.add(p);
        Payment toUpdate = paymentList.get(0);
        toUpdate.setStatus("FAILED");
        assertEquals("FAILED", paymentList.get(0).getStatus());
    }

    @Test
    void testDeletePayment() {
        Payment p = new Payment();
        p.setId(4);
        paymentList.add(p);
        paymentList.removeIf(x -> x.getId() == 4);
        assertTrue(paymentList.isEmpty());
    }
}
