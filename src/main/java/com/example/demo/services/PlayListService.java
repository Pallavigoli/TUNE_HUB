package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Users;

public interface PlayListService 
{

	public void addPlaylist(PlayList playlist);

	public List<PlayList> fetchPlaylists();

	public List<PlayList> getCustomerPlaylist(Users user);

	
}
