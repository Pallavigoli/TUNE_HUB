package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Users;

public interface PlayListRepository extends JpaRepository<PlayList, Integer>
{

	public List<PlayList> findByUser(Users user);

}
