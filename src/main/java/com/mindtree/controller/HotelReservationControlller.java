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

	@RequestMapping(method = RequestMethod.GET, value = "/fetch.view")
	public String addQuestionnaire(Model model, HttpServletRequest request) throws HotelReservationException {
		hotelDetails1 = hotelReserveService.searchHotel();
		model.addAttribute("hotelDetails", hotelDetails1);
		ReservationDetails details = new ReservationDetails();
		model.addAttribute("details", details);
		return "BookHotel";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getHotelName.view")
	public String printhotelname(Model model, HttpServletRequest request, HttpServletResponse response)
			throws HotelReservationException, IOException {
		System.out.println("idhar to aa gaya");
		String city = request.getParameter("list");
		System.out.println("city name" + city);
		hotelDetails = hotelReserveService.getHotel(city);
		model.addAttribute("hotelDetails", hotelDetails);
		System.out.println(hotelDetails.get(0).getHotelName());

		
		String details = "<option   id=0   value='0' name='hotel'  >Select</option>";

		for (int i = 0; i < hotelDetails.size(); i++) {
			details = details + "<option   id=" + i + "   value=" + hotelDetails.get(i).getHotelId() + " name='hotel' >"
					+ hotelDetails.get(i).getHotelName() + "</option>";
		}

		return details;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login.view")
	public String login(@Valid @ModelAttribute("details") ReservationDetails reservationDetails,
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
			System.out.println(
					"andhar aa rha h..............................................................................................................");

			for (int j = 0; j < occupancyList.size(); j++) {

				if ((occupancyList.get(j).getCheckIn().equals(reservationDetails.getCheckIn())
						|| occupancyList.get(j).getCheckIn().equals(reservationDetails.getCheckOut()))
						|| (occupancyList.get(j).getCheckOut().equals(reservationDetails.getCheckIn())
								|| occupancyList.get(j).getCheckOut().equals(reservationDetails.getCheckOut()))) {
					System.out.println("1st condition aa rha h.................................................");
					occ = occ + occupancyList.get(j).getOccupied();
					break;
				}

			}

		}
		System.out.println(rooms + " Rooms**********************************************************");

		occupiedRooms = occupiedRooms + occ;
		System.out.println(occupiedRooms + " occupiedRooms**********************************************************");

		available = rooms - occ;
		System.out.println(available + " available **********************************************************");

		validation.validate(reservationDetails, bindingResult);
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

	@RequestMapping(method = RequestMethod.GET, value = "/lowest.view")
	public String lowestFare(Model model, HttpServletRequest request) throws HotelReservationException {

		hotelDetails = hotelReserveService.searchHotel();
		model.addAttribute("hotelDetails", hotelDetails);

		System.out.println("YHA BHI AA RHA H");
		return "LowestPricedHotels";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getlowestHotel.view")
	public String getlowestHotel(Model model, HttpServletRequest request, HttpServletResponse response)
			throws HotelReservationException, IOException {
		System.out.println("idhar to aa gaya");
		String city = request.getParameter("list");
		System.out.println("city name" + city);
		hotelDetails = hotelReserveService.getLowestfareHotels(city);
		model.addAttribute("hotelDetails", hotelDetails);
		System.out.println(hotelDetails.get(0).getHotelName());

		String details = "<table border='1' ><tr><td>Hotel Name</td><td>Rate(INR)</td</tr>";

		for (int i = 0; i < hotelDetails.size(); i++) {
			details = details + "<tr><td>" + hotelDetails.get(i).getHotelName() + " </td><td>"
					+ hotelDetails.get(i).getRate() + "</td></tr>";
		}
		details = details + "</table>";

		return details;
	}

}
