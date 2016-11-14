# hotel-booking
Spring 201 project

This is Hotel room booking web-app

Users can 
	1. Book a room in selected hotel.
	2. View 5 lowest priced hotels of selected city.
	
Setup :
 
	Database configuration:
		Please change the username and password for mysql in application/context file. 
		path- /HotelReservationVersion3/src/main/webapp/WEB-INF/applicationContext.xml
  
  
	Populating Database-
		please find the text file for populating the database in mentioned below address
		path-  /HotelReservationVersion3/hotel reservation sql.txt
		Copy the contents in mysql command client, the database will be populated.
  
  
Assumptions/Restrictions 
	-User can check-out only one day after the check-in not more or less than that, for as of now,
	 so billing is calculated on 1 day basis and further pricing depends on number of rooms booked.	
	-Login credentials is not present as it was not mentioned in the project description.

Running-
    Either deploy the war file on tomcat or simply run on server in eclipse.	