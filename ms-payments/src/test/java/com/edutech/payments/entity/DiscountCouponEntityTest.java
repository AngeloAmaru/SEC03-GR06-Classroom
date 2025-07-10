package com.edutech.payments.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DiscountCouponEntityTest {
    private List<DiscountCoupon> couponList;

    @BeforeEach
    void setUp() {
        couponList = new ArrayList<>();
    }

    @Test
    void testCreateCoupon() {
        DiscountCoupon c = new DiscountCoupon();
        c.setId(1);
        c.setCode("CODE10");
        c.setDescription("10% OFF");
        c.setDiscountPercentage(new BigDecimal("10.00"));
        c.setValidFrom(LocalDate.now());
        c.setValidUntil(LocalDate.now().plusDays(10));
        c.setIsActive(true);
        couponList.add(c);
        assertEquals(1, couponList.size());
        assertEquals("CODE10", couponList.get(0).getCode());
    }

    @Test
    void testReadCoupon() {
        DiscountCoupon c = new DiscountCoupon();
        c.setId(2);
        c.setCode("CODE20");
        c.setDescription("20% OFF");
        couponList.add(c);
        DiscountCoupon found = couponList.stream().filter(x -> x.getId() == 2).findFirst().orElse(null);
        assertNotNull(found);
        assertEquals("CODE20", found.getCode());
    }

    @Test
    void testUpdateCoupon() {
        DiscountCoupon c = new DiscountCoupon();
        c.setId(3);
        c.setDescription("Old");
        couponList.add(c);
        DiscountCoupon toUpdate = couponList.get(0);
        toUpdate.setDescription("New");
        assertEquals("New", couponList.get(0).getDescription());
    }

    @Test
    void testDeleteCoupon() {
        DiscountCoupon c = new DiscountCoupon();
        c.setId(4);
        couponList.add(c);
        couponList.removeIf(x -> x.getId() == 4);
        assertTrue(couponList.isEmpty());
    }
}
