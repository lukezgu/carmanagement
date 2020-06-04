package com.car.service;

import com.car.dao.RentDao;
import com.car.entity.Rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RentService {
	private RentDao rentDao;

	@Autowired
	public void setRentDao(RentDao rentDao) {
		this.rentDao = rentDao;
	}

	public boolean carReturn(String carId) {
		return rentDao.carReturnOne(carId) > 0 && rentDao.carReturnTwo(carId) > 0;
	}

	public boolean carRent(String carId, int customerId) {
		return rentDao.carRentOne(carId, customerId) > 0 && rentDao.carRentTwo(carId) > 0;
	}

	public ArrayList<Rent> rentList() {
		return rentDao.rentList();
	}

	public ArrayList<Rent> myRentList(int customerId) {
		return rentDao.myRentList(customerId);
	}

}
