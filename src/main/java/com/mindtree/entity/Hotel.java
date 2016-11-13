/**
 * 
 */
package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author M1035998
 *
 */
@Entity
@Table(name="hotels")
public class Hotel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="hotel_id")
int hotelId;

@Column(name="hotel_name")
String hotelName;

@Column(name="address")
String address;

@Column(name="city")
String city;

@Column(name="state")
String state;

@Column(name="zip")
int zip;

@Column(name="rate")
double rate;

@Column(name="rooms")
int rooms;

public Hotel() {
	super();
	// TODO Auto-generated constructor stub
}

public Hotel(int hotelId, String hotelName, String address, String city, String state, int zip, double rate,
		int rooms) {
	super();
	this.hotelId = hotelId;
	this.hotelName = hotelName;
	this.address = address;
	this.city = city;
	this.state = state;
	this.zip = zip;
	this.rate = rate;
	this.rooms = rooms;
}

public int getHotelId() {
	return hotelId;
}

public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}

public String getHotelName() {
	return hotelName;
}

public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public int getZip() {
	return zip;
}

public void setZip(int zip) {
	this.zip = zip;
}

public double getRate() {
	return rate;
}

public void setRate(double rate) {
	this.rate = rate;
}

public int getRooms() {
	return rooms;
}

public void setRooms(int rooms) {
	this.rooms = rooms;
}








}
