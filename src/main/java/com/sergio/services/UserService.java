package com.sergio.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.sergio.models.User;
import com.sergio.repositories.UserRepository;

@Service
public class UserService {
	
private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getUserByEmail( String email ){
		return userRepository.selectUserByEmail(email);
	}
	
	public void registerUser( String firstname, String lastname, String email,  String password ) {
		String encryptPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println( encryptPassword );
		userRepository.insertUser( firstname, lastname, email, encryptPassword);
	}
	
	public boolean validateUser( User currentUser, String password ) {
		return BCrypt.checkpw( password, currentUser.getPassword() );
	}

}