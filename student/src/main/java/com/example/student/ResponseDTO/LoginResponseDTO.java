package com.example.student.ResponseDTO;

public class LoginResponseDTO {
	
		private String username;
		private String password;
		private int phone;
		private String error;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getPhone() {
			return phone;
		}
		public void setPhone(int phone) {
			this.phone = phone;
		}
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}

}
