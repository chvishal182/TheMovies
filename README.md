# TheMovie App

TheMovie App is an Android application written entirely in **Java**. It demonstrates how to fetch and display a list of popular movies from The Movie Database (TMDB) API. The project showcases modern Android development practices including MVVM architecture, Retrofit for networking, Glide for image loading, Data Binding, and `ListAdapter` for efficient `RecyclerView` updates.

## Features

*   Displays a grid of popular movies.
*   Loads movie posters dynamically.
*   Implements swipe-to-refresh functionality to reload the movie list.
*   Handles API errors gracefully with user feedback (Toast messages).
*   Utilizes Edge-to-Edge display for a modern UI.


## Screenshots
<img src="https://github.com/user-attachments/assets/66365fd0-83db-45f0-a46f-16e6e3a5a640" alt="Main Screen" width="350"/>
<img src="https://github.com/user-attachments/assets/16cb122b-00ee-4536-b071-a979ad87d970" alt="Swipe to Refresh" width="350"/>
<img src="https://github.com/user-attachments/assets/9ebb70f4-9d7a-4e06-9680-d093cb745eed" alt="Error Message" width="350"/>

## Built With

*   **Java**
*   **Android Jetpack:**
    *   **ViewModel:** Manages UI-related data in a lifecycle-conscious way.
    *   **LiveData:** Observable data holder class.
    *   **Data Binding:** Declaratively binds UI components in your layouts to data sources.
    *   **RecyclerView:** For displaying large sets of data efficiently.
    *   **ListAdapter:** For efficient `RecyclerView` updates using `DiffUtil`.
*   **Retrofit 2:** A type-safe HTTP client for Android and Java.
*   **Gson:** A Java library to convert Java Objects into their JSON representation and vice versa.
*   **Glide:** An image loading and caching library for Android.
*   **Material Components for Android:** For UI elements like `SwipeRefreshLayout`.

## Project Structure

The project follows a standard Android project structure with a focus on modularity, adhering to the MVVM (Model-View-ViewModel) architecture:
```
    com.chelv.themovie 
      ├── adapter # RecyclerView Adapters (MovieAdapter.java)
      ├── model # Data model classes (Movie.java, Results.java)
      ├── serviceapi # Retrofit service interface (MovieServiceApi.java)  and setup (TMDBRetrofit.java)
      ├── viewModel # ViewModels (MainActivityViewModel. java)
      ├── MainActivity.java # Main UI Controller (View)
      └── res/layout/ # XML Layouts including activity_main.xml and movie_list_item.xml
```

## Setup
1.  **API Key Setup:**
    This project requires an API key from [The Movie Database (TMDB)](https://www.themoviedb.org/documentation/api).
    *   Sign up for a TMDB account and request an API key.
    *   Once you have your API key, you need to add it to the project.
    *   **Recommended Method (Using `local.properties` and `BuildConfig`):**
        1.  Create a file named `local.properties` in the root of your project (if it doesn't already exist).
        2.  Add your API key to `local.properties`:

## Acknowledgements

*   [The Movie Database (TMDB) API](https://www.themoviedb.org/documentation/api) for providing the movie data.
*   Libraries used (Retrofit, Glide).
