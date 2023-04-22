package com.example.student.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class SD_UserDetails {
	
		public SD_UserDetails() { }
		@Id
		@Column(name="phone_no")
		private int phone_no;
		
		@Column(name="first_name")
		private String first_name;
		
		@Column(name="last_name")
		private String last_name;
		
		@Column(name="email")
		private String email;
		
		@Column(name="address")
		private String address;
		
		@Column(name="gender")
		private String gender;
		
		@Column(name="DOB")
		private Date DOB;
		
		@Column(name="skills")
		private String skills;
		
		@Column(name="country")
		private String country;
		
		@Column(name="city")
		private String city;

		public int getPhone_no() {
			return phone_no;
		}

		public void setPhone_no(int phone_no) {
			this.phone_no = phone_no;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Date getDOB() {
			return DOB;
		}

		public void setDOB(Date dOB) {
			DOB = dOB;
		}

		public String getSkills() {
			return skills;
		}

		public void setSkills(String skills) {
			this.skills = skills;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		} 
		
}
