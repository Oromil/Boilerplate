package com.example.oromil.boilerppate.data.network;

import com.example.oromil.boilerppate.data.Entity;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Oromil on 13.03.2018.
 */

interface Api {

    String BASE_URL = "";

    @GET("")
    List<Entity> requestData();

    public class Creator {

        public Api createApi() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit.create(Api.class);
        }
    }

}
