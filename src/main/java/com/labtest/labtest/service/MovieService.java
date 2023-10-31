package com.labtest.labtest.service;

import com.labtest.labtest.model.Movie;
import com.labtest.labtest.repo.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
}
