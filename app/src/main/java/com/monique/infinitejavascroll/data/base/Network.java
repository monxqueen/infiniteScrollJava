package com.monique.infinitejavascroll.data.base;


import com.monique.infinitejavascroll.data.remotesource.TMDBService;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    public static TMDBService getMoviesService(){
        Retrofit api = createService();
        return api.create(TMDBService.class);
    }

    private static Retrofit createService(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(logging);
        okHttpClient.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl urlWithKey = original.url().newBuilder()
                    .addQueryParameter("api_key", "05879cf3a3b66dabbb484a31101639d5")
                    .addQueryParameter("language", "pt-BR")
                    .build();

            return chain.proceed(original.newBuilder().url(urlWithKey).build());
        });

        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }
}
