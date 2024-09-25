package com.springBoot.blogapp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springBoot.blogapp.config.AppConstants;
import com.springBoot.blogapp.entities.Role;
import com.springBoot.blogapp.repositories.RoleRepo;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Encoded value "+this.passwordEncoder.encode("1234"));
		
		try {
			
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");
			
			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_USER");
			
				List<Role> roles = List.of(role, role1);
				List<Role> result = this.roleRepo.saveAll(roles);
				
				result.forEach(r -> {
					System.out.println(r.getName());
				});
					
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}
 