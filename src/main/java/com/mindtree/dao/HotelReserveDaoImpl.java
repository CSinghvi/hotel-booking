/**
 * 
 */
package com.mindtree.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;

/**
 * @author M1035998
 *
 */
//
// @Repository
public class HotelReserveDaoImpl implements HotelReserveDao {

	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> getHotelNameFromDB() throws HotelReservationException {
		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("rawtypes")
			List hotelName = session.createQuery("select h.city FROM Hotel h").list();
			Set<String> hs = new HashSet<>();
			hs.addAll(hotelName);
			hotelName.clear();
			hotelName.addAll(hs);
			System.out.println("successfully retrived");
			return hotelName;
		} catch (Exception e) {
			e.printStackTrace();
			throw (new HotelReservationException("Problem in database Connectivity!!", e));
		}
	}

	public List<Hotel> getHotelNameFromDB1(String city) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Hotel> hotelDetails = session.createQuery("FROM Hotel h where h.city='" + city + "'").list();
		return hotelDetails;
	}

	public List<BookingDetail> getOccupancy(ReservationDetails reservationDetail) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<BookingDetail> bookingDetail = session
				.createQuery("FROM  BookingDetail f where f.hotel.hotelId=" + reservationDetail.getHotelId()).list();
		return bookingDetail;

	}

	public List<BookingDetail> returnResults(ReservationDetails reservationDetail) {
		int hotelid = reservationDetail.getHotelId();
		Session session = sessionFactory.openSession();
		Hotel hotel = (Hotel) session.createQuery("FROM Hotel h where h.hotelId=" + hotelid).uniqueResult();
		BookingDetail book = new BookingDetail();
		book.setCheckIn(reservationDetail.getCheckIn());
		book.setCheckOut(reservationDetail.getCheckOut());
		book.setOccupied(reservationDetail.getRoom());
		book.setHotel(hotel);
		session.save(book);
		@SuppressWarnings("unused")
		String cityState = hotel.getCity() + "," + hotel.getState();
		@SuppressWarnings("unchecked")
		List<BookingDetail> bookingDetail = session
				.createQuery("FROM  BookingDetail f "
						+ "where f.confirmationNumber=(select max(ff.confirmationNumber) from BookingDetail ff )")
				.list();
		return bookingDetail;
	}

	public List<Hotel> getLowestfareHotels(String city) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("FROM Hotel h where h.city='" + city + "' order by h.rate");
		q.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<Hotel> hotelDetails = q.list();
		return hotelDetails;
	}

}
