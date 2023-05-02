package com.booking.hotel.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.hotel.persistence.entity.HotelEntity;

/**
 * 
 * @author juveme88
 *
 */
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

	public Optional<HotelEntity> findByNit(String nit);
}
