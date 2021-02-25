package com.netflix.api.service;

import com.netflix.api.enums.Cast;
import com.netflix.api.enums.Company;
import com.netflix.api.enums.Decade;
import com.netflix.api.enums.Genre;
import com.netflix.api.client.MovieClient;
import com.netflix.api.genresdto.GenreID;
import com.netflix.api.genresdto.Result;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.netflix.api.enums.Cast.*;
import static com.netflix.api.enums.Company.*;
import static com.netflix.api.enums.Decade.*;
import static com.netflix.api.enums.Genre.*;

@Service
public class GenreService {

    @Autowired
    private MovieClient client;
    @Autowired
    private MovieService service;

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;

//    @Value("${fanart.api_key}")
//    private String fanartApiKey;
@Value("${languageTMDB}")
    private String language;

    public List<MovieView> getMovieViewsByGenre(Genre genre) {
        return switch (genre) {
            case COMEDY -> get40MovieViewsByGenre(COMEDY.getId());
            case FAMILY -> get40MovieViewsByGenre(FAMILY.getId());
            case ACTION -> get40MovieViewsByGenre(ACTION.getId());
            case THRILLER -> get40MovieViewsByGenre(THRILLER.getId());
            case FANTASY -> get40MovieViewsByGenre(FANTASY.getId());
            case CRIME -> get40MovieViewsByGenre(CRIME.getId());
            case ADVENTURE -> get40MovieViewsByGenre(ADVENTURE.getId());
            default -> throw new IllegalStateException("Unexpected value: " + genre);
        };
    }

    private List<MovieView> get40MovieViewsByGenre(String genreNumberTMDB) {
        GenreID firstPage = client.getMoviesByGenre(tmdbApiKey, 1, genreNumberTMDB, language);
        GenreID secondPage = client.getMoviesByGenre(tmdbApiKey, 2, genreNumberTMDB, language);
        return loopListOfIDAndGetMovieViews(firstPage, secondPage);
    }

    private List<MovieView> loopListOfIDAndGetMovieViews(GenreID firstPage, GenreID secondPage) {
        List<Result> totalMovies = new ArrayList<>();
        Stream.of(firstPage.getResults(), secondPage.getResults()).forEach(totalMovies::addAll);
        MovieView movieView = new MovieView();
        List<MovieView> listOf40GenreMovieViews = new ArrayList<>();
        for (Result totalMovie : totalMovies) {
            movieView = service.getBannerMovie(totalMovie.toString());
            listOf40GenreMovieViews.add(movieView);
            if (listOf40GenreMovieViews.size() == 40) {
                break;
            }
        }
        return listOf40GenreMovieViews;
    }

    public List<MovieView> getMovieViewsByCompany(Company company) {
        return switch (company) {
            case LUCAS_FILM -> get40MoviesByCompany(LUCAS_FILM.getId());
            case DISNEY -> get40MoviesByCompany(DISNEY.getId());
            case PIXAR -> get40MoviesByCompany(PIXAR.getId());
            case NEW_LINE_CINEMA -> get40MoviesByCompany(NEW_LINE_CINEMA.getId());
            case WARNER_BROS_ENTERTAINMENT_US -> get40MoviesByCompany(WARNER_BROS_ENTERTAINMENT_US.getId());
            default -> throw new IllegalStateException("Unexpected value: " + company);
        };
    }

    private List<MovieView> get40MoviesByCompany(String companyNumberTMDB) {
        GenreID firstPage = client.getMoviesByCompany(tmdbApiKey, 1, companyNumberTMDB, language);
        GenreID secondPage = client.getMoviesByCompany(tmdbApiKey, 2, companyNumberTMDB, language);
        return loopListOfIDAndGetMovieViews(firstPage, secondPage);
    }

    public List<MovieView> getMovieViewsByCast(Cast cast) {
        return switch (cast) {
            case TOM_CRUISE -> get40MoviesByCast(TOM_CRUISE.getId());
            case ROBERT_DE_NIRO -> get40MoviesByCast(ROBERT_DE_NIRO.getId());
            case AL_PACINO -> get40MoviesByCast(AL_PACINO.getId());
            default -> throw new IllegalStateException("Unexpected value: " + cast);
        };
    }

    public List<MovieView> get40MoviesByCast(String tmdbCastId) {
        GenreID firstPage = client.getMoviesByCast(tmdbApiKey, 1, tmdbCastId, language);
        GenreID secondPage = client.getMoviesByCast(tmdbApiKey, 2, tmdbCastId, language);
        return loopListOfIDAndGetMovieViews(firstPage, secondPage);
    }

    public List<MovieView> getMovieViewsByDecade(Decade decade) {
        return switch (decade) {
            case EIGHTIES -> get40MoviesByDecade(EIGHTIES.getEarliestDate(), EIGHTIES.getLatestDate());
            case NINETIES -> get40MoviesByDecade(NINETIES.getEarliestDate(), NINETIES.getLatestDate());
            case NOUGHTIES -> get40MoviesByDecade(NOUGHTIES.getEarliestDate(), NOUGHTIES.getLatestDate());
            default -> throw new IllegalStateException("Unexpected value: " + decade);
        };
    }

    private List<MovieView> get40MoviesByDecade(String earliestDate, String latestDate) {
        GenreID firstPage = client.getMoviesByDecade(tmdbApiKey, 1, language, earliestDate, latestDate);
        GenreID secondPage = client.getMoviesByDecade(tmdbApiKey, 2, language, earliestDate, latestDate);
        return loopListOfIDAndGetMovieViews(firstPage, secondPage);
    }
}
