package com.edutech.payments.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DiscountCouponEntityTest {
    @Test
    void testDiscountCouponEntity_CRUD() {
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
