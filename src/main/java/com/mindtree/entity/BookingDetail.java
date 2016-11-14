/**
 * 
 */
package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Booking Detils entity class
 * @author M1035998
 *
 */
@Entity
@Table(name="booking_details")
public class BookingDetail {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="confirmation_no")
int confirmationNumber;

@Column(name="occupied")
int occupied;

@Column(name="bill")
double bill;

@Column(name="check_in")
String checkIn;
@Column(name="check_out")
String checkOut;
@ManyToOne
@JoinColumn(name = "hotel_id")
Hotel hotel;


public BookingDetail() {
	super();
	// TODO Auto-generated constructor stub
}


public BookingDetail(int confirmationNumber, int occupied, double bill, String checkIn, String checkOut, Hotel hotel) {
	super();
	this.confirmationNumber = confirmationNumber;
	this.occupied = occupied;
	this.bill = bill;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.hotel = hotel;
}


public int getConfirmationNumber() {
	return confirmationNumber;
}


public void setConfirmationNumber(int confirmationNumber) {
	this.confirmationNumber = confirmationNumber;
}


public int getOccupied() {
	return occupied;
}


public void setOccupied(int occupied) {
	this.occupied = occupied;
}


public double getBill() {
	return bill;
}


public void setBill(double bill) {
	this.bill = bill;
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


public Hotel getHotel() {
	return hotel;
}


public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}




}
