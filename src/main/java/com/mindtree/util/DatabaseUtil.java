package com.mindtree.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseUtil 
{
	public Session getSession()
	{
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession(); 
	    
	    return session;
	}
	public Transaction getTransaction()
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		return transaction;
	}
}
