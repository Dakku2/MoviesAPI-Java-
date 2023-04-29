package com.dakku.movierestapi.services;

import com.dakku.movierestapi.model.Movie;
import com.dakku.movierestapi.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRep;

    public List<Movie> GetMovies() {
        return movieRep.findAll();
    }

    public Movie GetMovie(Long id) {
        Optional<Movie> optMovie = movieRep.findById(id);
        return optMovie.orElse(null);
    }

    public Movie CreateMovie(Movie movie) {
        return movieRep.save(movie);
    }

    public Movie UpdateMovie(Long id, Movie movie) {
        Optional<Movie> optMovie = movieRep.findById(id);
        if(optMovie.isPresent()) {
            Movie existMovie = optMovie.get();
            existMovie.setTitle(movie.getTitle());
            existMovie.setYear(movie.getYear());
            return movieRep.save(existMovie);
        }
        return null;
    }

    public void DeleteMovie(Long id) {
        movieRep.deleteById(id);
    }
}
