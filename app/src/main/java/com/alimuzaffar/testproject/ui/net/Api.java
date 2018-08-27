package com.alimuzaffar.testproject.ui.net;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class Api {

    private static Retrofit retrofit;
    private static ApiInterface api;
    private static final String BASE_URL = "https://example.com";

    public static ApiInterface getApi() {
        if (api == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(ApiInterface.class);
        }
        return api;
    }

    interface ApiInterface {
        @GET("/endpoint")
        Call<List<String>> getString();

        @GET("/endpoint")
        Call<List<String>> getStringWithQuery(@Query("query1") String query1);

        @GET("endpoint/{path}")
        Call<List<String>> getStringWithPath(@Path("path") String path);
    }
}