
package com.netflix.api.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieLogoDto {

    private String tmdb_id;
    private List<Hdmovielogo> hdmovielogo = new ArrayList();
    private List<Moviethumb> moviethumb = new ArrayList();

    public String getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(String tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    public List<Hdmovielogo> getHdmovielogo() {
        return hdmovielogo;
    }

    public String getFirstLogo() {
        String en = "en";
        try {
            Hdmovielogo firstLogo = hdmovielogo.stream().filter(l -> l.getLang().equals(en)).findFirst().get();
            return firstLogo.getUrl();
        } catch (Exception e) {
            //           this returns the logo for all is lost
            return "https://assets.fanart.tv/fanart/movies/152747/hdmovielogo/all-is-lost-526338003f164.png";
        }
    }

    public String getFirstThumbnail() {
        String en = "en";
       try {
           Moviethumb firstMovieThumb = moviethumb.stream().filter(mt -> mt.getLang().equals(en)).findAny().get();
           return firstMovieThumb.getUrl();
       }catch (Exception e){
           //            this returns the moviethumb for all is lost
           return "https://assets.fanart.tv/fanart/movies/152747/moviethumb/all-is-lost-52f5aefbc7be3.jpg";
       }
    }

    public void setHdmovielogo(List<Hdmovielogo> hdmovielogo) {
        this.hdmovielogo = hdmovielogo;
    }

    public List<Moviethumb> getMoviethumb() {
        return moviethumb;
    }

    public void setMoviethumb(List<Moviethumb> moviethumb) {
        this.moviethumb = moviethumb;
    }

}
