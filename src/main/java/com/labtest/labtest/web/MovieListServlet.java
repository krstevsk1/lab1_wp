package com.labtest.labtest.web;

import com.labtest.labtest.model.Movie;
import com.labtest.labtest.repo.MovieRepository;
import com.labtest.labtest.service.MovieService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "")
public class MovieListServlet extends HttpServlet implements MovieService {

    private final MovieService movieService;
    private final SpringTemplateEngine springTemplateEngine;
    private final MovieRepository movieRepository;

    public MovieListServlet(MovieService movieService, SpringTemplateEngine springTemplateEngine, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.springTemplateEngine = springTemplateEngine;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.listAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.searchMovies(text);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);
        context.setVariable("movies", movieService.listAll());
        //context.setVariable("ipAddress", req.getRemoteAddr());

        springTemplateEngine.process(
                "listMovies.html",
                context,
                resp.getWriter()
        );
    }


}
