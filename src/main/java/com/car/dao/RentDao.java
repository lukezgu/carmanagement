package com.car.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.car.entity.Rent;

@Repository
public class RentDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final static String CAR_RETURN_SQL_ONE = "DELETE from rent_list WHERE carId = ?";

	private final static String CAR_RETURN_SQL_TWO = "UPDATE car_info SET state = 1 WHERE carId = ? ";

	private final static String CAR_RENT_SQL_ONE = "INSERT INTO rent_list (carId,customerId) VALUES (?, ?)";

	private final static String CAR_RENT_SQL_TWO = "UPDATE car_info SET state = 0 WHERE carId = ? ";

	private final static String RENT_LIST_SQL = "SELECT * FROM rent_list";

	private final static String MY_RENT_LIST_SQL = "SELECT * FROM rent_list WHERE customerId = ? ";

	public int carReturnOne(String carId) {
		return jdbcTemplate.update(CAR_RETURN_SQL_ONE, new Object[] { carId });
	}

	public int carReturnTwo(String carId) {
		return jdbcTemplate.update(CAR_RETURN_SQL_TWO, new Object[] { carId });
	}

	public int carRentOne(String carId, int customerId) {
		return jdbcTemplate.update(CAR_RENT_SQL_ONE, new Object[] { carId, customerId, });
	}

	public int carRentTwo(String carId) {
		return jdbcTemplate.update(CAR_RENT_SQL_TWO, new Object[] { carId });
	}

	public ArrayList<Rent> rentList() {
		final ArrayList<Rent> list = new ArrayList<Rent>();

		jdbcTemplate.query(RENT_LIST_SQL, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					Rent rent = new Rent();
					rent.setCarId(resultSet.getString("carId"));
					rent.setCustomerId(resultSet.getInt("customerId"));
					list.add(rent);
				}
			}
		});
		return list;
	}

	public ArrayList<Rent> myRentList(int customerId) {
		final ArrayList<Rent> list = new ArrayList<Rent>();

		jdbcTemplate.query(MY_RENT_LIST_SQL, new Object[] { customerId }, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					Rent rent = new Rent();
					rent.setCarId(resultSet.getString("carId"));
					rent.setCustomerId(resultSet.getInt("customerId"));
					list.add(rent);
				}
			}
		});
		return list;

	}
}
