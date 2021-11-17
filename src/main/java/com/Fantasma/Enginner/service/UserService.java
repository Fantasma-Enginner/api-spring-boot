package com.Fantasma.Enginner.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Fantasma.Enginner.entity.User;

public interface UserService {
	
	//devuelve un itareble obgeto usuario todos los usuarios
	public Iterable<User> findAll();
	
	//implementamos la paginacion
	public Page<User> findAll(Pageable pageable);
	
	//implementamos optional para buscar usuario por id
	public Optional<User> findById(Long id);
	
	//guarda usuario
	public User save(User user);
	
	//eliiminar usuario
	
	public void deleteById(Long id);
}
