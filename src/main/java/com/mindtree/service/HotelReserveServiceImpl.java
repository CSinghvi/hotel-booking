/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.mindtree.dao.HotelReserveDao;
import com.mindtree.dto.LoginDetails;
import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;
import com.mindtree.util.DatabaseUtil;

/**
 * @author M1035998
 *
 */
//@Service
public class HotelReserveServiceImpl implements HotelReserveService {

	@Autowired
		//EmployeeSurveyDAOImpl dao;
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
		public List<Hotel> searchHotel(String search) throws HotelReservationException {
		try
		{
			List<Hotel> city=hotelReserveDao.getHotelNameFromDB(search);
			return city;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw(new HotelReservationException("Problem in database Connectivity!!",e));
		}
		
	}
	
	@Transactional
		public List<Customer> getLoginDetails(LoginDetails loginform) {
			System.out.println("reaching service");
			List<Customer> custDetails=hotelReserveDao.getLoginDetails(loginform);
			return custDetails;
		}

	@Transactional
		public List<Hotel> getHotel(String city) throws HotelReservationException {
			List<Hotel> hotelDetails=hotelReserveDao.getHotelNameFromDB(city);
			return hotelDetails;
			
		}

	
	@Transactional
		public List<BookingDetail> returnResults(String checkIn, String checkOut, int hotelid, String email) {
			List<BookingDetail> reserveList= hotelReserveDao.returnResults(checkIn,checkOut,hotelid,email);
			System.out.println("in service........"+reserveList);
			return reserveList;
		}

}
