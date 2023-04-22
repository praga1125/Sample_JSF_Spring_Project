package com.example.student.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.student.Bean.SD_UserDetails;

public interface UserTokenLog extends CrudRepository<SD_UserDetails,Integer> {

}
