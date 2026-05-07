package com.syriahandwerker.backend.controller;

import com.syriahandwerker.backend.dto.UserDTO;
import com.syriahandwerker.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return ResponseEntity.ok(userService.findAllUsers());
	}
	@GetMapping ("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findUserById(id));
	}
	@PostMapping
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.saveUser(userDTO));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
