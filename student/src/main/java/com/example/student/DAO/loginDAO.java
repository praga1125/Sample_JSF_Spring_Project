package com.example.student.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.student.Bean.SD_Details;
import com.example.student.repository.LoginTokenLog;

@Repository
public class loginDAO {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	private LoginTokenLog tokenlogrepository;
	
	private List<SD_Details> details = new ArrayList<SD_Details>();
	
	public void insertLog(SD_Details tokenlog) {
		tokenlogrepository.save(tokenlog);
	}
	
	public SD_Details Search(SD_Details tokenlog){
		return tokenlogrepository.findById(tokenlog.getPhone()).get();
	}
	
	public List<SD_Details> getAll() {
		tokenlogrepository.findAll().forEach((details::add));
		return details;
	}

	public SD_Details SearchByName(SD_Details tokenlog) {
		return tokenlogrepository.findByUsername(tokenlog.getUsername());
	}
}
