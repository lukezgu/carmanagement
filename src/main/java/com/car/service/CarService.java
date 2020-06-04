package com.car.service;

import com.car.dao.CarDao;
import com.car.entity.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
	private CarDao carDao;

	@Autowired
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public ArrayList<Car> getAllCars() {
		return carDao.getAllCars();
	}

	public int deleteCar(String carId) {
		return carDao.deleteCar(carId);
	}

	public boolean addCar(Car car) {
		return carDao.addCar(car) > 0;
	}

	public boolean editCar(Car car) {
		return carDao.editCar(car) > 0;
	}

	public Car getCar(String carId) {
		return carDao.getCar(carId);
	}

}
