package com.example.student.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student.Bean.SD_UserDetails;
import com.example.student.Constants.KeyConstants;
import com.example.student.RequestDTO.UserRequestDTO;
import com.example.student.ResponseDTO.UserResponseDTO;
import com.example.student.service.UserServices;

@RestController
@RequestMapping(value = KeyConstants.userBase)
public class UserController {
	
	private final UserServices userServices;
	
	 public UserController(UserServices userServices) {
	        this.userServices = userServices;
	    }
	 
	 @PostMapping(value= KeyConstants.CREATE)
	 public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userRequestDTO, HttpServletRequest request){
		 UserResponseDTO userResponseDTO = userServices.createUser(userRequestDTO, request);
		 return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	 }
	 
	 @GetMapping(value=KeyConstants.SEARCH)
	 	public 	ResponseEntity<UserResponseDTO> search(@PathVariable(value="id") int phone_no){
		 UserResponseDTO userResponseDTO = userServices.searchUser(phone_no);
		 return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	 }
	 
	 @PutMapping(value=KeyConstants.UPDATE)
	 	public ResponseEntity<UserResponseDTO> updateUser(@PathVariable int id, @RequestBody Map<String, Object> updates){
		 UserResponseDTO userResponseDTO = userServices.updateUser(id, updates);
		 return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	 }
	 
	 @DeleteMapping(value=KeyConstants.DELETE)
	 	public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable(value="id") int phone){
		 UserResponseDTO userResponseDTO = userServices.deleteUser(phone);
		 return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	 }
	 
	 @GetMapping(value=KeyConstants.GETALL)
	 	public List<SD_UserDetails> getAllUser(){
		 List<SD_UserDetails> userResponseDTO = userServices.getAllUser();
		 return userResponseDTO;
	 }
}
