package com.chelv.themovie.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.chelv.themovie.R;
import com.chelv.themovie.model.Movie;
import com.chelv.themovie.model.Results;
import com.chelv.themovie.serviceapi.MovieServiceApi;
import com.chelv.themovie.serviceapi.TMDBRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private List<Movie> movies = new ArrayList<Movie>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    private MovieServiceApi movieServiceApi;

    public interface RepositoryCallback<T>{
        void onSuccess(T data);
        void onError(Throwable t);
    }

    public MovieRepository(Application application) {
        this.application = application;
        this.movieServiceApi = TMDBRetrofit.getService();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    /*public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieServiceApi movieServiceApi = TMDBRetrofit.getService();

        Call<Results> call = movieServiceApi.getPopularMovies(application.getString(R.string.api_key));

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results results = response.body();

                if(results != null && results.getResults() != null){
                    movies = results.getResults();
                    mutableLiveData.setValue(movies);
                }
            }
            @Override
            public void onFailure(Call<Results> call, Throwable t) {
            }
        });
        
        return mutableLiveData;
    }*/

    public void fetchAndSetPopularMovies(final RepositoryCallback<List<Movie>> callback){

        Call<Results> call = movieServiceApi.getPopularMovies(application.getString(R.string.api_key));

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if(response.isSuccessful() && response.body() != null && response.body().getResults() != null){
                        List<Movie> movies = response.body().getResults();
                        callback.onSuccess(movies);
                }else{
                        String errorMessage = "API Error: " + response.code() + " " + response.message();
                        callback.onError(new Exception(errorMessage));
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.e("Repository", "Network failure", t);
                callback.onError(t);
            }
        });
    }
}
