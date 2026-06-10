package com.syriahandwerker.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "service_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 100)
	private String name;
	
	@Column(length = 1000)
	private String description;
}
