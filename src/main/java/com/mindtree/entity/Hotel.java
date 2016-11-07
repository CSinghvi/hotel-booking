/**
 * 
 */
package com.mindtree.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author M1035998
 *
 */
@Entity
@Table(name="hotels")
public class Hotel {
/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * @return the booking
	 */
	public Set<BookingDetail> getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Set<BookingDetail> booking) {
		this.booking = booking;
	}

//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", city=" + city
//				+ ", state=" + state + ", zip=" + zip + ", rate=" + rate + ", booking=" + booking + "]";
//	}

/**
	 * @param hotelId
	 * @param hotelName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param rate
	 * @param booking
	 */
	public Hotel(int hotelId, String hotelName, String address, String city, String state, int zip, double rate,
			Set<BookingDetail> booking) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.rate = rate;
		this.booking = booking;
	}

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

@Column(name="occupied")
int occupied;


@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
Set<BookingDetail> booking=new HashSet<BookingDetail>();

/**
 * 
 */
public Hotel() {
	super();
	// TODO Auto-generated constructor stub
}
}
