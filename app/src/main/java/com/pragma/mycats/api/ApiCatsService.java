package com.pragma.mycats.api;

import com.pragma.mycats.model.Cat;
import com.pragma.mycats.model.CatImage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiCatsService {

    @GET("breeds")
    Call<ArrayList<Cat>> getCats(@Header("x-api-key") String apiKey);
}
