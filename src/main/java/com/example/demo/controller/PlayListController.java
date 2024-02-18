
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PlayListController 
{
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@Autowired
	UsersService userv;
	
	@GetMapping("/createplaylist")
	public String createPlayList(Model model) {
		
		//Fetching the songs using song service
		List<Songs> songslist=sserv.fetchAllSongs();
		
		//Adding the songs in the model
		model.addAttribute("songslist",songslist);
		
		return "createplaylist";
	}
	
	@GetMapping("/customercreateplaylist")
	public String customerCreatePlayList(Model model) {
		
		//Fetching the songs using song service
		List<Songs> songslist=sserv.fetchAllSongs();
		
		//Adding the songs in the model
		model.addAttribute("songslist",songslist);
		
		return "customerCreateplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//adding p
		System.out.println(playlist);
		pserv.addPlaylist(playlist);
		
		//update song table
		
		List<Songs> songsList= playlist.getSongs();
		for(Songs song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		
		return "playlistsuccess";
	}
	
	@PostMapping("/customeraddplaylist")
	public String customerAddPlayList(@ModelAttribute PlayList playlist, HttpSession session) {
		
		//fetching the details of user and setting to playList
		String email=(String) session.getAttribute("email");
		Users u=userv.getUser(email);
	
		playlist.setUser(u);
		
		System.out.println(playlist);
		//adding p
		pserv.addPlaylist(playlist);
		
		
		//update song table
		List<Songs> songsList= playlist.getSongs();
		for(Songs song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		
		//updating user in songs
		Songs s=new Songs();
		s.setUser(u);
		sserv.updateSong(s);
		
		return "playlistsuccess";
	}
	
	
	@GetMapping("/viewPlaylists")
	
	public String viewPlaylists(Model model) {
		List<PlayList> plist= pserv.fetchPlaylists();
		model.addAttribute("plist", plist);
		return "viewPlaylists";
	}
	
	
	@GetMapping("/customerviewPlaylists")
	public String customerViewPlaylists(Model model,HttpSession session) {
		
		String email=(String) session.getAttribute("email");
		Users i=userv.getUser(email);
		System.out.println(i);
		List<PlayList> customeruser=pserv.getCustomerPlaylist(i);
		System.out.println(customeruser);
		model.addAttribute("userp", customeruser);
		return "customerViewPlaylist";
	}
	
}










