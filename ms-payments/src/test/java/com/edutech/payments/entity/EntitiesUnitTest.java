package com.edutech.payments.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntitiesUnitTest {
    @Test
    void testPaymentEntity() {
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

    @Test
    void testDiscountCouponEntity() {
        DiscountCoupon d = new DiscountCoupon();
        d.setId(1);
        d.setCode("CODE10");
        d.setDescription("10% OFF");
        d.setDiscountPercentage(new BigDecimal("10.00"));
        d.setValidFrom(LocalDate.now());
        d.setValidUntil(LocalDate.now().plusDays(10));
        d.setIsActive(true);
        assertEquals(1, d.getId());
        assertEquals("CODE10", d.getCode());
        assertEquals("10% OFF", d.getDescription());
        assertEquals(new BigDecimal("10.00"), d.getDiscountPercentage());
        assertNotNull(d.getValidFrom());
        assertNotNull(d.getValidUntil());
        assertTrue(d.getIsActive());
    }
}
