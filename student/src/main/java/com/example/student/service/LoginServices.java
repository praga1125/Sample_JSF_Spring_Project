package com.example.student.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.Bean.SD_Details;
import com.example.student.DAO.loginDAO;
import com.example.student.RequestDTO.LoginRequestDTO;
import com.example.student.ResponseDTO.LoginResponseDTO;

@Service
public class LoginServices implements LoginService{
	
	@Autowired
	loginDAO loginDAO;
	
	public LoginResponseDTO validateInsert(LoginRequestDTO loginRequestDTO, HttpServletRequest request) {
		LoginResponseDTO  responseobj=new LoginResponseDTO();
		if(loginRequestDTO.getPhone() >= 0) {
			SD_Details tokenLog = new SD_Details();
			tokenLog.setUsername(loginRequestDTO.getUsername());
			tokenLog.setPassword(loginRequestDTO.getPassword());
			tokenLog.setPhone(loginRequestDTO.getPhone());
			loginDAO.insertLog(tokenLog);
			responseobj.setUsername(loginRequestDTO.getUsername());
			responseobj.setPassword(loginRequestDTO.getPassword());
			responseobj.setPhone(loginRequestDTO.getPhone());
		} else {
			responseobj.setError("Invalid User");
		}
		return responseobj;
	}
	
	public LoginResponseDTO search(LoginRequestDTO loginRequestDTO, HttpServletRequest request) {
		LoginResponseDTO  responseobj=new LoginResponseDTO();
		if(loginRequestDTO.getPhone() >= 0) {
			SD_Details tokenLog = new SD_Details();
			tokenLog.setPhone(loginRequestDTO.getPhone());
			tokenLog = loginDAO.Search(tokenLog);
			responseobj.setUsername(tokenLog.getUsername());
			responseobj.setPassword(tokenLog.getPassword());
			responseobj.setPhone(tokenLog.getPhone());
		} else {
			responseobj.setError("Invalid User");
		}
		return responseobj;
	}
	
	public List<SD_Details> getAll() {
		return loginDAO.getAll();
	}
	
	public LoginResponseDTO searchByName(LoginRequestDTO loginRequestDTO, HttpServletRequest request) {
		LoginResponseDTO  responseobj=new LoginResponseDTO();
		if(loginRequestDTO.getUsername() != null) {
			SD_Details tokenLog = new SD_Details();
			tokenLog.setUsername(loginRequestDTO.getUsername());
			tokenLog = loginDAO.SearchByName(tokenLog);
			responseobj.setUsername(tokenLog.getUsername());
			responseobj.setPassword(tokenLog.getPassword());
			responseobj.setPhone(tokenLog.getPhone());
		} else {
			responseobj.setError("Invalid User");
		}
		return responseobj;
	}
	
}
