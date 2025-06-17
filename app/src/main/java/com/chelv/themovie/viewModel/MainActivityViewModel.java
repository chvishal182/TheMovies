package com.chelv.themovie.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chelv.themovie.model.Movie;
import com.chelv.themovie.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    private MutableLiveData<List<Movie>> popularMoviesLiveData;
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessageLiveData = new MutableLiveData<>();


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
        this.popularMoviesLiveData = new MutableLiveData<>();
    }

    /*public LiveData<List<Movie>> getPopularMovies(){
        return movieRepository.getMutableLiveData();
    }*/


    public LiveData<List<Movie>> getPopularMoviesLiveData() {
        return popularMoviesLiveData;
    }
    public LiveData<String> getErrorMessageLiveData() {
        return errorMessageLiveData;
    }

    public void fetchPopularMovies(){
            isLoading.setValue(true);

            movieRepository.fetchAndSetPopularMovies(new MovieRepository.RepositoryCallback<List<Movie>>() {
                @Override
                public void onSuccess(List<Movie> data) {
                        popularMoviesLiveData.setValue(data);
                        isLoading.setValue(false);
                }

                @Override
                public void onError(Throwable t) {
                    errorMessageLiveData.setValue("Failed to fetch movies: " + t.getMessage());
                    Log.e("ViewModel", "Error fetching movies", t);
                    isLoading.setValue(false);
                    popularMoviesLiveData.setValue(new ArrayList<>());
                }
            });

    }


}
