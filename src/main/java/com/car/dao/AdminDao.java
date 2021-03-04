package com.car.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static final String MATCH_ADMIN_SQL="SELECT COUNT(*) FROM admin where adminId = ? and password = ? ";
    private static final String RE_PASSWORD_SQL="UPDATE admin set password = ? where adminId = ? ";
    private static final String GET_PASSWD_SQL="SELECT password from admin where adminId = ?";

    public int getMatchCount(int adminId,String password){
        return jdbcTemplate.queryForObject(MATCH_ADMIN_SQL,new Object[]{adminId,password},Integer.class);
    }

    public int rePassword(int adminId,String newPassword){
        return jdbcTemplate.update(RE_PASSWORD_SQL,new Object[]{newPassword,adminId});
    }
    public String getPassword(int id){
        return jdbcTemplate.queryForObject(GET_PASSWD_SQL,new Object[]{id},String.class);
    }

}

//test
