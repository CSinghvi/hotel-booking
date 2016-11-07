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


/**
	 * @return the confirmationNumber
	 */
	public int getConfirmationNumber() {
		return confirmationNumber;
	}
	/**
	 * @param confirmationNumber the confirmationNumber to set
	 */
	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	/**
	 * @return the checkIn
	 */
	public String getCheckIn() {
		return checkIn;
	}
	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	/**
	 * @return the checkOut
	 */
	public String getCheckOut() {
		return checkOut;
	}
	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}
	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	/**
	 * @return the cust
	 */
	public Customer getCust() {
		return cust;
	}
	/**
	 * @param cust the cust to set
	 */
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return "BookingDetail [confirmationNumber=" + confirmationNumber + ", checkIn=" + checkIn + ", checkOut="
//				+ checkOut + ", hotel=" + hotel + ", cust=" + cust + "]";
//	}
/**
	 * @param confirmationNumber
	 * @param checkIn
	 * @param checkOut
	 * @param hotel
	 * @param cust
	 */
	public BookingDetail(int confirmationNumber, String checkIn, String checkOut, Hotel hotel, Customer cust) {
		super();
		this.confirmationNumber = confirmationNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.hotel = hotel;
		this.cust = cust;
	}
/**
	 * 
	 */
	public BookingDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="confirmation_no")
int confirmationNumber;
@Column(name="check_in")
String checkIn;
@Column(name="check_out")
String checkOut;
@ManyToOne
@JoinColumn(name = "hotel_id")
Hotel hotel;
@ManyToOne
@JoinColumn(name = "cust_id")
Customer cust;
}
