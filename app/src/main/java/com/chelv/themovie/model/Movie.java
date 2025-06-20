package com.chelv.themovie.model;

import android.media.Image;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import java.util.List;
import java.util.Objects;

import com.bumptech.glide.Glide;
import com.chelv.themovie.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Movie extends BaseObservable {


    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView imageView, String imageURL){
        String imagePath = "https://image.tmdb.org/t/p/w500/" + imageURL;

        Glide.with(imageView.getContext())
                .load(imagePath)
                .into(imageView);
    }

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
        notifyPropertyChanged(BR.voteAverage);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Movie movie = (Movie) o;

        return Objects.equals(id, movie.id) &&
                Double.compare(movie.voteAverage, voteAverage) == 0 &&
                Objects.equals(title, movie.title) &&
                Objects.equals(overview, movie.overview) &&
                Objects.equals(posterPath, movie.posterPath) &&
                Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,voteAverage,title,overview,posterPath,releaseDate);
    }


}