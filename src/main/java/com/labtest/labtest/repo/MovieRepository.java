package com.labtest.labtest.repo;

import com.labtest.labtest.model.Movie;
import com.labtest.labtest.service.MovieService;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository implements MovieService {

    private List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init() {
        movies = new ArrayList<>();

        movies.add(new Movie("Oppenheimer", "father of the atomic bomb", 8.5));
        movies.add(new Movie("Movie 2", "m2", 8.5));
        movies.add(new Movie("Movie 3", "m3", 8.5));
        movies.add(new Movie("Movie 4", "m4", 8.5));
        movies.add(new Movie("Movie 5", "m5", 8.5));
        movies.add(new Movie("Movie 6", "m6", 8.5));
        movies.add(new Movie("Movie 7", "m7", 8.5));
        movies.add(new Movie("Movie 8", "m8", 8.5));
        movies.add(new Movie("Movie 9", "m9", 8.5));
        movies.add(new Movie("Movie 10", "m10", 8.5));
    }

    public List<Movie> listAll() {
        return movies;
    }

    public List<Movie> searchMovies(String text) {

        return movies.stream()
                .filter(c -> c.getTitle().equals(text))
                .toList();
    }
}
