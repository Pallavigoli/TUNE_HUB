package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation
implements UsersService
{
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) 
	{
		repo.save(user);
		return "user is created and saved";
	}

	@Override
	public boolean emailExists(String email) {

		if(repo.findByEmail(email) == null) 
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {

		Users user = repo.findByEmail(email);
		if(user!=null && user.getEmail()!=null && user.getEmail().equals(email))
		{
			String db_password = user.getPassword();
			if(db_password.equals(password))
			{
				return true;
			}
			return false;
		}
		else
		{
			return false;
		}
	}



	@Override
	public String getRole(String email) {
		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users u) {
		repo.save(u);
	}

	@Override
	public void deactivateUser(String email) {
		Users u=repo.findByEmail(email);
		repo.delete(u);

	}
}










