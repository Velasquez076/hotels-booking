package com.booking.hotel.persistence.repository.booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booking.hotel.persistence.entity.booking.BookingEntity;
import com.booking.hotel.persistence.projections.BookingProjection;

/**
 * 
 * @author juveme88
 *
 */
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

	@Query(value = "SELECT tb.ID_BOOKING as id, tb.BOOKING_START_DATE as startDate, tb.BOOKING_END_DATE as endDate, "
			+ "tb.BOOKING_NUMBER_PEOPLE as numberPeople, th.ID_HOTEL as idHotel, th.HOTEL_NAME as hotelName "
			+ "FROM hotel_db.tbl_booking tb INNER JOIN hotel_db.tbl_hotel th ON tb.BOOKING_HOTEL  = th.ID_HOTEL ORDER BY tb.ID_BOOKING ", nativeQuery = true)
	public List<BookingProjection> findAllBooking();
}
