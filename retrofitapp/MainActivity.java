package com.example.hazelwang.retrofitapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ListView listviewLocation;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");

        if(!isFinishing()&&progressDoalog!=null)
            progressDoalog.show();

        listviewLocation = findViewById(R.id.lvLocation);
        retriveLocation();
    }

    private void retriveLocation() {
        RestApi api =
                RetrofitInstance.getRetrofitInstance().create(RestApi.class);
        Call<Results<LocationObject>> call = api.getLocation(null);
        call.enqueue(new Callback<Results<LocationObject>>() {

            @Override
            public void onResponse(Call<Results<LocationObject>> call, Response<Results<LocationObject>> response) {
                progressDoalog.dismiss();
                if (response.body() != null){
                    Results<LocationObject> location= response.body();
                    ArrayList<String> locationList = new  ArrayList<>();
                    ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.custom_row, R.id.location, locationList);
                    listviewLocation.setAdapter(adapter);
                    for (LocationObject result : location.getResults()) {
                        Log.d("response body", result.getDisplay().toString());
                        locationList.add(result.getDisplay().toString());
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<Results<LocationObject>> call, Throwable t) {
                if(progressDoalog != null && progressDoalog.isShowing())
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}
