/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;

/**
 * @author M1035998
 *
 */
public interface HotelReserveService {
	public List<Hotel> searchHotel(String search) throws HotelReservationException;

//	public List<Customer> getLoginDetails(LoginDetails loginform);
	public List<Hotel> getHotel(String city) throws HotelReservationException;

	public List<BookingDetail> returnResults(String checkIn, String checkOut, int hotelid, int rooms);
}