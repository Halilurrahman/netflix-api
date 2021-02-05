package com.netflix.api.client;

import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.genresdto.GenreID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.themoviedb.org/3/", name="TMDB-API")
public interface MovieClient {

//  @GetMapping("/movie/{movieId}")
//  public MovieDetailsDto getMovieDetails(@PathVariable String movieId, @RequestParam(value = "api_key") String apiKey);
//}
  @GetMapping("/movie/{movieId}")
  public MovieDetailsDto getMovieDetails(@PathVariable String movieId,
                                         @RequestParam(value = "api_key") String apiKey,
                                         @RequestParam(value = "language") String language,
                                         @RequestParam( value = "append_to_response") String videosAndCredits);

  @GetMapping("/discover/movie")
  public GenreID getGenreIDs (@RequestParam(value = "api_key", required=false) String apiKey,
                                 @RequestParam( value = "with_genres", required=false) String genre
//          ,
//                                @RequestParam(value = "language", required=false) String language,
//                                 @RequestParam( value = "with_decade", required=false) String decade,
//                                 @RequestParam(value = "with_cast", required=false) String cast,
//                                 @RequestParam(value = "with_company", required=false)String company,
//                                 @RequestParam(value = "with_page", required=false)Integer page,
//                                 @RequestParam(value = "primary_release_date.gte", required=false)String startDate,
//                                 @RequestParam(value = "primary_release_date.lte", required=false)String endDate
                                    );

    @GetMapping("/discover/movie")
    public GenreID getIDForCast (@RequestParam(value = "api_key", required=false) String apiKey,
                                @RequestParam(value = "with_cast", required=false) String cast

    );
}