/**
 * 
 */
package com.mindtree.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.mindtree.controller.HotelReservationControlller;
import com.mindtree.dao.HotelReserveDao;
import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;
import com.mindtree.service.HotelReserveService;
import com.mindtree.service.HotelReserveServiceImpl;

import junit.framework.Assert;

/**
 * @author M1035998
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" }) 
public class ReservationHotelTest {

@InjectMocks
private HotelReservationControlller hotelReservationControlller;

@Mock
HotelReserveService hotelReserveService;

@Mock
ReservationDetails reservationDetails;

@Mock
Model model;

@Mock
HttpServletRequest request;

@Mock
HttpServletResponse response;

@Mock
BindingResult bindingResult;


List<Hotel> hotelDetails1;

List<BookingDetail> bookingList;

Hotel hotel;

BookingDetail detail;

@Before
public void setData()
{
	hotelDetails1=new  ArrayList<>();
	hotel=new Hotel();
	hotel.setCity("Udaipur");
	hotel.setHotelName("Lake Palace");
	hotelDetails1.add(hotel);
	
	bookingList=new ArrayList<>();
	detail=new BookingDetail();
	detail.setBill(1200);
	detail.setCheckIn("11-14-2016");
	detail.setCheckOut("15-11-2016");
	bookingList.add(detail);
	
	reservationDetails.setCheckIn("11-14-2016");
	reservationDetails.setCheckOut("15-11-2016");
	
}


	/**
	 * Test method for {@link com.mindtree.service.HotelReserveServiceImpl#searchHotel(java.lang.String)}.
	 */
	@Test
	public void testgetCity() {
		try {
			Mockito.when(hotelReserveService.searchHotel()).thenReturn(hotelDetails1);
			String resp=hotelReservationControlller.getCity(model, request);
			Assert.assertNotNull(resp);
		} catch (HotelReservationException e) {
						e.printStackTrace();
		}
	}
	
	@Test
	public void testgetHotelname() {
		try {
			
			try {
				Mockito.when(hotelReserveService.getHotel(Mockito.anyString())).thenReturn(hotelDetails1);
				String resp=hotelReservationControlller.getHotelname(model, request, response);
				Assert.assertNotNull(resp);
			} catch (IOException e) {
					e.printStackTrace();
			}
			} catch (HotelReservationException e) {
						e.printStackTrace();
			}
	}
	
	@Test
	public void testgetBookingDetails() {
		try {
			Mockito.when(hotelReserveService.getHotel(Mockito.anyString())).thenReturn(hotelDetails1);
			Mockito.when(hotelReserveService.getOccupancy((ReservationDetails) Mockito.any())).thenReturn(bookingList);
			Mockito.when(hotelReserveService.returnResults((ReservationDetails) Mockito.any())).thenReturn(bookingList);
			String resp=hotelReservationControlller.getBookingDetails(reservationDetails, bindingResult, request, response, model);
			Assert.assertNotNull(resp);
		} catch (HotelReservationException e) {
						e.printStackTrace();
		}
	}
	
	@Test
	public void testlowestFare() {
		try {
			Mockito.when(hotelReserveService.searchHotel()).thenReturn(hotelDetails1);
			String resp=hotelReservationControlller.lowestFare(model, request);
			Assert.assertNotNull(resp);
		} catch (HotelReservationException e) {
						e.printStackTrace();
		}
	}

	
	@Test
	public void testgetlowestHotel() {
		try {
			
			try {
				Mockito.when(hotelReserveService.getLowestfareHotels(Mockito.anyString())).thenReturn(hotelDetails1);
				String resp=hotelReservationControlller.getHotelname(model, request, response);
				Assert.assertNotNull(resp);
			} catch (IOException e) {
					e.printStackTrace();
			}
			} catch (HotelReservationException e) {
						e.printStackTrace();
			}
	}
	
	/**
	 * Test method for {@link com.mindtree.service.HotelReserveServiceImpl#returnResults(java.lang.String, java.lang.String, int, java.lang.String)}.
	 */
//	@Test
//	@Transactional
//	public void testReturnResults() {
//		BookingDetail bookingDetail=hotelReserveDao.returnResults("24-03-2016","26-03-2016", 2, "chirayu.singhvi@mindtree.com").get(0);
//		Assert.assertEquals("Marriot Downtown", bookingDetail.getHotel().getHotelName());
//	}
	

}
