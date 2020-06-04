package com.car.service;

import com.car.dao.AdminDao;
import com.car.dao.CustomerCardDao;
import com.car.dao.CustomerInfoDao;
import com.car.entity.CustomerCard;
import com.car.entity.CustomerInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private CustomerCardDao customerCardDao;
	private CustomerInfoDao customerInfoDao;
	private AdminDao adminDao;

	@Autowired
	public void setCustomerCardDao(CustomerCardDao customerCardDao) {
		this.customerCardDao = customerCardDao;
	}

	@Autowired
	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public boolean hasMatchCustomer(int customerId, String password) {
		return customerCardDao.getMatchCount(customerId, password) > 0;
	}

	public CustomerCard findCustomerCardByUserId(int customerId) {
		return customerCardDao.findCustomerByCustomerId(customerId);
	}

	public CustomerInfo findCustomerInfoByCustomerId(int customerId) {
		return customerInfoDao.findCustomerInfoByCustomerId(customerId);
	}

	public boolean hasMatchAdmin(int adminId, String password) {
		return adminDao.getMatchCount(adminId, password) == 1;
	}

	public boolean adminRePassword(int adminId, String newPassword) {
		return adminDao.rePassword(adminId, newPassword) > 0;
	}

	public String getAdminPassword(int id) {
		return adminDao.getPassword(id);
	}

}
