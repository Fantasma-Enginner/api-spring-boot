package com.Fantasma.Enginner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fantasma.Enginner.entity.User;

@Repository
//se import User de entity
public interface UserRepository extends JpaRepository<User, Long> {

}
