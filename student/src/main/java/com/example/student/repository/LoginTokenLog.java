package com.example.student.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.student.Bean.SD_Details;

public interface LoginTokenLog extends CrudRepository<SD_Details,Integer> {

	SD_Details findByUsername(String username);

}

