package com.example.hazelwang.retrofitapp;

import android.location.Location;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/*
* define the base_url as the root url of our application
* retrofit divide the url into two parts, one part is the base url while another part is the api name
* define the api name and call type, so the api will gives us the content only type of RetroLocation
* */

public interface RestApi {
    //String BASE_URL = "https://simplifiedcoding.net/demos/";
    public static final String BASE_URL = "https://demo.openmrs.org/openmrs/ws/rest/v1/";
    public static final String AUTHORIZATION_TOKEN = "authorisation";

    String USERNAME = "admin";
    String PASSWORD = "Admin123";
    String LOGIN = "login";


    //@GET("location")
    @GET("Location")
    Call<List<RetroLocation>> getLocation(
           // @Header("Authentication")String authkey,
            //@Path("username") String username
    );

//    @GET("location")
//    Call<List<RetroLocation>> getLocation();

//    @GET("location?tag=Login%20Location")
//    Call<List<Location>> getLocations(@Query("v") String representation);
//
//    @GET()
//    Call<List<Location>> getLocations(@Url String url,
//                                         @Query("tag") String tag,
//                                         @Query("v") String representation);

}
