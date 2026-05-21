package com.syriahandwerker.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		Contact contact = new Contact()
				.name("Hind Development Team")
				.email("support@syriahandwerker.com")
				.url("https://www.syriahandwerker.com");
		License apiLicense = new License()
				.name("Commercial License")
				.url("https://opensource.org/trms");
		Info apiInfo = new Info()
				.title("MyHammer Syria - Service Marketplace API")
				.version("1.0.0")
				.description("Official API documentation for MyHammer Syria, the leading service marketplace connecting customers with skilled professionals across various trades in Syria.")
				.contact(contact)
				.license(apiLicense);
		return new OpenAPI().info(apiInfo);
	}
}
