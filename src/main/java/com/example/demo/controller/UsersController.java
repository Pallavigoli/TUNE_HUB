package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersController 
{
	@Autowired
	UsersService userv;
	
	@Autowired
	SongsService songserv;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		boolean userstatus = userv.emailExists(user.getEmail());
		if(userstatus == false) {
			userv.addUser(user);
			return "registersuccess";
		}
		else
		{
			return "registerfail";
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email,
			@RequestParam String password, HttpSession session)
	{
		//invoking validateUser() in service
		if(userv.validateUser(email, password) == true)
		{
			session.setAttribute("email", email);
			//checking whether the user is admin or customer
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		else
		{
			return "loginfail";
		}
	}
	
	@GetMapping("exploreSongs")
	public String exploreSongs(HttpSession session) 
	{
		String email=(String) session.getAttribute("email");
		Users user=userv.getUser(email);
		
		System.out.println(user);
		boolean userStatus=user.isPremium();
		
		if(userStatus==true)
		{
			return "customerhome2";
		}
		else {
			return "payment";
		}
	
	}
	
	
}
















