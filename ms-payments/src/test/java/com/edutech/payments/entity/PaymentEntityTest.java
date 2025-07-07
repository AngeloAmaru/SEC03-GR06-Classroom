package com.edutech.payments.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class PaymentEntityTest {
    @Test
    void testPaymentEntity_CRUD() {
        Payment p = new Payment();
        p.setId(1);
        p.setUserId(2);
        p.setAmount(new BigDecimal("100.50"));
        p.setPaymentDate(Instant.now());
        p.setPaymentMethod("CARD");
        p.setPaymentInstitution("BANK");
        p.setTransactionId("TX123");
        p.setStatus("COMPLETED");
        assertEquals(1, p.getId());
        assertEquals(2, p.getUserId());
        assertEquals(new BigDecimal("100.50"), p.getAmount());
        assertNotNull(p.getPaymentDate());
        assertEquals("CARD", p.getPaymentMethod());
        assertEquals("BANK", p.getPaymentInstitution());
        assertEquals("TX123", p.getTransactionId());
        assertEquals("COMPLETED", p.getStatus());
    }
}
