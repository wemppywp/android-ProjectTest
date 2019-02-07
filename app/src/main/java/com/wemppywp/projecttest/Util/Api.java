package com.wemppywp.projecttest.Util;

import com.wemppywp.projecttest.Model.Surah;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {

    @Headers("Content-Type: application/json")
    @GET("/surah/1?offset=1/")
    Call<Surah> getAnswer();

}
