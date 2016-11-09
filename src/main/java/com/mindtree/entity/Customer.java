///**
// * 
// */
//package com.mindtree.entity;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
///**
// * Entity cass for customer
// * @author M1035998
// *
// */
//@Entity
//@Table(name="customer")
//public class Customer {
///**
//	 * @return the customerId
//	 */
//	public int getCustomerId() {
//		return customerId;
//	}
//
//	/**
//	 * @param customerId the customerId to set
//	 */
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//
//	/**
//	 * @return the customerName
//	 */
//	public String getCustomerName() {
//		return customerName;
//	}
//
//	/**
//	 * @param customerName the customerName to set
//	 */
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//
//	/**
//	 * @return the email
//	 */
//	public String getEmail() {
//		return email;
//	}
//
//	/**
//	 * @param email the email to set
//	 */
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	/**
//	 * @return the password
//	 */
//	public String getPassword() {
//		return password;
//	}
//
//	/**
//	 * @param password the password to set
//	 */
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	/**
//	 * @return the booking
//	 */
//	public Set<BookingDetail> getBooking() {
//		return booking;
//	}
//
//	/**
//	 * @param booking the booking to set
//	 */
//	public void setBooking(Set<BookingDetail> booking) {
//		this.booking = booking;
//	}
//
//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	@Override
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
//				+ ", password=" + password + ", booking=" + booking + "]";
//	}
//
///**
//	 * @param customerId
//	 * @param customerName
//	 * @param email
//	 * @param password
//	 * @param booking
//	 */
//	public Customer(int customerId, String customerName, String email, String password, Set<BookingDetail> booking) {
//		super();
//		this.customerId = customerId;
//		this.customerName = customerName;
//		this.email = email;
//		this.password = password;
//		this.booking = booking;
//	}
//
//@Id	
//@GeneratedValue(strategy=GenerationType.IDENTITY)
//@Column(name="cust_id")
//int customerId;
//@Column(name="cust_name")
//String customerName;
//@Column(name="email")
//String email;
//@Column(name="pass")
//String password;
//@OneToMany(mappedBy = "cust", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//Set<BookingDetail> booking=new HashSet<BookingDetail>();
//
//public Customer() {
//	super();
//	// TODO Auto-generated constructor stub
//}
//}
