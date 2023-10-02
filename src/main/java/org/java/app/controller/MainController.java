package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.app.model.Movie;
import org.java.app.model.Song;
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
		
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		List<Song> songs = getBestSongs();
		
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovie(@PathVariable int id, Model model) {
		Movie movie = getBestMovies().stream().filter(singleMovie -> singleMovie.getId() == id).toList().get(0);
		
		model.addAttribute("movie", movie);
		
		return "movie";
	}
	
	@GetMapping("/songs/{id}")
	public String getSong(@PathVariable int id, Model model) {
		Song song = getBestSongs().stream().filter(singleSong -> singleSong.getId() == id).toList().get(0);
		
		model.addAttribute("song", song);
		return "song";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie(1, "Movie 1"));
		movies.add(new Movie(2, "Movie 2"));
		movies.add(new Movie(3, "Movie 3"));
		movies.add(new Movie(4, "Movie 4"));
		movies.add(new Movie(5, "Movie 5"));
		
		return movies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		
		songs.add(new Song(1, "Song 1"));
		songs.add(new Song(2, "Song 2"));
		songs.add(new Song(3, "Song 3"));
		songs.add(new Song(4, "Song 4"));
		songs.add(new Song(5, "Song 5"));
		
		return songs;
	}
}
