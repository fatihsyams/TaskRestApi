package com.example.taskrestapi.Model;

import com.example.taskrestapi.HasilPojoPertandingan.ResponsePertandingan;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServicePertandingan {
    @GET("eventsnext.php?id=133602")
    Call<ResponsePertandingan> getDataItems();
}
