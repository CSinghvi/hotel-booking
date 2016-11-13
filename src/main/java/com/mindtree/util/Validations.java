/**
 * 
 */
package com.mindtree.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.controller.HotelReservationControlller;
import com.mindtree.dto.ReservationDetails;
import com.mindtree.service.HotelReserveServiceImpl;

/**
 * @author M1035998
 *
 */
@Component
public class Validations implements Validator {

	private Pattern pattern;
	private Matcher matcher1;
	private Matcher matcher2;

	HotelReserveServiceImpl hotelser = new HotelReserveServiceImpl();

	public boolean supports(Class<?> clazz) {

		return ReservationDetails.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		int available = HotelReservationControlller.available;

		ReservationDetails data = (ReservationDetails) target;

	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		if (data.getCheckIn() == "" || data.getCheckOut() == "") {
			errors.rejectValue("invalidDate", "invalidDate.incorrect", "Check in or Check out date cannot be empty");
			return;

		}

		if (data.getCity() == "" || data.getCity() == "0") {
			errors.rejectValue("city", "city.incorrect", "Please select a  city");
			return;

		}

		if (data.getHotelId() == 0) {
			errors.rejectValue("hotelId", "hotelId.incorrect", "Please select a  hotel");
			return;

		}

		if (data.getRoom() > available) {
			errors.rejectValue("room", "room.incorrect", "Rooms not available, only " + available + "are available");
		}

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date day = new Date();
		String today = dateFormat.format(day);

		String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)";
		pattern = Pattern.compile(DATE_PATTERN);
		matcher1 = pattern.matcher(data.getCheckIn());
		matcher2 = pattern.matcher(data.getCheckOut());

		if (matcher1.matches() && matcher2.matches()) {

			try {
				Date tdyDate, ckInDate, ckOutDate, restrictCheckOut;

				tdyDate = dateFormat.parse(today);
	

				ckInDate = dateFormat.parse(data.getCheckIn());

			
				final Calendar calendar = Calendar.getInstance();
				calendar.setTime(ckInDate);
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				String restrictCheck = dateFormat.format(calendar.getTime());

				restrictCheckOut = dateFormat.parse(restrictCheck);

				
				ckOutDate = dateFormat.parse(data.getCheckOut());

				
				if (ckInDate.before(tdyDate)) {
					errors.rejectValue("checkIn", "checkIn.incorrect",
							"you have to provide today's or after today's date");
				}
				if (ckOutDate.before(ckInDate) || !ckOutDate.equals(restrictCheckOut)) {
					errors.rejectValue("checkOut", "checkOut.incorrect",
							"CheckOut Date should be after checkin date & and check out date should be just one day after check in date ie "
									+ restrictCheck);

				}
				if (ckInDate.equals(ckOutDate)) {
					errors.rejectValue("checkOut", "checkOut.incorrect", " you canot check out on the same date");

				}

			} catch (ParseException e) {

				e.printStackTrace();
			}

		}

		else {

			errors.rejectValue("invalidDate", "invalidDate.incorrect", "Enter date in this format(dd-mm-yyyy)");

		}

	}

}
