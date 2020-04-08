package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Map<String, Object> findOne(int id) {
    String query = "select employee_id, employee_name, age from employee where employee_id = ?";
    Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
    return employee;
  }
}