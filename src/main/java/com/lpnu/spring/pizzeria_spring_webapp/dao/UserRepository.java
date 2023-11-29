package com.lpnu.spring.pizzeria_spring_webapp.dao;

import com.lpnu.spring.pizzeria_spring_webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
