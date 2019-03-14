package com.example.taskrestapi.adapterMatch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taskrestapi.HasilPojoMatch.ResponseMatch;
import com.example.taskrestapi.HasilPojoMatch.TeamsItem;
import com.example.taskrestapi.Model.MatchRetrofit;
import com.example.taskrestapi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {
    RecyclerView rvMatch;
    MatchAdapter adapter;
    List<TeamsItem> data;

    public MatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);
        rvMatch = view.findViewById(R.id.rv_match);
        rvMatch.setLayoutManager(new LinearLayoutManager(getActivity()));

        getDataTeams();
        return view;
    }

    private void getDataTeams() {
        MatchRetrofit.getInstance().getDataItems().enqueue(new Callback<ResponseMatch>() {
            @Override
            public void onResponse(Call<ResponseMatch> call, Response<ResponseMatch> response) {
                if (response.isSuccessful()) {
                    data = response.body().getTeams();
                    adapter = new MatchAdapter(getActivity(), data);
                    rvMatch.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ResponseMatch> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
