package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.app.pojo.Movie;
import org.java.app.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(Model model) {
		String name = "Mattia";
		
		model.addAttribute("name", name);
		
		return "home";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		List<Movie> movies = getBestMovies();
		String page = "movies";
		
		model.addAttribute("movies", movies);
		model.addAttribute("page", page);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		List<Song> songs = getBestSongs();
		String page = "songs";
		
		model.addAttribute("songs", songs);
		model.addAttribute("page", page);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovie(@PathVariable int id, Model model) {
		Movie movie = getBestMovies().stream().filter(singleMovie -> singleMovie.getId() == id).toList().get(0);
		String page = "movies";
		
		model.addAttribute("movie", movie);
		model.addAttribute("page", page);
		
		return "movie";
	}
	
	@GetMapping("/songs/{id}")
	public String getSong(@PathVariable int id, Model model) {
		Song song = getBestSongs().stream().filter(singleSong -> singleSong.getId() == id).toList().get(0);
		String page = "songs";
		
		model.addAttribute("song", song);
		model.addAttribute("page", page);
		
		return "song";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		
		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie(i, "Movie " + i));
		}
		
		return movies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		
		for (int i = 1; i <= 5; i++) {
			songs.add(new Song(i, "Song " + i));
		}
		
		return songs;
	}
}
