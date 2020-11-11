package com.example.mynewsproject.Api;

import com.example.mynewsproject.Pojo.Kino.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String uri="search.json?query=godfather&api-key=gSkLpDr9nbK1FOqGwFddVyFHElg9s2jz";
    @GET(uri)
    Observable<Example> getExample();
}
