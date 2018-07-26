package com.example.hazelwang.retrofitapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*Creating a retrofitClientInstance
* Call it in the MainActivity.class to make a retrofit object*/

public class RetrofitInstance {
    private static Retrofit retrofit;

    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    //set your desired log level
    //clientBuilder.addInterceptor(loggingInterceptor);

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(RestApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())//Using the GsonConverterFactory to directly convert json data to object
                    .build();
        }
        return retrofit;
    }
}
