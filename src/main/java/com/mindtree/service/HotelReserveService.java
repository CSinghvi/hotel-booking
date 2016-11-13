/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;

/**
 * @author M1035998
 *
 */
public interface HotelReserveService {
	public List<Hotel> searchHotel() throws HotelReservationException;

	public List<Hotel> getHotel(String city) throws HotelReservationException;

	public List<BookingDetail> getOccupancy(ReservationDetails reservationDetail);
	
	public List<BookingDetail> returnResults(ReservationDetails reservationDetail);
	
	public List<Hotel> getLowestfareHotels(String city);
}