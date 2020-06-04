package com.car.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.car.entity.CustomerInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class CustomerInfoDao {

	private JdbcTemplate jdbcTemplate;

	private final static String ADD_CUSTOMER_INFO_SQL = "INSERT INTO customer_info VALUES(?,?,?,?,?,?)";
	private final static String DELETE_CUSTOMER_INFO_SQL = "DELETE FROM customer_info where customerId = ? ";
	private final static String GET_CUSTOMER_INFO_SQL = "SELECT * FROM customer_info where customerId = ? ";
	private final static String UPDATE_CUSTOMER_INFO = "UPDATE customer_info set name = ? ,sex = ? ,birth = ? ,address = ? ,tel = ? where customerId = ? ";
	private final static String ALL_CUSTOMER_INFO_SQL = "SELECT * FROM customer_info";

	public ArrayList<CustomerInfo> getAllCustomerInfo() {
		final ArrayList<CustomerInfo> customers = new ArrayList<CustomerInfo>();
		jdbcTemplate.query(ALL_CUSTOMER_INFO_SQL, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				resultSet.beforeFirst();
				while (resultSet.next()) {
					CustomerInfo customer = new CustomerInfo();
					customer.setAddress(resultSet.getString("address"));
					customer.setBirth(resultSet.getString("birth"));
					customer.setName(resultSet.getString("name"));
					customer.setCustomerId(resultSet.getInt("customerId"));
					customer.setSex(resultSet.getString("sex"));
					customer.setTel(resultSet.getString("tel"));
					customers.add(customer);
				}
			}
		});
		return customers;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public CustomerInfo findCustomerInfoByCustomerId(int customerId) {
		final CustomerInfo customer = new CustomerInfo();
		jdbcTemplate.query(GET_CUSTOMER_INFO_SQL, new Object[] { customerId }, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				customer.setAddress(resultSet.getString("address"));
				customer.setBirth(resultSet.getString("birth"));
				customer.setName(resultSet.getString("name"));
				customer.setCustomerId(resultSet.getInt("customerId"));
				customer.setSex(resultSet.getString("sex"));
				customer.setTel(resultSet.getString("tel"));
			}
		});
		return customer;
	}

	public int deleteCustomerInfo(int customerId) {
		return jdbcTemplate.update(DELETE_CUSTOMER_INFO_SQL, customerId);
	}

	public int editCustomerInfo(CustomerInfo customer_info) {
		String address = customer_info.getAddress();
		String birth = customer_info.getBirth();
		String name = customer_info.getName();
		int customerId = customer_info.getCustomerId();
		String sex = customer_info.getSex();
		String tel = customer_info.getTel();
		return jdbcTemplate.update(UPDATE_CUSTOMER_INFO, new Object[] { name, sex, birth, address, tel, customerId });
	}

	public int addCustomerInfo(CustomerInfo customer_info) {
		String address = customer_info.getAddress();
		String birth = customer_info.getBirth();
		String name = customer_info.getName();
		String sex = customer_info.getSex();
		String tel = customer_info.getTel();
		int customerId = customer_info.getCustomerId();

		return jdbcTemplate.update(ADD_CUSTOMER_INFO_SQL, new Object[] { customerId, name, sex, birth, address, tel });
	}

}
