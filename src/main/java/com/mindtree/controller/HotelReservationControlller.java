/**
 * 
 */
package com.mindtree.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.entity.Hotel;
import com.mindtree.dto.LoginDetails;
import com.mindtree.dto.ReservationDetails;
import com.mindtree.entity.BookingDetail;
import com.mindtree.entity.Customer;
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
	public void setSer(HotelReserveService ser) {
		this.hotelReserveService= ser;
	}

	Validations validation=new Validations();
	LoginValidator loginValidator=new  LoginValidator();
	
//	@RequestMapping(method=RequestMethod.GET,value="/search.view")
//	public String goToSearchPage()throws IOException,ServletException{
//		
//		return "SearchHotel";
//	}	
	
	@RequestMapping(method=RequestMethod.GET,value="/fetch.view")
	public String addQuestionnaire(Model model,HttpServletRequest request) throws HotelReservationException {
		String search=request.getParameter("name");
		List<Hotel> hotelDetails=hotelReserveService.searchHotel(search);
		model.addAttribute("hotelDetails",hotelDetails);
		return "BookHotel";
		}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,value="/viewHotel.view")
		public String viewHotels(@RequestParam String city,Model model,HttpServletRequest request) throws HotelReservationException {
	
//	Customer loginForm=new Customer();
//	model.addAttribute("loginform",loginForm);
		
		
		List<Hotel> hotelDetails=hotelReserveService.getHotel(city);
		
		model.addAttribute("hotelDetails",hotelDetails);
		
		
//		int id=hotelDetails.get(0).getHotelId();
//	String details1="<h1>"+hotelDetails.get(0).getHotelName()+"</h1><br><br>"+hotelDetails.get(0).getAddress()
//			+ ","+hotelDetails.get(0).getZip()+"<br>"+hotelDetails.get(0).getCity()+"<br><br>"+hotelDetails.get(0).getRate()
//			+"<br><button  id='myBtn'><a href=check.view?details="+id+">Book Hotel</a></button></div>";
	
	String details= "Hotel: <select id='mySelect' name='city'>" 
					+"<option   id=0   value='0'  >Select</option>"
					+"	<c:forEach items='${hotelDetails}' var='hotelname'>"
					+"<option   id=2   value='${hotelname}'  >"
					+"<c:out value='${hotelname.getHotelName()}' />"
					+"</option>"
					+"</c:forEach>"
					+"</select>";

	
	String test="hello";
	
	
	
//	+hotelDetails.get(0).getHotelId()
	System.out.println(details);
		return test;
		}
	
	
	
	
	
	
	
	
	
	public static String det;
	
	@RequestMapping(method=RequestMethod.GET,value="/check.view")
	public String gotoLoginPage( Model model,HttpServletRequest request) throws HotelReservationException {
		//String search=request.getParameter("name");
		 det=request.getParameter("details");
		LoginDetails loginForm=new LoginDetails();
		model.addAttribute("loginform",loginForm);
		model.addAttribute("details",det);
		return "LoginPage";
		}
	
	public static List<Customer> custDetails1;
	public static List<Hotel> hotelDetails1;
	
	@RequestMapping(method=RequestMethod.POST,value="/login.view")
	public String login(@Valid @ModelAttribute("loginform") LoginDetails loginform,BindingResult result,@RequestParam int hotelid,  Model model) throws HotelReservationException {
	
		loginValidator.validate(loginform,result);
		
		if(result.hasErrors())
		{
				
//			LoginDetails loginForm=new LoginDetails();
//			model.addAttribute("loginform",loginForm);
			model.addAttribute("details",det);
			return "LoginPage";
		}
		
		custDetails1=hotelReserveService.getLoginDetails(loginform);
System.out.println("login me "+hotelid);
ReservationDetails reservationDetails=new ReservationDetails();
		System.out.println("in controller checking detAILS for login detils from jsp"+loginform.getEmail()+" &  "+loginform.getPassword());
		//hotelDetails1=hotelReserveService.getHotel(hotelid);
		//System.out.println("in login.view "+hotelDetails1);
		System.out.println("back in controller "+custDetails1.get(0).getEmail());
		System.out.println("in login view"+loginform);
		System.out.println("Now its gonna compare pass and email");
//		System.out.println("along with cust checkin hotel details "+hotelid);
		if(loginform.getEmail().equals(custDetails1.get(0).getEmail())  && loginform.getPassword().equals(custDetails1.get(0).getPassword()))
		{
			System.out.println("email matched");
			model.addAttribute("custDetails",custDetails1);
		model.addAttribute("hotelDetails1",hotelDetails1);
		model.addAttribute("reservationDetails",reservationDetails);
			return "BookingDetails";
		}
		else
		{
			System.out.println("email or pass not matched");
			model.addAttribute("errmsg","Invalid Login Details!!!");
			return "LoginPage";
		}	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/placeOrder.view")
	public String returnResults(@Valid @ModelAttribute("reservationDetails") ReservationDetails reservationDetails ,BindingResult bindingResult ,@RequestParam int hotelid,@RequestParam String email,Model model,HttpServletRequest request) throws HotelReservationException {
		DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy");
		Date day=new Date();
		String date=dateFormat.format(day);
		
		validation.validate(reservationDetails, bindingResult);
		if(bindingResult.hasErrors())
		{
			model.addAttribute("custDetails",custDetails1);
			model.addAttribute("hotelDetails1",hotelDetails1);
			model.addAttribute("reservationDetails",reservationDetails);
			return "BookingDetails";
		}
		
		String checkIn=reservationDetails.getCheckIn();
		String checkOut=reservationDetails.getCheckOut();
		List<BookingDetail> reserveList= hotelReserveService.returnResults(checkIn,checkOut,hotelid,email);
//		Customer loginForm=new Customer();
	model.addAttribute("reserveList",reserveList);
	model.addAttribute("date",date);
	System.out.println("in contoller........."+reserveList);
		return "ResevationInformation";
		}
	
	
}
