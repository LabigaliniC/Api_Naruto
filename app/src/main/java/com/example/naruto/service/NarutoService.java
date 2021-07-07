package com.example.naruto.service;

import com.example.naruto.model.NarutoList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NarutoService {
    @GET("anime?q=naruto")
    Call<NarutoList> getNarutoList();
}
