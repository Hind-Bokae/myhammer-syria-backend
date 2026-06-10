package com.syriahandwerker.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceCategoryDTO {
	private Long id;
	private String name;
	private String description;
}
