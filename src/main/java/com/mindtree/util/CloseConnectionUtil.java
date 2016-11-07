package com.mindtree.util;



import org.hibernate.Session;

import com.mindtree.exceptions.HotelReservationException;





public class CloseConnectionUtil 
{
	public static void closeSession(Session session) throws HotelReservationException
	{
		try
		{
			if(session!=null)
			{
				session.close();
			}
		}
		catch(Exception e)
		{
			throw(new HotelReservationException("Connection not closed Properly!!",e));
		}
	}
}
