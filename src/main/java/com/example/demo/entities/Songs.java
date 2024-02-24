package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Songs 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genre;
	String link;
	//changed here
	String imagelink;
	@ManyToMany
	List<PlayList> playlist;
	
	@ManyToOne
	Users user;

	public Songs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Songs(int id, String name, String artist, String genre, String link, String imagelink,
			List<PlayList> playlist, Users user) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.imagelink = imagelink;
		this.playlist = playlist;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImagelink() {
		return imagelink;
	}

	public void setImagelink(String imagelink) {
		this.imagelink = imagelink;
	}

	public List<PlayList> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<PlayList> playlist) {
		this.playlist = playlist;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Songs [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ ", imagelink=" + imagelink + "]";
	}
	
	

}











