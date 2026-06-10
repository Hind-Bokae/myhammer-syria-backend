package com.syriahandwerker.backend.controller;

import com.syriahandwerker.backend.dto.ServiceCategoryDTO;
import com.syriahandwerker.backend.service.ServiceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-categories")
public class serviceCategoryController {
	private final ServiceCategoryService serviceCategoryService;
	@GetMapping
	public ResponseEntity<List<ServiceCategoryDTO>> getAllServiceCategories() {
		return ResponseEntity.ok(serviceCategoryService.getAllServiceCategories());
	}
	@PostMapping
	public ResponseEntity<ServiceCategoryDTO> createServiceCategory(@RequestBody  ServiceCategoryDTO serviceCategoryDTO) {
		return new  ResponseEntity<>(serviceCategoryService.createServiceCategory(serviceCategoryDTO), HttpStatus.CREATED);
	}
}
