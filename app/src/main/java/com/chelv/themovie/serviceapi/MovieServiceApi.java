package com.chelv.themovie.serviceapi;

import com.chelv.themovie.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieServiceApi {

    @GET("movie/popular")
    Call<Results> getPopularMovies(@Query("api_key") String apiKey);
}
