package com.example.student.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.example.student.RequestDTO.UserRequestDTO;
import com.example.student.ResponseDTO.UserResponseDTO;

public interface UserService {
	UserResponseDTO createUser(UserRequestDTO userRequestDTO, HttpServletRequest request);
	UserResponseDTO searchUser(int phone);
	UserResponseDTO updateUser(int id, Map<String, Object> updates);
	UserResponseDTO deleteUser(int phone);
}
