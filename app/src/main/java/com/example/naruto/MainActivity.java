package com.example.naruto;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naruto.model.NarutoList;
import com.example.naruto.service.NarutoApiClient;
import com.example.naruto.service.NarutoService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private NarutoList narutoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        narutoList = new NarutoList(new ArrayList<>());

        RecyclerView recyclerView = findViewById(R.id.naruto_recyclerview);
        NarutoRecyclerAdapter recyclerAdapter = new NarutoRecyclerAdapter(getApplicationContext(),
                narutoList.getResults());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        NarutoService service = NarutoApiClient.getClient().create(NarutoService.class);
        Call<NarutoList> call = service.getNarutoList();
        call.enqueue(new Callback<NarutoList>() {
            @Override
            public void onResponse(Call<NarutoList> call, Response<NarutoList> response) {
                narutoList = response.body();
                Log.d(TAG, "onResponse: " + narutoList);
                recyclerAdapter.setNarutos(narutoList.getResults());
            }

            @Override
            public void onFailure(Call<NarutoList> call, Throwable t) {
                Log.e(TAG, "onFailure: " + toString(), t);
            }
        });
    }
}