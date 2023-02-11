package com.example.sanvalero_android_skill5_retrofitavanzado.movie_list;

import android.util.Log;

import com.example.sanvalero_android_skill5_retrofitavanzado.model.Movie;
import com.example.sanvalero_android_skill5_retrofitavanzado.model.MovieListResponse;
import com.example.sanvalero_android_skill5_retrofitavanzado.network.ApiClient;
import com.example.sanvalero_android_skill5_retrofitavanzado.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListModel implements MovieListContract.Model {

    private final String TAG = "MovieListModel";


    /**
     * This function will fetch movies data
     * @param onFinishedListener
     * @param pageNo : Which page to load.
     */
    @Override
    public void getMovieList(final OnFinishedListener onFinishedListener, int pageNo) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MovieListResponse> call = apiService.getPopularMovies("No tengo de esto Profe D:", pageNo);
        call.enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
                onFinishedListener.onFinished(movies);
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }

}