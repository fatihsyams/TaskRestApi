package com.example.taskrestapi.Model;

import com.example.taskrestapi.HasilPojoMatch.ResponseMatch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceMatch {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<ResponseMatch> getDataItems();
    }


