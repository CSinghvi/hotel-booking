/**
 * 
 */
package com.mindtree.test;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mindtree.dao.HotelReserveDao;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.service.HotelReserveServiceImpl;

import junit.framework.Assert;

/**
 * @author M1035998
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" }) 
public class ReservationHotelTest {

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

HotelReserveServiceImpl hotelReserveServiceImpl=new HotelReserveServiceImpl();

@Before
public void setData()
{
	hotelReserveServiceImpl.setHotelReserveDao(hotelReserveDao);
}


	/**
	 * Test method for {@link com.mindtree.service.HotelReserveServiceImpl#searchHotel(java.lang.String)}.
	 */
	//@Test
	@Transactional
	public void testSearchHotel() {
//		Hotel hotel=hotelReserveServiceImpl.getHotel(1).get(0);
	//	Hotel hotel=hotelReserveDao.getHotelNameFromDB1(1).get(0);
	//	Assert.assertEquals("Marriott Courtyard", hotel.getHotelName());
	}
	

	/**
	 * Test method for {@link com.mindtree.service.HotelReserveServiceImpl#returnResults(java.lang.String, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	@Transactional
	public void testReturnResults() {
		BookingDetail bookingDetail=hotelReserveDao.returnResults("24-03-2016","26-03-2016", 2, "chirayu.singhvi@mindtree.com").get(0);
		Assert.assertEquals("Marriot Downtown", bookingDetail.getHotel().getHotelName());
	}

}
