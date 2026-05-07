package com.syriahandwerker.backend.service;

import com.syriahandwerker.backend.dto.UserDTO;

import java.util.List;

public interface UserService {
	List<UserDTO> findAllUsers();
	UserDTO findUserById(Long id);
	UserDTO updateUser(Long id, UserDTO userDTO);
	UserDTO saveUser(UserDTO userDTO);
	void deleteUser(Long id);
	UserDTO registerUser(UserDTO userDTO);
}
