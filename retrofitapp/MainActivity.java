package com.example.hazelwang.retrofitapp;

import android.app.ProgressDialog;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

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

        //progressDialogs
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        //define the listview
        listviewLocation = (ListView)findViewById(R.id.lvLocation);
        //calling getlocation method to display the location
        getLocation();
    }

    private void getLocation() {
        //create object for the RetrofitInstance
        RestApi api = RetrofitInstance.getRetrofitInstance().create(RestApi.class);
        //making the call object using the api method created in the api class
        Call<List<RetroLocation>> call = api.getLocation();
        //making the call using enqueue(), it takes callback interface as an argument
        call.enqueue(new Callback<List<RetroLocation>>() {
            @Override
            public void onResponse(Call<List<RetroLocation>> call, Response<List<RetroLocation>> response) {
                progressDoalog.dismiss();
                if (response.body() != null) {
                    //goes to my list
                    List<RetroLocation> locationList = response.body();
                    //creating an string array for the listview
                    String[] location = new String[locationList.size()];
                    //fill in the array with the response data from json
                    for (int i = 0; i < locationList.size(); i++) {
                        location[i] = locationList.get(i).getLocation();
                    }
                    //displaying the string array into the listView
                    ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.custom_row, R.id.location, location);
                    listviewLocation.setAdapter(adapter);

                    //generateDataList(response.body());
                }else
                    Log.d("result", "No response");
            }

            @Override
            public void onFailure(Call<List<RetroLocation>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroLocation> locationList) {

//        recyclerView = findViewById(R.id.customRecyclerView);
//        adapter = new CustomAdapter(this,locationList);
//        RecyclerView.LayoutManager
//                layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
    }


}
