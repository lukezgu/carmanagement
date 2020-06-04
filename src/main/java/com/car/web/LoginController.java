package com.car.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.entity.Admin;
import com.car.entity.CustomerCard;
import com.car.service.LoginService;

@Controller
public class LoginController {

	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value = { "/", "/login.html" })
	public String toLogin(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	@RequestMapping("/logout.html")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login.html";
	}

	@RequestMapping(value = "/api/loginCheck", method = RequestMethod.POST)
	public @ResponseBody Object loginCheck(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		boolean isCustomer = loginService.hasMatchCustomer(id, password);
		boolean isAdmin = loginService.hasMatchAdmin(id, password);
		HashMap<String, String> res = new HashMap<String, String>();
		if (isAdmin == false && isCustomer == false) {
			res.put("stateCode", "0");
			res.put("msg", "Incorrect ID or password. ");
		} else if (isAdmin) {
			Admin admin = new Admin();
			admin.setAdminId(id);
			admin.setPassword(password);
			request.getSession().setAttribute("admin", admin);
			res.put("stateCode", "1");
			res.put("msg", "Admin logged in. ");
		} else {
			CustomerCard customerCard = loginService.findCustomerCardByUserId(id);
			request.getSession().setAttribute("customercard", customerCard);
			res.put("stateCode", "2");
			res.put("msg", "Customer logged in. ");
		}
		return res;
	};

	@RequestMapping("/admin_main.html")
	public ModelAndView toAdminMain(HttpServletResponse response) {

		return new ModelAndView("admin_main");
	}

	@RequestMapping("/customer_main.html")
	public ModelAndView toCustomerMain(HttpServletResponse response) {

		return new ModelAndView("customer_main");
	}

	@RequestMapping("/admin_repassword.html")
	public ModelAndView reAdminPassword() {

		return new ModelAndView("admin_repassword");
	}

	@RequestMapping("/admin_repassword_do")
	public String reAdminPasswordDo(HttpServletRequest request, String oldPassword, String newPassword,
			String reNewPassword, RedirectAttributes redirectAttributes) {

		Admin admin = (Admin) request.getSession().getAttribute("admin");
		int id = admin.getAdminId();
		String password = loginService.getAdminPassword(id);

		if (password.equals(oldPassword)) {
			boolean succ = loginService.adminRePassword(id, newPassword);
			if (succ) {

				redirectAttributes.addFlashAttribute("succ", "Succeed. ");
				return "redirect:/admin_repassword.html";
			} else {
				redirectAttributes.addFlashAttribute("error", "Error. ");
				return "redirect:/admin_repassword.html";
			}
		} else {
			redirectAttributes.addFlashAttribute("error", "Wrong password. ");
			return "redirect:/admin_repassword.html";
		}
	};

	@RequestMapping("*")
	public String notFind() {
		return "404";
	}

}