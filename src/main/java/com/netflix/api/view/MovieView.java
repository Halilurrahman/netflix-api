package com.netflix.api.view;


import com.netflix.api.dto.*;

import java.util.List;

//import com.netflix.api.dto.Result;

public class MovieView {

    private Integer id;
    private String title;
    private String overview;
    private Integer runtime;
    private String posterPath;
    private String backdropPath;
    private List<Genre> genres;
    private String youtubeKey;
    private String movieThumbUrl;
    private String logoUrl;
    private String director;

    //    private Videos videos;
//    private List<Result> result;
//    private Credits credits;

    public String toString() {
        return ("id =" + id + " title = " + title + " runtime= " + runtime);
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(Credits credits) {
        this.director = credits.getDirector();
    }

//    public void setDirector(List<Crew> listOfCrewForDirector) {
//        this.director = listOfCrewForDirector.stream().filter(t -> t.getJob().equals("Director")).findFirst().get();
//    }

//    public Credits getCredits() {
//        return credits;
//    }
//
//    public void setCredits(Credits credits) {
//        this.credits = credits;
//    }
//
//
//    public List<Result> getResult() {
//        return result;
//    }
//
//    public void setResult(List<Result> result) {
//        this.result = result;
//    }

    public String getYoutubeKey() {
        return youtubeKey;
    }

    public void setYoutubeKey(Result youtubeKey) {
        this.youtubeKey = youtubeKey.getKey();
    }

    public void setYoutubeKey(String youtubeKey) {
        this.youtubeKey = youtubeKey;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

//    public Videos getVideos() {
//        return videos;
//    }
//
//    public void setVideos(Videos videos) {
//        this.videos = videos;
//    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Integer getId() {
        return id;
    }

    public String getMovieThumbUrl() {
        return movieThumbUrl;
    }

    public void setMovieThumbUrl(String movieThumbUrl) {
        this.movieThumbUrl = movieThumbUrl;
    }
}
