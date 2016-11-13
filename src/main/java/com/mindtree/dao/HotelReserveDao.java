/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;



/**
 * @author M1035998
 *
 */
public interface HotelReserveDao {
	
	List<Hotel> getHotelNameFromDB() throws HotelReservationException;

	List<Hotel> getHotelNameFromDB1(String city);
	
	 List<BookingDetail> getOccupancy(ReservationDetails reservationDetail);

	List<BookingDetail> returnResults(ReservationDetails reservationDetail);
	
	List<Hotel> getLowestfareHotels(String city);
}
