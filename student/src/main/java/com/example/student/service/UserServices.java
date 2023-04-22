package com.example.student.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.Bean.SD_UserDetails;
import com.example.student.DAO.UserDAO;
import com.example.student.RequestDTO.UserRequestDTO;
import com.example.student.ResponseDTO.UserResponseDTO;
import com.example.student.utils.DateUtils;

@Service
public class UserServices implements UserService{
	
	@Autowired
	UserDAO userDAO;	
	
	public UserResponseDTO createUser(UserRequestDTO userRequestDTO, HttpServletRequest request) {
		SD_UserDetails tokenLog = new SD_UserDetails();
		UserResponseDTO  responseobj=new UserResponseDTO();
		if(userRequestDTO.getFirst_name() != null && userRequestDTO.getLast_name() != null && userRequestDTO.getPhone_no() >= 0 && userRequestDTO.getAddress() != null && userRequestDTO.getEmail() != null && userRequestDTO.getCity() != null && userRequestDTO.getDob() != null && userRequestDTO.getCountry() != null && userRequestDTO.getGender() != null && userRequestDTO.getSkills() != null) {
			tokenLog.setFirst_name(userRequestDTO.getFirst_name());
			tokenLog.setLast_name(userRequestDTO.getLast_name());
			tokenLog.setPhone_no(userRequestDTO.getPhone_no());
			tokenLog.setEmail(userRequestDTO.getEmail());
			tokenLog.setAddress(userRequestDTO.getAddress());
			tokenLog.setGender(userRequestDTO.getGender());
			tokenLog.setDOB(DateUtils.convertDate(userRequestDTO.getDob()));
			tokenLog.setSkills(userRequestDTO.getSkills());
			tokenLog.setCountry(userRequestDTO.getCountry());
			tokenLog.setCity(userRequestDTO.getCity());
			userDAO.insertLog(tokenLog);
			responseobj.setFirst_name(userRequestDTO.getFirst_name());
			responseobj.setLast_name(userRequestDTO.getLast_name());
			responseobj.setPhone_no(userRequestDTO.getPhone_no());
			responseobj.setEmail(userRequestDTO.getEmail());
			responseobj.setAddress(userRequestDTO.getAddress());
			responseobj.setGender(userRequestDTO.getGender());
			responseobj.setDob(DateUtils.convertDate(userRequestDTO.getDob()));
			responseobj.setSkills(userRequestDTO.getSkills());
			responseobj.setCountry(userRequestDTO.getCountry());
			responseobj.setCity(userRequestDTO.getCity());
			
		} else {
			responseobj.setError("Invalid User");
		}
		return responseobj;
	}
	
	public UserResponseDTO searchUser(int phone) {
		SD_UserDetails tokenLog = new SD_UserDetails();
		UserResponseDTO  responseobj=new UserResponseDTO();
		if(phone >= 0) {
			tokenLog = userDAO.searchLog(phone);
			responseobj.setFirst_name(tokenLog.getFirst_name());
			responseobj.setLast_name(tokenLog.getLast_name());
			responseobj.setPhone_no(tokenLog.getPhone_no());
			responseobj.setEmail(tokenLog.getEmail());
			responseobj.setAddress(tokenLog.getAddress());
			responseobj.setGender(tokenLog.getGender());
			responseobj.setDob(tokenLog.getDOB());
			responseobj.setSkills(tokenLog.getSkills());
			responseobj.setCountry(tokenLog.getCountry());
			responseobj.setCity(tokenLog.getCity());
		} else {
			responseobj.setError("Invalid User");
		}
		return responseobj; 
	}

	
	public UserResponseDTO updateUser(int id, Map<String, Object> updates) {
		UserResponseDTO  responseobj=new UserResponseDTO();
			if(id >= 0) {
			SD_UserDetails tokenLog = userDAO.searchLog(id);
			updates.forEach((key, value) -> {
				switch(key) {
					case "first_name":
						tokenLog.setFirst_name(value.toString());
						break;
					case "last_name":
						tokenLog.setLast_name(value.toString());
						break;
					case "phone_no":
						tokenLog.setPhone_no((int) value);
						break;
					case "email":
						tokenLog.setEmail(value.toString());
						break;
					case "address":
						tokenLog.setAddress(value.toString());
						break;
					case "gender":
						tokenLog.setGender(value.toString());
						break;
					case "dob":
						tokenLog.setDOB(DateUtils.convertDate(value.toString()));
						break;
					case "skills":
						tokenLog.setSkills(value.toString());
						break;
					case "country":
						tokenLog.setCountry(value.toString());
						break;
					case "city":
						tokenLog.setCity(value.toString());
						break;
				}
			});
			userDAO.updateLog(tokenLog);
			responseobj.setFirst_name(tokenLog.getFirst_name());
			responseobj.setLast_name(tokenLog.getLast_name());
			responseobj.setPhone_no(tokenLog.getPhone_no());
			responseobj.setEmail(tokenLog.getEmail());
			responseobj.setAddress(tokenLog.getAddress());
			responseobj.setGender(tokenLog.getGender());
			responseobj.setDob(tokenLog.getDOB());
			responseobj.setSkills(tokenLog.getSkills());
			responseobj.setCountry(tokenLog.getCountry());
			responseobj.setCity(tokenLog.getCity());
			} else {
					responseobj.setError("Invalid User");
				}
				return responseobj; 
	}

	public UserResponseDTO deleteUser(int phone) {
		UserResponseDTO  responseobj=new UserResponseDTO();
		SD_UserDetails tokenLog = new SD_UserDetails();
		if(phone >= 0) {
			responseobj.setMsg("user Deleted");
			tokenLog.setPhone_no(phone);
			userDAO.deleteLog(tokenLog);
		} else {
			responseobj.setError("Invalid User");
		}
		return responseobj; 
	}

	public List<SD_UserDetails> getAllUser() {
		return userDAO.getAllUser();
	} 
	
	
}
