package com.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.CustomerCardDao;
import com.car.entity.CustomerInfo;

@Service
public class CustomerCardService {
	private CustomerCardDao customerCardDao;

	@Autowired
	public void setCustomerCardDao(CustomerCardDao customerCardDao) {
		this.customerCardDao = customerCardDao;
	}

	public boolean addCustomerCard(CustomerInfo customerInfo) {
		return customerCardDao.addCustomerCard(customerInfo) > 0;
	}

	public boolean updatePassword(int customerId, String password) {
		return customerCardDao.rePassword(customerId, password) > 0;
	}

	public boolean updateName(int customerId, String name) {
		return customerCardDao.updateName(customerId, name) > 0;
	}

}
