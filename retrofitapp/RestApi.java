package com.example.hazelwang.retrofitapp;

import android.location.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
/*
* define the base_url as the root url of our application
* retrofit divide the url into two parts, one part is the base url while another part is the api name
* define the api name and call type, so the api will gives us the content only type of RetroLocation
* */
//String BASE_URL = "https://simplifiedcoding.net/demos/";


public interface RestApi {
    String BASE_URL = "https://demo.openmrs.org/openmrs/ws/rest/v1/";

    @GET("location?tag=Login%20Location")
    Call<Results<LocationObject>> getLocation(@Query("v") String representation);

    @GET()
    Call<Results<Location>> getLocation(@Url String url,
                                         @Query("tag") String tag,
                                         @Query("v") String representation);
}

