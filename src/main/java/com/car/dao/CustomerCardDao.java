package com.car.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.car.entity.CustomerCard;
import com.car.entity.CustomerInfo;

@Repository
public class CustomerCardDao {

	private JdbcTemplate jdbcTemplate;
	private final static String MATCH_COUNT_SQL = "select count(*) from customer_card where customerId = ? and password = ? ";
	private final static String FIND_CUSTOMER_BY_USERID = "select customerId, name, password, cardState from customer_card where customerId = ? ";
	private final static String RE_PASSWORD_SQL = "UPDATE customer_card set password = ? where customerId = ? ";
	private final static String ADD_CUSTOMERCARD_SQL = "INSERT INTO customer_card (customerId,name) values ( ? , ?)";
	private final static String UPDATE_CUSTOMER_NAME_SQL = "UPDATE customer_card set name = ? where customerId = ?";

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getMatchCount(int customerId, String password) {
		return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[] { customerId, password }, Integer.class);
	}

	public CustomerCard findCustomerByCustomerId(int customerId) {
		final CustomerCard customerCard = new CustomerCard();
		jdbcTemplate.query(FIND_CUSTOMER_BY_USERID, new Object[] { customerId }, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				customerCard.setCustomerId(resultSet.getInt("customerId"));
				customerCard.setPassword(resultSet.getString("password"));
				customerCard.setName(resultSet.getString("name"));
				customerCard.setCardState(resultSet.getString("cardState"));
			}
		});
		return customerCard;
	}

	public int rePassword(int customerId, String newPassword) {
		return jdbcTemplate.update(RE_PASSWORD_SQL, new Object[] { newPassword, customerId });
	}

	public int addCustomerCard(CustomerInfo customerInfo) {

		String name = customerInfo.getName();
		int customerId = customerInfo.getCustomerId();

		return jdbcTemplate.update(ADD_CUSTOMERCARD_SQL, new Object[] { customerId, name });
	}

	public int updateName(int customerId, String name) {
		return jdbcTemplate.update(UPDATE_CUSTOMER_NAME_SQL, new Object[] { name, customerId, });
	}
}
