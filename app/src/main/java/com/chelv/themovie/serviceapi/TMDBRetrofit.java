package com.chelv.themovie.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TMDBRetrofit {

    private static Retrofit retrofit = null;

    public static MovieServiceApi getService(){
        if(retrofit == null){
            String BASE_URL = "https://api.themoviedb.org/3/";
            retrofit = new Retrofit.Builder()
                                   .baseUrl(BASE_URL)
                                   .addConverterFactory(GsonConverterFactory.create())
                                   .build();
        }
        return retrofit.create(MovieServiceApi.class);
    }

}
