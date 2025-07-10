package com.edutech.payments.service;

import com.edutech.payments.entity.DiscountCoupon;
import com.edutech.payments.repository.DiscountCouponRepository;
import com.edutech.payments.mapper.DiscountCouponMapper;
import com.edutech.common.dto.DiscountCouponDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

class DiscountCouponServiceTest {
    @Mock
    private DiscountCouponRepository discountCouponRepository;
    @Mock
    private DiscountCouponMapper discountCouponMapper;
    @InjectMocks
    private DiscountCouponService discountCouponService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_returnsDiscountCoupon_whenExists() {
        Integer id = 1;
        DiscountCoupon coupon = new DiscountCoupon();
        coupon.setId(id);
        coupon.setCode("CODE10");
        coupon.setDiscountPercentage(new BigDecimal("10.00"));
        coupon.setValidFrom(LocalDate.now());
        DiscountCouponDTO couponDTO = new DiscountCouponDTO();
        couponDTO.setId(id);
        couponDTO.setCode("CODE10");
        couponDTO.setDiscountPercentage(new BigDecimal("10.00"));
        couponDTO.setValidFrom(coupon.getValidFrom());
        when(discountCouponRepository.findById(id)).thenReturn(Optional.of(coupon));
        when(discountCouponMapper.toDTO(coupon)).thenReturn(couponDTO);
        DiscountCouponDTO result = discountCouponService.findById(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(discountCouponRepository, times(1)).findById(id);
        verify(discountCouponMapper, times(1)).toDTO(coupon);
    }

    @Test
    void testFindAll() {
        DiscountCoupon coupon = new DiscountCoupon();
        coupon.setId(1);
        DiscountCouponDTO couponDTO = new DiscountCouponDTO();
        couponDTO.setId(1);
        when(discountCouponRepository.findAll()).thenReturn(Arrays.asList(coupon));
        when(discountCouponMapper.toDTO(any(DiscountCoupon.class))).thenReturn(couponDTO);
        List<DiscountCouponDTO> result = discountCouponService.findAll();
        assertEquals(1, result.size());
        verify(discountCouponRepository).findAll();
    }

    @Test
    void testCreate() {
        DiscountCoupon coupon = new DiscountCoupon();
        DiscountCouponDTO couponDTO = new DiscountCouponDTO();
        when(discountCouponMapper.toEntity(any(DiscountCouponDTO.class))).thenReturn(coupon);
        when(discountCouponRepository.save(any(DiscountCoupon.class))).thenReturn(coupon);
        when(discountCouponMapper.toDTO(any(DiscountCoupon.class))).thenReturn(couponDTO);
        DiscountCouponDTO result = discountCouponService.create(couponDTO);
        assertNotNull(result);
        verify(discountCouponRepository).save(any(DiscountCoupon.class));
    }

    @Test
    void testUpdate() {
        DiscountCoupon coupon = new DiscountCoupon();
        DiscountCouponDTO couponDTO = new DiscountCouponDTO();
        when(discountCouponRepository.findById(anyInt())).thenReturn(Optional.of(coupon));
        when(discountCouponMapper.toEntity(any(DiscountCouponDTO.class))).thenReturn(coupon);
        when(discountCouponRepository.save(any(DiscountCoupon.class))).thenReturn(coupon);
        when(discountCouponMapper.toDTO(any(DiscountCoupon.class))).thenReturn(couponDTO);
        DiscountCouponDTO result = discountCouponService.update(1, couponDTO);
        assertNotNull(result);
        verify(discountCouponRepository).save(any(DiscountCoupon.class));
    }

    @Test
    void testDelete() {
        DiscountCoupon coupon = new DiscountCoupon();
        when(discountCouponRepository.findById(anyInt())).thenReturn(Optional.of(coupon));
        doNothing().when(discountCouponRepository).delete(any(DiscountCoupon.class));
        discountCouponService.delete(1);
        verify(discountCouponRepository).delete(any(DiscountCoupon.class));
    }

    @Test
    void findById_throwsException_whenNotFound() {
        Integer id = 99;
        when(discountCouponRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> discountCouponService.findById(id));
        verify(discountCouponRepository, times(1)).findById(id);
    }
}
