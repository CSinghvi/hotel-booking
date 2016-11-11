/**
 * 
 */
package com.mindtree.dto;

/**
 * @author M1035998
 *
 */
public class ReservationDetails {

int hotelId;

int room;

String checkIn;

String checkOut;

String city;

String invalidDate;

public ReservationDetails() {
	super();
	// TODO Auto-generated constructor stub
}

public ReservationDetails(int hotelId, int room, String checkIn, String checkOut, String city, String invalidDate) {
	super();
	this.hotelId = hotelId;
	this.room = room;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.city = city;
	this.invalidDate = invalidDate;
}

public int getHotelId() {
	return hotelId;
}

public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}

public int getRoom() {
	return room;
}

public void setRoom(int room) {
	this.room = room;
}

public String getCheckIn() {
	return checkIn;
}

public void setCheckIn(String checkIn) {
	this.checkIn = checkIn;
}

public String getCheckOut() {
	return checkOut;
}

public void setCheckOut(String checkOut) {
	this.checkOut = checkOut;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getInvalidDate() {
	return invalidDate;
}

public void setInvalidDate(String invalidDate) {
	this.invalidDate = invalidDate;
}



}
