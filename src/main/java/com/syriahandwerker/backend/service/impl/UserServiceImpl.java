package com.syriahandwerker.backend.service.impl;

import com.syriahandwerker.backend.dto.UserDTO;
import com.syriahandwerker.backend.exception.ResourceNotFoundException;
import com.syriahandwerker.backend.exception.UserAlreadyExistsException;
import com.syriahandwerker.backend.mapper.UserMapper;
import com.syriahandwerker.backend.model.User;
import com.syriahandwerker.backend.repository.UserRepository;
import com.syriahandwerker.backend.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImpl  implements UserService {
	private final UserRepository userRepository;
	private final UserMapper     userMapper;
	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> findAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(userMapper::toDTO)
				.collect(Collectors.toList());
	}
	@Override
	@Transactional(readOnly = true)
	public UserDTO findUserById(Long id) {
		return userRepository.findById(id)
				.map(userMapper::toDTO)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}
	@Override
	@Transactional
	public UserDTO registerUser(UserDTO userDTO) {
		if (userRepository.existsByEmail(userDTO.getEmail())) {
			throw new UserAlreadyExistsException("Email: " + userDTO.getEmail()+ " is already in use");
		}
		User user = userMapper.toEntity(userDTO);
		User savedUser = userRepository.save(user);
		return userMapper.toDTO(savedUser);
	}
	@Override
	@Transactional
	public UserDTO updateUser(Long id, UserDTO userDTO) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User not found with id: " + id);
		}
		userDTO.setId(id);
		User user = userMapper.toEntity(userDTO);
		User updatedUser = userRepository.save(user);
		return userMapper.toDTO(updatedUser);
	}
	@Override
	@Transactional
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User not found with id: " + id);
		}
		userRepository.deleteById(id);
	}
	@Override
	@Transactional
	public UserDTO saveUser(UserDTO userDTO) {
		User user = userMapper.toEntity(userDTO);
		User savedUser = userRepository.save(user);
		return userMapper.toDTO(savedUser);
	}
	
	
}
