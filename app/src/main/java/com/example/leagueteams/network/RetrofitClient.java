package com.example.leagueteams.network;

import android.support.annotation.NonNull;

import com.example.leagueteams.BuildConfig;
import com.example.leagueteams.model.LeagueTeamsResponse;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.util.ServiceRoutes;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance;
    private RetrofitService retrofitService;


    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceRoutes.API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient().build())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public static RetrofitClient getInstance() {
        if (null == instance) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    private OkHttpClient.Builder getOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader(ServiceRoutes.TOKEN_KEY, BuildConfig.API_TOKEN)
                        .build();
                return chain.proceed(request);
            }
        });

        return httpClient;
    }

    public Call<LeagueTeamsResponse> getTeamList(int id) {
        return retrofitService.getLeagueTeamList(id);
    }

    public Call<TeamEntity> getTeamDetails(int id) {
        return retrofitService.getTeamDetails(id);
    }

}
