/**
 * 
 */
package com.mindtree.dto;

/**
 * @author M1035998
 *
 */
public class ReservationDetails {
/**
	 * @return the confirmationNo
	 */
	public int getConfirmationNo() {
		return confirmationNo;
	}

	/**
	 * @param confirmationNo the confirmationNo to set
	 */
	public void setConfirmationNo(int confirmationNo) {
		this.confirmationNo = confirmationNo;
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
	 * @return the hName
	 */
	public String gethName() {
		return hName;
	}

	/**
	 * @param hName the hName to set
	 */
	public void sethName(String hName) {
		this.hName = hName;
	}

	/**
	 * @return the hAddress
	 */
	public String gethAddress() {
		return hAddress;
	}

	/**
	 * @param hAddress the hAddress to set
	 */
	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}

	/**
	 * @return the cityState
	 */
	public String getCityState() {
		return cityState;
	}

	/**
	 * @param cityState the cityState to set
	 */
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

/**
	 * @param confirmationNo
	 * @param checkIn
	 * @param checkOut
	 * @param hName
	 * @param hAddress
	 * @param cityState
	 */
	public ReservationDetails(int confirmationNo, String checkIn, String checkOut, String hName, String hAddress,
			String cityState) {
		super();
		this.confirmationNo = confirmationNo;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.hName = hName;
		this.hAddress = hAddress;
		this.cityState = cityState;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReservationDetails [confirmationNo=" + confirmationNo + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", hName=" + hName + ", hAddress=" + hAddress + ", cityState=" + cityState + "]";
	}

/**
	 * 
	 */
	public ReservationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

int confirmationNo;	
String checkIn;

String checkOut;

String hName;

String hAddress;

String cityState;

String invalidDate;

/**
 * @return the invalidDate
 */
public String getInvalidDate() {
	return invalidDate;
}

/**
 * @param invalidDate the invalidDate to set
 */
public void setInvalidDate(String invalidDate) {
	this.invalidDate = invalidDate;
}

}
