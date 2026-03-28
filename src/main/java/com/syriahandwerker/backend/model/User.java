package com.syriahandwerker.backend.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String fullName;
	private String password;
	private String phoneNumber;
	private String city;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
}
