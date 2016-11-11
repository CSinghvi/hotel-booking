/**
 * 
 */
package com.mindtree.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//@Repository
public class HotelReserveDaoImpl implements HotelReserveDao{
	
	private SessionFactory sessionFactory;
	

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//	@SuppressWarnings("unchecked")
//	public List<Hotel> getHotelNameFromDB(String search) throws HotelReservationException
//	{
//		try
//		{
////			Session session=new DatabaseUtil().getSession(); 
////			Transaction t=new DatabaseUtil().getTransaction(); 
//
//			System.out.println("in search........... "+search);
//						Session session=sessionFactory.openSession();
//			List hotelName=session.createQuery("FROM Hotel h where h.hotelName like '%"+search+"%' ").list();
////			t.commit();
////			sessionFactory.getCurrentSession().close();
//
//			System.out.println("successfully retrived"); 
//			return hotelName;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw(new HotelReservationException("Problem in database Connectivity!!",e));
//		}
//	}
	
	
	@SuppressWarnings("unchecked")
	public List<Hotel> getHotelNameFromDB(String search) throws HotelReservationException
	{
		try
		{
//			Session session=new DatabaseUtil().getSession(); 
//			Transaction t=new DatabaseUtil().getTransaction(); 

			System.out.println("in search........... "+search);
						Session session=sessionFactory.openSession();
			List hotelName=session.createQuery("select h.city FROM Hotel h").list();
//			t.commit();
//			sessionFactory.getCurrentSession().close();
			Set<String> hs = new HashSet<>();
			hs.addAll(hotelName);
			hotelName.clear();
			hotelName.addAll(hs);
			System.out.println("successfully retrived"); 
			return hotelName;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw(new HotelReservationException("Problem in database Connectivity!!",e));
		}
	}
	

//	public List<Customer> getLoginDetails(LoginDetails loginform) {
////		Session session=new DatabaseUtil().getSession(); 
////		Transaction t=new DatabaseUtil().getTransaction(); 
//		System.out.println("reaching dao");
//		String email=loginform.getEmail();
//		System.out.println(loginform.getEmail());
//		String password=loginform.getPassword();
//		System.out.println(loginform.getPassword());
//		Session session=sessionFactory.openSession();
//		System.out.println("gonna excecute the Query");
//		@SuppressWarnings("unchecked")
//		List<Customer> custDetails=session.createQuery("FROM Customer c where c.email='"+email+"' AND c.password='"+password+"'").list();
////		t.commit();
////		sessionFactory.getCurrentSession().close();
//		System.out.println(custDetails);
//		System.out.println("successfully retrived customer details"); 
//		return custDetails;
//	}

	public List<Hotel> getHotelNameFromDB1(String city) {
//		Session session=new DatabaseUtil().getSession(); 
//		Transaction t=new DatabaseUtil().getTransaction(); 
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Hotel> hotelDetails=session.createQuery("FROM Hotel h where h.city='"+city+"'").list();
		System.out.println("in dao from get hotel details function"+hotelDetails);
//		t.commit();
//		sessionFactory.getCurrentSession().close();
		return hotelDetails;
	}

	
	public List<BookingDetail> getOccupancy(ReservationDetails reservationDetail) {
		Session session=sessionFactory.openSession();
		List<BookingDetail> bookingDetail=session.createQuery("FROM  BookingDetail f where f.hotel.hotelId="+reservationDetail.getHotelId()).list();
		
		return bookingDetail;
		
	}
	

	public List<BookingDetail> returnResults(ReservationDetails reservationDetail) {
//		Session session=new DatabaseUtil().getSession(); 
//		Transaction t=new DatabaseUtil().getTransaction(); 
		//System.out.println("checking for email"+email);
		int hotelid=reservationDetail.getHotelId();
		
		
		Session session=sessionFactory.openSession();
		
//		Hotel insertHotelRooms=new Hotel();
//		insertHotelRooms.setOccupied(reservationDetail.getRoom());
//		session.update(insertHotelRooms);
//		
//		Hotel insertHotelRooms = (Hotel) session.load(Hotel.class, hotelid);
//		insertHotelRooms.setOccupied(reservationDetail.getRoom());
//		session.merge(insertHotelRooms);
		
		Hotel hotel=(Hotel) session.createQuery("FROM Hotel h where h.hotelId="+hotelid).uniqueResult();

		//Customer customer=(Customer) session.createQuery("FROM Customer c where c.email='"+email+"'").uniqueResult();

		//System.out.println("checking customer is printing or not"+customer);

		BookingDetail book=new BookingDetail();
		book.setCheckIn(reservationDetail.getCheckIn());
		book.setCheckOut(reservationDetail.getCheckOut());
		book.setOccupied(reservationDetail.getRoom());
		book.setHotel(hotel);
		//book.setCust(customer);
		session.save(book);

		
		@SuppressWarnings("unused")
		String cityState=hotel.getCity()+","+hotel.getState();
		@SuppressWarnings("unchecked")
//		List<BookingDetail> bookingDetail=session.createQuery("Select ff.confirmationNumber FROM BookingDetail as ff").list();
		List<BookingDetail> bookingDetail=session.createQuery("FROM  BookingDetail f "
								+"where f.confirmationNumber=(select max(ff.confirmationNumber) from BookingDetail ff )").list();
//	List<BookingDetail> bookingDetail=session.createQuery("FROM  BookingDetail as f "
//			+"where f.confirmationNumber=1").list();
		
		
		
//		t.commit();
//		sessionFactory.getCurrentSession().close();
		return bookingDetail;
	}






}
