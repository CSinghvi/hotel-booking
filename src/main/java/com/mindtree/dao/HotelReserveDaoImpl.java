/**
 * 
 */
package com.mindtree.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.dto.LoginDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;
import com.mindtree.util.DatabaseUtil;

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
	

	public List<Customer> getLoginDetails(LoginDetails loginform) {
//		Session session=new DatabaseUtil().getSession(); 
//		Transaction t=new DatabaseUtil().getTransaction(); 
		System.out.println("reaching dao");
		String email=loginform.getEmail();
		System.out.println(loginform.getEmail());
		String password=loginform.getPassword();
		System.out.println(loginform.getPassword());
		Session session=sessionFactory.openSession();
		System.out.println("gonna excecute the Query");
		@SuppressWarnings("unchecked")
		List<Customer> custDetails=session.createQuery("FROM Customer c where c.email='"+email+"' AND c.password='"+password+"'").list();
//		t.commit();
//		sessionFactory.getCurrentSession().close();
		System.out.println(custDetails);
		System.out.println("successfully retrived customer details"); 
		return custDetails;
	}

	public List<Hotel> getHotelNameFromDB1(String city) {
//		Session session=new DatabaseUtil().getSession(); 
//		Transaction t=new DatabaseUtil().getTransaction(); 
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Hotel> hotelDetails=session.createQuery("FROM Hotel h where h.city="+city).list();
		System.out.println("in dao from get hotel details function"+hotelDetails);
//		t.commit();
//		sessionFactory.getCurrentSession().close();
		return hotelDetails;
	}


	public List<BookingDetail> returnResults(String checkIn, String checkOut, int hotelid, String email) {
//		Session session=new DatabaseUtil().getSession(); 
//		Transaction t=new DatabaseUtil().getTransaction(); 
		System.out.println("checking for email"+email);
		Session session=sessionFactory.openSession();
		Hotel hotel=(Hotel) session.createQuery("FROM Hotel h where h.hotelId="+hotelid).uniqueResult();

		Customer customer=(Customer) session.createQuery("FROM Customer c where c.email='"+email+"'").uniqueResult();

		System.out.println("checking customer is printing or not"+customer);

		BookingDetail book=new BookingDetail();
		book.setCheckIn(checkIn);
		book.setCheckOut(checkOut);
		book.setHotel(hotel);
		book.setCust(customer);
		session.save(book);

		
		@SuppressWarnings("unused")
		String cityState=hotel.getCity()+","+hotel.getState();
		@SuppressWarnings("unchecked")
		List<BookingDetail> bookingDetail=session.createQuery("FROM BookingDetail b where b.cust.customerId='"+customer.getCustomerId()+"'").list();
	
//		t.commit();
//		sessionFactory.getCurrentSession().close();
		return bookingDetail;
	}






}
