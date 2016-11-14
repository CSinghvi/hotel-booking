/**
 * 
 */
package com.mindtree.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;
import com.mindtree.service.HotelReserveService;
import com.mindtree.util.Validations;

/**
 * @author M1035998
 *
 */
@Controller
public class HotelReservationControlller {
	@Autowired
	HotelReserveService hotelReserveService;

	public HotelReserveService getHotelReserveService() {
		return hotelReserveService;
	}

	public void setHotelReserveService(HotelReserveService hotelReserveService) {
		this.hotelReserveService = hotelReserveService;
	}

	Validations validation = new Validations();


	public static List<Hotel> hotelDetails1, hotelDetails;

	public static int occupiedRooms, available;

	/**fetch city name from database and returns to BookHOTEL.JSP
	 * @param model
	 * @param request
	 * @return BookHotel
	 * @throws HotelReservationException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/fetch.view")
	public String getCity(Model model, HttpServletRequest request) throws HotelReservationException {
		hotelDetails1 = hotelReserveService.searchHotel();
		model.addAttribute("hotelDetails", hotelDetails1);
		ReservationDetails details = new ReservationDetails();
		model.addAttribute("details", details);
		return "BookHotel";
	}

	/**AJax call for getting hotels of selected city
	 * @param model
	 * @param request
	 * @param response
	 * @return string details
	 * @throws HotelReservationException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getHotelName.view")
	public String getHotelname(Model model, HttpServletRequest request, HttpServletResponse response)
			throws HotelReservationException, IOException {
		String city = request.getParameter("list");
		hotelDetails = hotelReserveService.getHotel(city);
		model.addAttribute("hotelDetails", hotelDetails);
		
		String details = "<option   id=0   value='0' name='hotel'  >Select</option>";

		for (int i = 0; i < hotelDetails.size(); i++) {
			details = details + "<option   id=" + i + "   value=" + hotelDetails.get(i).getHotelId() + " name='hotel' >"
					+ hotelDetails.get(i).getHotelName() + "</option>";
		}
		return details;
	}

	/**All booking details entered by users is processed here
	 * and result is shown on ResevationInformation.jsp
	 * @param reservationDetails
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param model
	 * @return ReservationInformation
	 * @throws HotelReservationException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/login.view")
	public String getBookingDetails(@Valid @ModelAttribute("details") ReservationDetails reservationDetails,
			BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response, Model model)
			throws HotelReservationException {
		hotelDetails = hotelReserveService.getHotel(reservationDetails.getCity());
		int rooms = 0;
		int occ = 0;

		for (int i = 0; i < hotelDetails.size(); i++) {
			if (hotelDetails.get(i).getHotelId() == reservationDetails.getHotelId())
				rooms = hotelDetails.get(i).getRooms();
		}
		List<BookingDetail> occupancyList = hotelReserveService.getOccupancy(reservationDetails);
		if (occupancyList != null) {
						for (int j = 0; j < occupancyList.size(); j++) {

				if ((occupancyList.get(j).getCheckIn().equals(reservationDetails.getCheckIn())
						|| occupancyList.get(j).getCheckIn().equals(reservationDetails.getCheckOut()))
						|| (occupancyList.get(j).getCheckOut().equals(reservationDetails.getCheckIn())
								|| occupancyList.get(j).getCheckOut().equals(reservationDetails.getCheckOut()))) {
					occ = occ + occupancyList.get(j).getOccupied();
					break;
				}
			}
		}
		occupiedRooms = occupiedRooms + occ;
		available = rooms - occ;
		validation.validate(reservationDetails, bindingResult);
		
		//If there is any error it will redirect again to BookHotel.jsp
		if (bindingResult.hasErrors()) {
			model.addAttribute("hotelDetails", hotelDetails1);
			model.addAttribute("details", reservationDetails);
			return "BookHotel";
		}

		List<BookingDetail> reserveList = hotelReserveService.returnResults(reservationDetails);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date day = new Date();
		String date = dateFormat.format(day);
		model.addAttribute("reserveList", reserveList);
		model.addAttribute("date", date);
		return "ResevationInformation";
	}

	
	/**2nd usecase for getting city name and redirecting to LowestPricedHotels.jsp
	 * @param model
	 * @param request
	 * @return
	 * @throws HotelReservationException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/lowest.view")
	public String lowestFare(Model model, HttpServletRequest request) throws HotelReservationException {
		hotelDetails = hotelReserveService.searchHotel();
		model.addAttribute("hotelDetails", hotelDetails);
		return "LowestPricedHotels";
	}

	
	/**Ajax call, 5 hotels with lowest price is fetched from database of a selected city
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws HotelReservationException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getlowestHotel.view")
	public String getlowestHotel(Model model, HttpServletRequest request, HttpServletResponse response)
			throws HotelReservationException, IOException {
		String city = request.getParameter("list");
		hotelDetails = hotelReserveService.getLowestfareHotels(city);
		model.addAttribute("hotelDetails", hotelDetails);
		String details = "<table border='1' ><tr><td>Hotel Name</td><td>Rate(INR)</td</tr>";
		for (int i = 0; i < hotelDetails.size(); i++) {
			details = details + "<tr><td>" + hotelDetails.get(i).getHotelName() + " </td><td>"
					+ hotelDetails.get(i).getRate() + "</td></tr>";
		}
		details = details + "</table>";
		return details;
	}

}
