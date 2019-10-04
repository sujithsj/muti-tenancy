package com.geninvo.apogi.tenant.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.geninvo.apogi.tenant.model.User;
import com.geninvo.apogi.tenant.repository.UserRepository; 

/**
 * Rest Controller to handle all requests to the /auth end point
 * 
 * @author Sujith Kumar Sirisanagandla
 * @since ver 1.0 (OCT 2019)
 * @version 1.0
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private static final Logger LOG = LoggerFactory
            .getLogger(AuthController.class);
	@Autowired
    private UserRepository userRepository;
	
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) {
		
		return null;	
	}
}
