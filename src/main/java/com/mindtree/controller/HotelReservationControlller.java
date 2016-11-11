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

import com.mindtree.dto.HotelBookingDto;
import com.mindtree.dto.LoginDetails;
import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Hotel;
import com.mindtree.exceptions.HotelReservationException;
import com.mindtree.service.HotelReserveService;
import com.mindtree.util.LoginValidator;
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

	Validations validation=new Validations();
	LoginValidator loginValidator=new  LoginValidator();
	
	public static List<Hotel> hotelDetails1,hotelDetails;
	
	public static int occupiedRooms,available;
	
	@RequestMapping(method=RequestMethod.GET,value="/fetch.view")
	public String addQuestionnaire(Model model,HttpServletRequest request) throws HotelReservationException {
		//System.out.println("yaha p toh aa rha H");
		String search=request.getParameter("name");
		hotelDetails1=hotelReserveService.searchHotel(search);
		model.addAttribute("hotelDetails",hotelDetails1);
		LoginDetails login=new LoginDetails();
		login.setEmail("abc@gmail.com");
		ReservationDetails details=new ReservationDetails();
		model.addAttribute("details",details);
		model.addAttribute("login",login);
		System.out.println("YHA BHI AA RHA H");
		return "BookHotel";
		}
	

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,value="/getHotelName.view")
	public String printhotelname(Model model,HttpServletRequest request,HttpServletResponse response) throws HotelReservationException, IOException {
		System.out.println("idhar to aa gaya");
		 String city=request.getParameter("list");
		 System.out.println("city name"+city);
			hotelDetails=hotelReserveService.getHotel(city);
			model.addAttribute("hotelDetails",hotelDetails);
			System.out.println(hotelDetails.get(0).getHotelName());
		
			//"Hotel: <select id='mySelect' name='city'>" 
			
			String details= "<option   id=0   value='0' name='hotel'  >Select</option>";
			
			for(int i=0;i<hotelDetails.size();i++)
			{
				details=details+"<option   id="+i+"   value="+hotelDetails.get(i).getHotelId()+" name='hotel' >"+hotelDetails.get(i).getHotelName()+"</option>";
			}
		
						
			
		return details;
		}

		@RequestMapping(method=RequestMethod.POST,value="/login.view")
	public String login(@Valid @ModelAttribute("details") ReservationDetails reservationDetails ,BindingResult bindingResult ,HttpServletRequest request,HttpServletResponse response,  Model model) throws HotelReservationException {
			hotelDetails=hotelReserveService.getHotel(reservationDetails.getCity());
			int rooms = 0;
			int occ=0;
			
			for(int i=0;i<hotelDetails.size();i++)
			{
				if(hotelDetails.get(i).getHotelId()==reservationDetails.getHotelId())
					rooms=hotelDetails.get(i).getRooms();
			}
				
			List<BookingDetail> occupancyList=hotelReserveService.getOccupancy(reservationDetails);
			
			if(occupancyList!=null){
				System.out.println("andhar aa rha h.............................................................................................................."+occupancyList.get(0).getCheckIn());
				
				for(int j=0;j<occupancyList.size();j++)
				{
					
					if(occupancyList.get(j).getCheckIn().equals(reservationDetails.getCheckIn()) || occupancyList.get(j).getCheckIn().equals(reservationDetails.getCheckOut()))
							{
						System.out.println("1st condition aa rha h.................................................");
						 occ=occ+occupancyList.get(j).getOccupied();
						 break;
							}
					if(occupancyList.get(j).getCheckOut().equals(reservationDetails.getCheckIn()) || occupancyList.get(j).getCheckOut().equals(reservationDetails.getCheckOut()))
					{
						System.out.println("1st condition aa rha h..........................................");
				 occ=occ+occupancyList.get(j).getOccupied();
				 break;
					}			
					
				}
				
			}
			
			System.out.println(occ+"**********************************************************");
			
			 available=rooms-occ;
			 System.out.println(available+"**********************************************************");
			
			
			validation.validate(reservationDetails, bindingResult);
			if(bindingResult.hasErrors())
			{
				model.addAttribute("hotelDetails",hotelDetails1);
				model.addAttribute("details",reservationDetails);
				return "BookHotel";
			}
			
			
//			int rooms=Integer.parseInt(request.getParameter("rooms"));
//			String checkIn=request.getParameter("check_in");		
//			String checkOut=request.getParameter("check_out");
//			int hotelId=Integer.parseInt(request.getParameter("hotel"));
//			System.out.println("Checking hotel "+checkIn);
		
//		HotelBookingDto bookingDetails=new HotelBookingDto();
//		 bookingDetails.setCheckIn(checkIn);
//		 bookingDetails.setCheckOut(checkOut);
//		 bookingDetails.setHotelId(hotelId);
//		 bookingDetails.setRooms(rooms);
//		 
//		 System.out.println(bookingDetails);
		 
		 List<BookingDetail> reserveList=hotelReserveService.returnResults(reservationDetails);
		
		 
		 	
//			loginValidator.validate(loginform,result);
//		if(result.hasErrors())
//		{				
//			model.addAttribute("details",det);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date day=new Date();
			String date=dateFormat.format(day);
			
		 model.addAttribute("reserveList",reserveList);
		 model.addAttribute("date",date);
		 
		 return "ResevationInformation";
		}

	
	
	
	
//	public static String det;
//	
//	@RequestMapping(method=RequestMethod.GET,value="/check.view")
//	public String gotoLoginPage( Model model,HttpServletRequest request) throws HotelReservationException {
//		System.out.println("idhar to aa gaya");
//		//String search=request.getParameter("name");
//		 det=request.getParameter("details");
//		LoginDetails loginForm=new LoginDetails();
//		model.addAttribute("loginform",loginForm);
//		model.addAttribute("details",det);
//		return "LoginPage";
//		}
//	
//	public static List<Customer> custDetails1;
//	public static List<Hotel> hotelDetails1;
//	
//	@RequestMapping(method=RequestMethod.POST,value="/login.view")
//	public String login(@Valid @ModelAttribute("loginform") LoginDetails loginform,BindingResult result,@RequestParam int hotelid,  Model model) throws HotelReservationException {
//	
//		loginValidator.validate(loginform,result);
//		
//		if(result.hasErrors())
//		{
//				
////			LoginDetails loginForm=new LoginDetails();
////			model.addAttribute("loginform",loginForm);
//			model.addAttribute("details",det);
//			return "LoginPage";
//		}
//		
//		custDetails1=hotelReserveService.getLoginDetails(loginform);
//System.out.println("login me "+hotelid);
//ReservationDetails reservationDetails=new ReservationDetails();
//		System.out.println("in controller checking detAILS for login detils from jsp"+loginform.getEmail()+" &  "+loginform.getPassword());
//		//hotelDetails1=hotelReserveService.getHotel(hotelid);
//		//System.out.println("in login.view "+hotelDetails1);
//		System.out.println("back in controller "+custDetails1.get(0).getEmail());
//		System.out.println("in login view"+loginform);
//		System.out.println("Now its gonna compare pass and email");
////		System.out.println("along with cust checkin hotel details "+hotelid);
//		if(loginform.getEmail().equals(custDetails1.get(0).getEmail())  && loginform.getPassword().equals(custDetails1.get(0).getPassword()))
//		{
//			System.out.println("email matched");
//			model.addAttribute("custDetails",custDetails1);
//		model.addAttribute("hotelDetails1",hotelDetails1);
//		model.addAttribute("reservationDetails",reservationDetails);
//			return "BookingDetails";
//		}
//		else
//		{
//			System.out.println("email or pass not matched");
//			model.addAttribute("errmsg","Invalid Login Details!!!");
//			return "LoginPage";
//		}	
//	}
//	
//	@RequestMapping(method=RequestMethod.POST,value="/placeOrder.view")
//	public String returnResults(@Valid @ModelAttribute("reservationDetails") ReservationDetails reservationDetails ,BindingResult bindingResult ,@RequestParam int hotelid,@RequestParam String email,Model model,HttpServletRequest request) throws HotelReservationException {
//		DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy");
//		Date day=new Date();
//		String date=dateFormat.format(day);
//		
//		validation.validate(reservationDetails, bindingResult);
//		if(bindingResult.hasErrors())
//		{
//			model.addAttribute("custDetails",custDetails1);
//			model.addAttribute("hotelDetails1",hotelDetails1);
//			model.addAttribute("reservationDetails",reservationDetails);
//			return "BookingDetails";
//		}
//		
//		String checkIn=reservationDetails.getCheckIn();
//		String checkOut=reservationDetails.getCheckOut();
//		List<BookingDetail> reserveList= hotelReserveService.returnResults(checkIn,checkOut,hotelid,email);
////		Customer loginForm=new Customer();
//	model.addAttribute("reserveList",reserveList);
//	model.addAttribute("date",date);
//	System.out.println("in contoller........."+reserveList);
//		return "ResevationInformation";
//		}
	
	
}
