package com.example.student.DAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.student.Bean.SD_UserDetails;
import com.example.student.repository.UserTokenLog;

@Repository
public class UserDAO {
		@Autowired
		protected JdbcTemplate jdbcTemplate;

		@Autowired
		private UserTokenLog tokenlogrepository;
		
		private List<SD_UserDetails> details = new ArrayList<SD_UserDetails>();
		
		public void insertLog(SD_UserDetails tokenlog) {
			tokenlogrepository.save(tokenlog);
		}
		public SD_UserDetails searchLog(int tokenlog) {
			return tokenlogrepository.findById(tokenlog).get();
		}	
		public SD_UserDetails updateLog(SD_UserDetails tokenlog) {
			return tokenlogrepository.save(tokenlog);
		}
		public void deleteLog(SD_UserDetails tokenlog) {
			tokenlogrepository.deleteById(tokenlog.getPhone_no());
		}
		public List<SD_UserDetails> getAllUser(){
			details.clear();
			tokenlogrepository.findAll().forEach((details::add));
			return details;
		}
		
}
