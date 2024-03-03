package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongsService;


@Controller
public class SongsController {
	@Autowired
	SongsService songserv;

	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs song){
		boolean status = songserv.songExists(song.getName());
		if(status==false)
		{
			songserv.addSongs(song);
			return "songsuccess";
		}
		else
		{
			return "songfail";
		}		
	}
	
	//admin viewing songs
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {
		List<Songs> songslist = songserv.fetchAllSongs();
		model.addAttribute("songslist", songslist);
		return "displaysongs";
	}
	
	
	//customer viewing songs
	@GetMapping("customerviewsongs")
	public String customerViewsongs(Model model)
	{
		List<Songs> songslist = songserv.fetchAllSongs();
		model.addAttribute("songslist", songslist);
		return "customerDisplaysongs";
	}

	
	 // Search songs by name or artist
    @GetMapping("/searchsongs")
    public String searchSongs(@RequestParam("query") String query, @RequestParam("type") String type, Model model) {
        List<Songs> searchResults;
        if ("name".equalsIgnoreCase(type)) {
            searchResults = songserv.searchSongsByName(query);
        } else if ("artist".equalsIgnoreCase(type)) {
            searchResults = songserv.searchSongsByArtist(query);
        } else {
            // Handle invalid search type
            return "error";
        }
        model.addAttribute("songslist", searchResults);
        return "displaysongs";
    }
}

















