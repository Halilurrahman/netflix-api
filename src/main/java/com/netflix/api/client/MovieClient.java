package com.netflix.api.client;

import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.searchdto.SearchActorDTO;
import com.netflix.api.genresdto.GenreID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.themoviedb.org/3/", name = "TMDB-API")
public interface MovieClient {

  @GetMapping("/movie/{movieId}")
  public MovieDetailsDto getMovieDetails(@PathVariable String movieId,
                                         @RequestParam(value = "api_key") String apiKey,
                                         @RequestParam(value = "language") String language,
                                         @RequestParam(value = "append_to_response") String videosAndCredits
  );


  @GetMapping("/discover/movie")
  public GenreID getMoviesByGenre(@RequestParam(value = "api_key") String apiKey,
                                  @RequestParam(value = "page") Integer page,
                                  @RequestParam(value = "with_genres") String genre,
                                  @RequestParam(value = "language") String language
  );

  @GetMapping("/discover/movie")
  public GenreID getMoviesByCast(@RequestParam(value = "api_key") String apiKey,
                                 @RequestParam(value = "page") Integer page,
                                 @RequestParam(value = "with_cast") String cast,
                                 @RequestParam(value = "language") String language
  );

  @GetMapping("/discover/movie")
  public GenreID getMoviesByCompany(@RequestParam(value = "api_key") String apiKey,
                                    @RequestParam(value = "page") Integer page,
                                    @RequestParam(value = "with_companies") String company,
                                    @RequestParam(value = "language") String language
  );

  @GetMapping("/discover/movie")
  public GenreID getMoviesByDecade(@RequestParam(value = "api_key") String apiKey,
                                   @RequestParam(value = "with_page") Integer page,
                                   @RequestParam(value = "language") String language,
                                   @RequestParam(value = "primary_release_date.gte") String startDate,
                                   @RequestParam(value = "primary_release_date.lte") String endDate
  );
  @GetMapping("/search/person")
  public SearchActorDTO getPerson(@RequestParam(value = "api_key") String apiKey,
                                        @RequestParam(value = "query") String person
  );
}