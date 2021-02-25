package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.client.MovieLogoClient;
import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.dto.MovieLogoDto;
import com.netflix.api.dto.Result;
import com.netflix.api.view.MovieView;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieClient client;

    @Autowired
    private MovieLogoClient logoClient;

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;

    @Value("${fanart.api_key}")
    private String fanartApiKey;

    private String language = "en-US";
    //    combinatie van videos en credits voor de append to usage call
    private String videosAndCredits = "videos,credits";
//    private String credits = "credits";

    public MovieView getBannerMovie(String movieId) {

//    MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey);
        MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey, language, videosAndCredits);
        MovieLogoDto logo = new MovieLogoDto();
        MovieView view = new MovieView();
//                logoClient.getMovieLogos(movieId, fanartApiKey);
        try {
            logo = logoClient.getMovieLogos(movieId, fanartApiKey);
            view = new MovieView();
            if (logo.getFirstLogo() != null)
                view.setLogoUrl(logo.getFirstLogo());
            if (logo.getFirstThumbnail() != null)
                view.setMovieThumbUrl(logo.getFirstThumbnail());
//            if (logo == null) {
//
//            }
        } catch (FeignException e) {
            logo = logoClient.getMovieLogos("152747", fanartApiKey);
            view = new MovieView();
            if (logo.getFirstLogo() != null)
                view.setLogoUrl(logo.getFirstLogo());
            if (logo.getFirstThumbnail() != null)
                view.setMovieThumbUrl(logo.getFirstThumbnail());
            System.out.println(" error with feign call to fanart.tv");
        }
//        MovieView view = new MovieView();
//        view.setLogoUrl(logo.getFirstLogo());
//        view.setMovieThumbUrl(logo.getFirstThumbnail());


//        if (logo == null) {
//            logo = logoClient.getMovieLogos("152747", fanartApiKey);
//        } else {
////        view.setLogoUrl(logo.getFirstLogo());
////        view.setMovieThumbUrl(logo.getFirstThumbnail());
//            if (logo.getFirstLogo() != null) {
//                view.setLogoUrl(logo.getFirstLogo());
//            } else {
//                view.setLogoUrl("logo not found");
//            }
//            if (logo.getFirstThumbnail() != null) {
//                view.setMovieThumbUrl(logo.getFirstThumbnail());
//            } else {
//                view.setMovieThumbUrl("moviethumb not found");
//            }
//        }

        view.setBackdropPath(movie.getBackdropPath());
        view.setPosterPath(movie.getPosterPath());
        view.setId(movie.getId());
        view.setOverview(movie.getOverview());
        view.setTitle(movie.getTitle());
        view.setRuntime(movie.getRuntime());
        view.setGenres(movie.getGenres());
//       v will set videos with results with lists of trailer info
//       view.setVideos(movie.getVideos());
//       v will set result with list of trailer info
//       view.setResult(movie.getVideos().getResults());
        List<Result> listForYoutubeKey = movie.getVideos().getResults();
        System.out.println(listForYoutubeKey.size());
        if(listForYoutubeKey.size()>0)
            view.setYoutubeKey(listForYoutubeKey.get(0));
        else
            view.setYoutubeKey("dQw4w9WgXcQ");
            System.out.println(view);
//        view.setCredits(movie.getCredits());
            view.setDirector(movie.getCredits());
//        List<Crew> listOfCrewForDirector = movie.getCredits().getCrew();
//        if(listOfCrewForDirector)
//        System.out.println(listOfCrewForDirector);
//        System.out.println("list director =  " + listOfCrewForDirector.stream().filter(t -> t.getJob().equals("Director")).findFirst().get());
//            view.setDirector(listOfCrewForDirector.stream().filter(t -> t.getJob().equals("Director")).findFirst().get());
        return view;
    }
}