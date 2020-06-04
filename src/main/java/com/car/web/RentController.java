package com.car.web;

import com.car.entity.Car;
import com.car.entity.CustomerCard;
import com.car.service.CarService;
import com.car.service.RentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RentController {

	private RentService rentService;

	@Autowired
	public void setRentService(RentService rentService) {
		this.rentService = rentService;
	}

	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping("/rentcar.html")
	public ModelAndView carRent(HttpServletRequest request) {
		String carId = request.getParameter("carId").toString();
		Car car = carService.getCar(carId);
		ModelAndView modelAndView = new ModelAndView("admin_car_rent");
		modelAndView.addObject("car", car);
		return modelAndView;
	}

	@RequestMapping("/rentcardo.html")
	public String carRentDo(HttpServletRequest request, RedirectAttributes redirectAttributes, int customerId) {
		String carId = request.getParameter("id").toString();
		boolean rentsucc = rentService.carRent(carId, customerId);
		if (rentsucc) {
			redirectAttributes.addFlashAttribute("succ", "Succeed. ");
			return "redirect:/allcars.html";
		} else {
			redirectAttributes.addFlashAttribute("succ", "Error. ");
			return "redirect:/allcars.html";
		}

	}

	@RequestMapping("/returncar.html")
	public String carReturn(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String carId = request.getParameter("carId").toString();
		boolean retSucc = rentService.carReturn(carId);
		if (retSucc) {
			redirectAttributes.addFlashAttribute("succ", "Returned. ");
			return "redirect:/allcars.html";
		} else {
			redirectAttributes.addFlashAttribute("error", "Error");
			return "redirect:/allcars.html";
		}
	}

	@RequestMapping("/rentlist.html")
	public ModelAndView rentList() {

		ModelAndView modelAndView = new ModelAndView("admin_rent_list");
		modelAndView.addObject("list", rentService.rentList());
		return modelAndView;
	}

	@RequestMapping("/myrent.html")
	public ModelAndView myRent(HttpServletRequest request) {
		CustomerCard customerCard = (CustomerCard) request.getSession().getAttribute("customercard");
		ModelAndView modelAndView = new ModelAndView("customer_rent_list");
		modelAndView.addObject("list", rentService.myRentList(customerCard.getCustomerId()));
		return modelAndView;
	}

}
