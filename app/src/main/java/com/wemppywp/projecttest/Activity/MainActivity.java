package com.wemppywp.projecttest.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wemppywp.projecttest.Adapter.AyahsAdapter;
import com.wemppywp.projecttest.Model.Ayahs;
import com.wemppywp.projecttest.Model.Surah;
import com.wemppywp.projecttest.R;
import com.wemppywp.projecttest.Util.Api;
import com.wemppywp.projecttest.Util.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AyahsAdapter adapter;
    CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api service = RetrofitClient.getRetrofitClient().create(Api.class);

        Call<Surah> call = service.getAnswer();

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Surah>() {
            @Override
            public void onResponse(Call<Surah> call, Response<Surah> response) {
                generateAyahsList(response.body().getData().getAyahs());
                Log.d("response", ":" + response.body().getData().getAyahs());

                //perintah klik recyclerview
                recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                    GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                        public boolean onSingleTapUp(MotionEvent e){
                            return true;
                        }
                    });
                    @Override
                    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                        View child = rv.findChildViewUnder(e.getX(),e.getY());
                        if (child != null && gestureDetector.onTouchEvent(e)){
                            int position = rv.getChildAdapterPosition(child);

                            Intent i = new Intent(MainActivity.this, DeskripsiActivity.class);
                            i.putExtra("Text", get(position).getKlsId());
                            MainActivity.this.startActivity(i);

                        }
                        return false;
                    }

                    @Override
                    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

                    }

                    @Override
                    public void onRequestDisallowInterceptTouchEvent(boolean b) {

                    }
                });
            }

            @Override
            public void onFailure(Call<Surah> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void generateAyahsList(ArrayList<Ayahs> ayahsArrayList){
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new AyahsAdapter(ayahsArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
