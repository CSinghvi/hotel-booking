package com.mindtree.dto;

public class HotelBookingDto {
int hotelId;
int rooms;
String checkIn;
String checkOut;

public HotelBookingDto() {
	super();
	// TODO Auto-generated constructor stub
}
public HotelBookingDto(int hotelId, int rooms, String checkIn, String checkOut) {
	super();
	this.hotelId = hotelId;
	this.rooms = rooms;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
}
public int getHotelId() {
	return hotelId;
}
public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}
public int getRooms() {
	return rooms;
}
public void setRooms(int rooms) {
	this.rooms = rooms;
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
@Override
public String toString() {
	return "HotelBookingDto [hotelId=" + hotelId + ", rooms=" + rooms + ", checkIn=" + checkIn + ", checkOut="
			+ checkOut + "]";
}




}
