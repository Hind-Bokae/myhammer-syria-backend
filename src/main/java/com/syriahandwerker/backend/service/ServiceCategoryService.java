package com.syriahandwerker.backend.service;

import com.syriahandwerker.backend.dto.ServiceCategoryDTO;
import com.syriahandwerker.backend.model.ServiceCategory;
import com.syriahandwerker.backend.repository.ServiceCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service@RequiredArgsConstructor
public class ServiceCategoryService {
	private final ServiceCategoryRepository serviceCategoryRepository;
	public List<ServiceCategoryDTO> getAllServiceCategories() {
		return serviceCategoryRepository.findAll().stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	public ServiceCategoryDTO createServiceCategory(ServiceCategoryDTO serviceCategoryDTO) {
		if (serviceCategoryDTO.getName() == null || serviceCategoryDTO.getName().isEmpty()) {
			throw new IllegalArgumentException("Service category name cannot be empty");
		}
		ServiceCategory serviceCategory = ServiceCategory.builder()
				.name(serviceCategoryDTO.getName())
				.description(serviceCategoryDTO.getDescription())
				.build();
		return convertToDTO(serviceCategoryRepository.save(serviceCategory));
	}
	private ServiceCategoryDTO convertToDTO(ServiceCategory serviceCategory) {
		return ServiceCategoryDTO.builder()
				.id(serviceCategory.getId())
				.name(serviceCategory.getName())
				.description(serviceCategory.getDescription())
				.build();
	}
}
