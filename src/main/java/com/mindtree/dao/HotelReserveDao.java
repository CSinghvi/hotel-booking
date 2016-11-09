/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;



/**
 * @author M1035998
 *
 */
public interface HotelReserveDao {
	
	List<Hotel> getHotelNameFromDB(String search) throws HotelReservationException;

//	List<Customer> getLoginDetails(LoginDetails loginform);

	List<Hotel> getHotelNameFromDB1(String city);

	List<BookingDetail> returnResults(String checkIn, String checkOut, int hotelid,int rooms);
}
