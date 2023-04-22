package com.example.student.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.student.Bean.SD_Details;
import com.example.student.Constants.KeyConstants;
import com.example.student.RequestDTO.*;
import com.example.student.ResponseDTO.*;
import com.example.student.service.*;

@RestController
@RequestMapping(value = KeyConstants.loginBase)
public class LoginController {
	
	private final LoginService loginServices;
	
	 public LoginController(LoginServices loginServices) {
	        this.loginServices = loginServices;
	    }
	
	@PostMapping(value= KeyConstants.CREATE)
	public ResponseEntity<LoginResponseDTO> authenticateInsert(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletRequest request){
			LoginResponseDTO loginResponseDTO = loginServices.validateInsert(loginRequestDTO, request);
		return  new ResponseEntity<LoginResponseDTO>(loginResponseDTO, HttpStatus.OK);
	}
	
	@PostMapping(value=KeyConstants.SEARCH1)
	public ResponseEntity<LoginResponseDTO> search(@RequestBody LoginRequestDTO loginRequestDTO,HttpServletRequest request){
		 LoginResponseDTO loginResponseDTO = loginServices.search(loginRequestDTO, request);
		return  new ResponseEntity<LoginResponseDTO>(loginResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping(value=KeyConstants.GETALL)
	public List<SD_Details> getAll(){
		List<SD_Details> loginResponseDTO = loginServices.getAll();
		return loginResponseDTO;
	}
	
	@PostMapping(value=KeyConstants.SEARCHBYNAME)
		public ResponseEntity<LoginResponseDTO> searchByName(@RequestBody LoginRequestDTO loginRequestDTO,HttpServletRequest request){
			LoginResponseDTO loginResponseDTO = loginServices.searchByName(loginRequestDTO, request);
			return  new ResponseEntity<LoginResponseDTO>(loginResponseDTO, HttpStatus.OK);
	}
	
}
