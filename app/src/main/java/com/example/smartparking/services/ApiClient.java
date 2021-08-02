package com.example.smartparking.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();


      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl("https://smartparking250.herokuapp.com")
              .addConverterFactory(GsonConverterFactory.create())
              .client(okHttpClient)
              .build();
      return retrofit;

    }
    public static ApiInterface getInterface(){
        ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
        return apiInterface;
    }
    public static LocationInterface getInterfac(){
        LocationInterface location = getRetrofit().create(LocationInterface.class);
        return location;
    }


    public static RegisterService getRegisterService(){
        RegisterService registerService = getRetrofit().create(RegisterService.class);
        return registerService;
    }

    public static ReservationService getReservationService(){
        ReservationService reservationService = getRetrofit().create(ReservationService.class);
        return reservationService;
    }
    public static LoginService getLogin(){
        LoginService loginService = getRetrofit().create(LoginService.class);
        return loginService;
    }
}
