
package com.netflix.api.genresdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results"
})
public class GenreID {

    @JsonProperty("results")
    private List<Result> results = null;

    @JsonProperty("results")
    public List<com.netflix.api.genresdto.Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

}
