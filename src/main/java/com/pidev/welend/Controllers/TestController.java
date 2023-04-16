package com.pidev.welend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pidev.welend.entities.Users;
import com.pidev.welend.repos.UsersRepo;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	UsersRepo usersRepo;
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	@GetMapping("/het")
	public String getUsername() {
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    return securityContext.getAuthentication().getName();
	}
	@GetMapping("/hetid")
	public String getiduser() {
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    String username= securityContext.getAuthentication().getName();
		 Users usercon  = usersRepo.findByUsername(username).get();
		 return "id ::::::----------------" + usercon.getEmail()+" ----"+usercon.getUsername()+"------"+usercon.getId();
	}
	@RequestMapping(value="/currentuser",method=RequestMethod.GET)
	public Users getById(@PathVariable Integer id){
		 Users usercon  = usersRepo.findById(id).get();
		 return usercon;
	}
}
