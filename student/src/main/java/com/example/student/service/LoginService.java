package com.example.student.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.student.Bean.SD_Details;
import com.example.student.RequestDTO.LoginRequestDTO;
import com.example.student.ResponseDTO.LoginResponseDTO;

public interface LoginService {

	LoginResponseDTO validateInsert(LoginRequestDTO loginRequestDTO, HttpServletRequest request);	
	LoginResponseDTO search(LoginRequestDTO loginRequestDTO, HttpServletRequest request);
	List<SD_Details> getAll();
	LoginResponseDTO searchByName(LoginRequestDTO loginRequestDTO, HttpServletRequest request);
	
}
