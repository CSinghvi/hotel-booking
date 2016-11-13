/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.dao.HotelReserveDao;
import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;

/**
 * @author M1035998
 *
 */
//@Service
public class HotelReserveServiceImpl implements HotelReserveService {

	@Autowired
		
	private HotelReserveDao hotelReserveDao;
	

	/**
	 * @return the hotelReserveDao
	 */
	public HotelReserveDao getHotelReserveDao() {
		return hotelReserveDao;
	}

	/**
	 * @param hotelReserveDao the hotelReserveDao to set
	 */
	public void setHotelReserveDao(HotelReserveDao hotelReserveDao) {
		this.hotelReserveDao = hotelReserveDao;
	}
	

	@Transactional
		public List<Hotel> searchHotel() throws HotelReservationException {
		try
		{
			List<Hotel> city=hotelReserveDao.getHotelNameFromDB();
			return city;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw(new HotelReservationException("Problem in database Connectivity!!",e));
		}
		
	}


	@Transactional
		public List<Hotel> getHotel(String city) throws HotelReservationException {
			List<Hotel> hotelDetails=hotelReserveDao.getHotelNameFromDB1(city);
			return hotelDetails;
			
		}

	@Transactional
	public List<BookingDetail> getOccupancy(ReservationDetails reservationDetail) {
		
		List<BookingDetail> bookingDetail=hotelReserveDao.getOccupancy(reservationDetail);
		
		return bookingDetail;
	
	}
	
	@Transactional
		public List<BookingDetail> returnResults(ReservationDetails reservationDetail) {
			List<BookingDetail> reserveList= hotelReserveDao.returnResults(reservationDetail);
			System.out.println("in service........"+reserveList);
			return reserveList;
		}
	
	@Transactional
	public List<Hotel> getLowestfareHotels(String city) {

		List<Hotel> hotelDetails=hotelReserveDao.getLowestfareHotels(city);
		return hotelDetails;
	}

	

}
