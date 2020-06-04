package com.car.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.entity.Car;
import com.car.service.CarService;

@Controller
public class CarController {
	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping("/customer_querycar.html")
	public ModelAndView customerQueryCar() {
		return new ModelAndView("customer_car_query");

	}

	@RequestMapping("/allcars.html")
	public ModelAndView allCar() {
		ArrayList<Car> cars = carService.getAllCars();
		ModelAndView modelAndView = new ModelAndView("admin_cars");
		modelAndView.addObject("cars", cars);
		return modelAndView;
	}

	@RequestMapping("/deletecar.html")
	public String deleteCar(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String carId = request.getParameter("carId").toString();
		int res = carService.deleteCar(carId);

		if (res == 1) {
			redirectAttributes.addFlashAttribute("succ", "Deleted");
			return "redirect:/allcars.html";
		} else {
			redirectAttributes.addFlashAttribute("error", "Error");
			return "redirect:/allcars.html";
		}
	}

	@RequestMapping("/car_add.html")
	public ModelAndView addCar(HttpServletRequest request) {

		return new ModelAndView("admin_car_add");

	}

	@RequestMapping("/car_add_do.html")
	public String addCarDo(CarAddCommand carAddCommand, RedirectAttributes redirectAttributes) {
		Car car = new Car();
		car.setCarId(carAddCommand.getCarId());
		car.setState(carAddCommand.getState());
		car.setIntroduction(carAddCommand.getIntroduction());
		car.setBrand(carAddCommand.getBrand());
		car.setType(carAddCommand.getType());
		car.setManufactureDate(carAddCommand.getManufactureDate());

		boolean succ = carService.addCar(car);
		if (succ) {
			redirectAttributes.addFlashAttribute("succ", "Added. ");
			return "redirect:/allcars.html";
		} else {
			redirectAttributes.addFlashAttribute("succ", "Error. ");
			return "redirect:/allcars.html";
		}
	}

	@RequestMapping("/updatecar.html")
	public ModelAndView carEdit(HttpServletRequest request) {
		String carId = request.getParameter("carId").toString();
		Car car = carService.getCar(carId);
		ModelAndView modelAndView = new ModelAndView("admin_car_edit");
		modelAndView.addObject("detail", car);
		return modelAndView;
	}

	@RequestMapping("/car_edit_do.html")
	public String carEditDo(HttpServletRequest request, CarAddCommand carAddCommand,
			RedirectAttributes redirectAttributes) {
		Car car = new Car();
		car.setCarId(carAddCommand.getCarId());
		car.setState(carAddCommand.getState());
		car.setIntroduction(carAddCommand.getIntroduction());
		car.setBrand(carAddCommand.getBrand());
		car.setType(carAddCommand.getType());
		car.setManufactureDate(carAddCommand.getManufactureDate());

		boolean succ = carService.editCar(car);
		if (succ) {
			redirectAttributes.addFlashAttribute("succ", "Updated. ");
			return "redirect:/allcars.html";
		} else {
			redirectAttributes.addFlashAttribute("error", "Error. ");
			return "redirect:/allcars.html";
		}
	}

	@RequestMapping("/cardetail.html")
	public ModelAndView carDetail(HttpServletRequest request) {
		String carId = request.getParameter("carId").toString();
		Car car = carService.getCar(carId);
		ModelAndView modelAndView = new ModelAndView("admin_car_detail");
		modelAndView.addObject("detail", car);
		return modelAndView;
	}

	@RequestMapping("/customercardetail.html")
	public ModelAndView customerCarDetail(HttpServletRequest request) {
		String carId = request.getParameter("carId").toString();
		Car car = carService.getCar(carId);
		ModelAndView modelAndView = new ModelAndView("customer_car_detail");
		modelAndView.addObject("detail", car);
		return modelAndView;
	}

}
