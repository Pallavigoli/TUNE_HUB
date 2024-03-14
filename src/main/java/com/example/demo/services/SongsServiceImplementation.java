package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.repositories.SongsRepository;

@Service
public class SongsServiceImplementation implements SongsService {
	@Autowired
	SongsRepository srepo;	
	@Override
	public String addSongs(Songs song) {
		srepo.save(song);
		return "Song is added";
	}
	@Override
	public boolean songExists(String name) {
		Songs song = 
		srepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public List<Songs> fetchAllSongs() {
		
		List<Songs> songslist = 
				srepo.findAll();
		
		return songslist;
	}
	
	
	@Override
	public void updateSong(Songs song) {
		srepo.save(song);
	}
	
	// Search songs by name
    public List<Songs> searchSongsByName(String name) {
        return srepo.findByNameContainingIgnoreCase(name);
    }

    // Search songs by artist
    public List<Songs> searchSongsByArtist(String artist) {
        return srepo.findByArtistContainingIgnoreCase(artist);
    }
	@Override
	public void deleteSong(String name) {
		// TODO Auto-generated method stub
		Songs s=srepo.findByName(name);
		srepo.delete(s);
	}

}
















