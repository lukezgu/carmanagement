package com.car.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.car.entity.Car;

@Repository
public class CarDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final static String ADD_CAR_SQL = "INSERT INTO car_info VALUES(?,?,?,?,?,1)";
	private final static String DELETE_CAR_SQL = "delete from car_info where carId = ?  ";
	private final static String EDIT_CAR_SQL = "update car_info set type= ? ,brand= ? ,introduction= ? ,manufactureDate= ?, state =? where carId = ?";
	private final static String QUERY_ALL_CARS_SQL = "SELECT * FROM car_info ";
	private final static String GET_CAR_SQL = "SELECT * FROM car_info where carId = ? ";
//	private final static String QUERY_CAR_SQL = "SELECT * FROM car_info WHERE car_id like  ?  or name like ?   ";

	public ArrayList<Car> getAllCars() {
		final ArrayList<Car> cars = new ArrayList<Car>();

		jdbcTemplate.query(QUERY_ALL_CARS_SQL, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					Car car = new Car();
					car.setCarId(resultSet.getString("carId"));
					car.setType(resultSet.getString("type"));
					car.setBrand(resultSet.getString("brand"));
					car.setIntroduction(resultSet.getString("introduction"));
					car.setManufactureDate(resultSet.getString("manufactureDate"));
					car.setState(resultSet.getString("state"));
					cars.add(car);
				}
			}
		});
		return cars;

	}

	public int deleteCar(String carId) {

		return jdbcTemplate.update(DELETE_CAR_SQL, carId);
	}

	public int addCar(Car car) {
		String carId = car.getCarId();
		String type = car.getType();
		String brand = car.getBrand();
		String introduction = car.getIntroduction();
		String date = car.getManufactureDate();

		return jdbcTemplate.update(ADD_CAR_SQL, new Object[] { carId, type, brand, introduction, date });
	}

	public Car getCar(String carId) {
		final Car car = new Car();
		jdbcTemplate.query(GET_CAR_SQL, new Object[] { carId }, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				car.setCarId(resultSet.getString("carId"));
				car.setIntroduction(resultSet.getString("introduction"));
				car.setBrand(resultSet.getString("brand"));
				car.setType(resultSet.getString("type"));
				car.setManufactureDate(resultSet.getString("manufactureDate"));
				car.setState(resultSet.getString("state"));

			}

		});
		return car;
	}

	public int editCar(Car car) {
		String carId = car.getCarId();
		String type = car.getType();
		String brand = car.getBrand();
		String introduction = car.getIntroduction();
		String date = car.getManufactureDate();
		String state = car.getState();
		return jdbcTemplate.update(EDIT_CAR_SQL, new Object[] {  type, brand, introduction, date, state, carId});
	}

}
