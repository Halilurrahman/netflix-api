
package com.netflix.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "backdrop_path",
        "id",
        "original_language",
        "original_title",
        "overview",
        "poster_path",
        "runtime",
        "title",
        "genres",
        "videos",
        "result",
        "youtubeKey",
        "credits"
})

public class MovieDetailsDto {

    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("title")
    private String title;
    @JsonProperty("genres")
    private List<Genre> genres;
    @JsonProperty("videos")
    private Videos videos;
    @JsonProperty("result")
    private List<Result> result;
    @JsonProperty("youtubeKey")
    private String youtubeKey;
    @JsonProperty("credits")
    private Credits credits;

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }


    public List<Result> getResult() {
        return result;
    }
    public void setResult(List<Result> result) {
        this.result = result;
    }


    public void setVideos(Videos videos) {
        this.videos = videos;
    }
    public Videos getVideos() {
        return videos;
    }


    public String getYoutubeKey() {
        return youtubeKey;
    }
    public void setYoutubeKey(String youtubeKey) {
        this.youtubeKey = youtubeKey;
    }


    @JsonProperty("genres")
    public List<Genre> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @JsonProperty("backdrop_path")
    public String getBackdropPath() {
        return backdropPath;
    }

    @JsonProperty("backdrop_path")
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("original_language")
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @JsonProperty("original_language")
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @JsonProperty("original_title")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("original_title")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("poster_path")
    public String getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @JsonProperty("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
}
