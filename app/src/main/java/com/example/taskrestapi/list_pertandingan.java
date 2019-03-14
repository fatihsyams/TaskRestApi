package com.example.taskrestapi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taskrestapi.HasilPojoPertandingan.EventsItem;
import com.example.taskrestapi.HasilPojoPertandingan.ResponsePertandingan;
import com.example.taskrestapi.Model.PertandinganRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class list_pertandingan extends Fragment {

    RecyclerView rvPertandingan;
    PertandinganAdapter adapter;
    List<EventsItem> eventsItems;
    public list_pertandingan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_pertandingan, container, false);
        rvPertandingan = v.findViewById(R.id.rv_Pertandigan);
        rvPertandingan.setLayoutManager(new LinearLayoutManager(getActivity()));
        getDataItems();

        return v;
    }

    private void getDataItems() {
        PertandinganRetrofit.getInstance().getDataItems().enqueue(new Callback<ResponsePertandingan>() {
            @Override
            public void onResponse(Call<ResponsePertandingan> call, Response<ResponsePertandingan> response) {
                if (response.isSuccessful()) {
                    eventsItems = response.body().getEvents();
                    adapter = new PertandinganAdapter(getActivity(), eventsItems);
                    rvPertandingan.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponsePertandingan> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
