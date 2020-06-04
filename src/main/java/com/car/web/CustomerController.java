package com.car.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.entity.CustomerCard;
import com.car.entity.CustomerInfo;
import com.car.service.CustomerCardService;
import com.car.service.CustomerInfoService;
import com.car.service.LoginService;

@Controller
public class CustomerController {

	private CustomerInfoService customerInfoService;

	@Autowired
	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	private CustomerCardService customerCardService;

	@Autowired
	public void setCustomerCardService(CustomerCardService customerCardService) {
		this.customerCardService = customerCardService;
	}

	@RequestMapping("allcustomers.html")
	public ModelAndView allCars() {
		ArrayList<CustomerInfo> customers = customerInfoService.customerInfos();
		ModelAndView modelAndView = new ModelAndView("admin_customers");
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}

	@RequestMapping("customer_delete.html")
	public String customerDelete(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		boolean success = customerInfoService.deleteCustomerInfo(customerId);

		if (success) {
			redirectAttributes.addFlashAttribute("succ", "Deleted.");
			return "redirect:/allcustomers.html";
		} else {
			redirectAttributes.addFlashAttribute("error", "Error. ");
			return "redirect:/allcustomers.html";
		}

	}

	@RequestMapping("/customer_info.html")
	public ModelAndView toCustomerInfo(HttpServletRequest request) {
		CustomerCard customerCard = (CustomerCard) request.getSession().getAttribute("customercard");
		CustomerInfo customerInfo = customerInfoService.getCustomerInfo(customerCard.getCustomerId());
		ModelAndView modelAndView = new ModelAndView("customer_info");
		modelAndView.addObject("customerinfo", customerInfo);
		return modelAndView;
	}

	@RequestMapping("customer_edit.html")
	public ModelAndView customerInfoEdit(HttpServletRequest request) {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerInfo customerInfo = customerInfoService.getCustomerInfo(customerId);
		ModelAndView modelAndView = new ModelAndView("admin_customer_edit");
		modelAndView.addObject("customerInfo", customerInfo);
		return modelAndView;
	}

	@RequestMapping("customer_edit_do.html")
	public String customerInfoEditDo(HttpServletRequest request, String name, String sex, String birth, String address,
			String tel, RedirectAttributes redirectAttributes) {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerCard customerCard = loginService.findCustomerCardByUserId(customerId);
		String oldName = customerCard.getName();
		if (!oldName.equals(name)) {
			boolean succo = customerCardService.updateName(customerId, name);

			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setAddress(address);
			customerInfo.setBirth(birth);
			customerInfo.setName(name);
			customerInfo.setCustomerId(customerId);
			customerInfo.setTel(tel);
			customerInfo.setSex(sex);
			boolean succ = customerInfoService.editCustomerInfo(customerInfo);
			if (succo && succ) {
				redirectAttributes.addFlashAttribute("succ", "Updated. ");
				return "redirect:/allcustomers.html";
			} else {
				redirectAttributes.addFlashAttribute("error", "Error. ");
				return "redirect:/allcustomers.html";
			}
		} else {
			
			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setAddress(address);
			customerInfo.setBirth(birth);
			customerInfo.setName(name);
			customerInfo.setCustomerId(customerId);
			customerInfo.setTel(tel);
			customerInfo.setSex(sex);

			boolean succ = customerInfoService.editCustomerInfo(customerInfo);
			if (succ) {
				redirectAttributes.addFlashAttribute("succ", "Updated. ");
				return "redirect:/allcustomers.html";
			} else {
				redirectAttributes.addFlashAttribute("error", "Error. ");
				return "redirect:/allcustomers.html";
			}
		}

	}

	@RequestMapping("customer_add.html")
	public ModelAndView customerInfoAdd() {
		ModelAndView modelAndView = new ModelAndView("admin_customer_add");
		return modelAndView;

	}

	@RequestMapping("customer_repassword.html")
	public ModelAndView customerRePassword() {
		ModelAndView modelAndView = new ModelAndView("customer_repassword");
		return modelAndView;
	}

	@RequestMapping("customer_repassword_do.html")
	public String customerRePasswordDo(HttpServletRequest request, String oldPassword, String newPassword,
			String reNewPassword, RedirectAttributes redirectAttributes) {
		CustomerCard customerCard = (CustomerCard) request.getSession().getAttribute("customercard");
		int customerId = customerCard.getCustomerId();
		String password = customerCard.getPassword();

		if (newPassword.equals(reNewPassword)) {
			if (password.equals(oldPassword)) {
				boolean succ = customerCardService.updatePassword(customerId, newPassword);
				if (succ) {
					CustomerCard customerCardNew = loginService.findCustomerCardByUserId(customerId);
					request.getSession().setAttribute("customercard", customerCardNew);
					redirectAttributes.addFlashAttribute("succ", "Succeed. ");
					return "redirect:/customer_repassword.html";
				} else {
					redirectAttributes.addFlashAttribute("succ", "Error. ");
					return "redirect:/customer_repassword.html";
				}

			} else {
				redirectAttributes.addFlashAttribute("error", "Wrong password. ");
				return "redirect:/customer_repassword.html";
			}
		} else {
			redirectAttributes.addFlashAttribute("error", "2 input are different. ");
			return "redirect:/customer_repassword.html";
		}

	}

	@RequestMapping("customer_add_do.html")
	public String customerInfoAddDo(String name, String sex, String birth, String address, String tel, int customerId,
			RedirectAttributes redirectAttributes) {
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setAddress(address);
		customerInfo.setBirth(birth);
		customerInfo.setName(name);
		customerInfo.setCustomerId(customerId);
		customerInfo.setTel(tel);
		customerInfo.setSex(sex);
		boolean succ = customerInfoService.addCustomerInfo(customerInfo);
		boolean succc = customerCardService.addCustomerCard(customerInfo);
		if (succ && succc) {
			redirectAttributes.addFlashAttribute("succ", "Success. ");
			return "redirect:/allcustomers.html";
		} else {
			redirectAttributes.addFlashAttribute("succ", "Error.");
			return "redirect:/allcustomers.html";
		}
	}

	@RequestMapping("customer_info_edit.html")
	public ModelAndView customerInfoEditCustomer(HttpServletRequest request) {
		CustomerCard customerCard = (CustomerCard) request.getSession().getAttribute("customercard");
		CustomerInfo customerInfo = customerInfoService.getCustomerInfo(customerCard.getCustomerId());
		ModelAndView modelAndView = new ModelAndView("customer_info_edit");
		modelAndView.addObject("customerinfo", customerInfo);
		return modelAndView;

	}

	@RequestMapping("customer_edit_do_r.html")
	public String customerInfoEditDoCustomer(HttpServletRequest request, String name, String sex, String birth,
			String address, String tel, RedirectAttributes redirectAttributes) {
		CustomerCard customerCard = (CustomerCard) request.getSession().getAttribute("customercard");
		if (!customerCard.getName().equals(name)) {
			boolean succo = customerCardService.updateName(customerCard.getCustomerId(), name);
			

			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setAddress(address);
			customerInfo.setBirth(birth);
			customerInfo.setName(name);
			customerInfo.setCustomerId(customerCard.getCustomerId());
			customerInfo.setTel(tel);
			customerInfo.setSex(sex);

			boolean succ = customerInfoService.editCustomerInfo(customerInfo);
			if (succ && succo) {
				CustomerCard customerCardNew = loginService.findCustomerCardByUserId(customerCard.getCustomerId());
				request.getSession().setAttribute("customercard", customerCardNew);
				redirectAttributes.addFlashAttribute("succ", "Succeed. ");
				return "redirect:/customer_info.html";
			} else {
				redirectAttributes.addFlashAttribute("error", "Error. ");
				return "redirect:/customer_info.html";
			}

		} else {
			
			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setAddress(address);
			customerInfo.setBirth(birth);
			customerInfo.setName(name);
			customerInfo.setCustomerId(customerCard.getCustomerId());
			customerInfo.setTel(tel);
			customerInfo.setSex(sex);

			boolean succ = customerInfoService.editCustomerInfo(customerInfo);
			if (succ) {
				CustomerCard customerCardNew = loginService.findCustomerCardByUserId(customerCard.getCustomerId());
				request.getSession().setAttribute("customercard", customerCardNew);
				redirectAttributes.addFlashAttribute("succ", "Succeed. ");
				return "redirect:/customer_info.html";
			} else {
				redirectAttributes.addFlashAttribute("error", "Error. ");
				return "redirect:/customer_info.html";
			}
		}

	}
}
