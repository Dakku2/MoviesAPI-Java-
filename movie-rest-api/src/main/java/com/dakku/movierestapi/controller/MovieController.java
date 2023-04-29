package com.dakku.movierestapi.controller;

import com.dakku.movierestapi.model.Movie;
import com.dakku.movierestapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("movies")
    public List<Movie> getAllMovies() {
        return movieService.GetMovies();
    }

    @GetMapping("movie/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.GetMovie(id);
    }

    @PostMapping("movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.CreateMovie(movie);
    }

    @PutMapping("movie/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.UpdateMovie(id, movie);
    }

    @DeleteMapping("movie/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.DeleteMovie(id);
    }
}
