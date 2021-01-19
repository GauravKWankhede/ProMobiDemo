package com.example.promobidemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.thecatapi.com/v1/";
    @GET("breeds")
    Call<List<Cat>> getCats();
}
