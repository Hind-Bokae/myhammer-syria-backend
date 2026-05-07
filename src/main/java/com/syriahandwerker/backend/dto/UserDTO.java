package com.syriahandwerker.backend.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	private Long id;
	private String email;
	private String fullName;
	private String phoneNumber;
	private String city;
	private String role;
	private Double latitude;
	private Double longitude;
}
