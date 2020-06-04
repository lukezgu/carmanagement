package com.car.service;

import com.car.dao.CustomerInfoDao;
import com.car.entity.CustomerInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerInfoService {

	private CustomerInfoDao customerInfoDao;

	@Autowired
	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public ArrayList<CustomerInfo> customerInfos() {
		return customerInfoDao.getAllCustomerInfo();
	}

	public boolean deleteCustomerInfo(int customerId) {
		return customerInfoDao.deleteCustomerInfo(customerId) > 0;
	}

	public CustomerInfo getCustomerInfo(int customerId) {
		return customerInfoDao.findCustomerInfoByCustomerId(customerId);
	}

	public boolean editCustomerInfo(CustomerInfo customerInfo) {
		return customerInfoDao.editCustomerInfo(customerInfo) > 0;
	}

	public boolean addCustomerInfo(CustomerInfo customerInfo) {
		return customerInfoDao.addCustomerInfo(customerInfo) > 0;
	}
}
