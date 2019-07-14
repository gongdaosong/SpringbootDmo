package com.gds.springbootdemo.dao;

import com.gds.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
}
