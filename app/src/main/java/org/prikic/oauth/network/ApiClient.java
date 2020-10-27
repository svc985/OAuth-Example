package org.prikic.oauth.network;

import android.content.Context;

import org.prikic.oauth.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private ApiService apiService;

    public ApiService getApiService(Context context) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build();

        apiService = retrofit.create(ApiService.class);

        return apiService;
    }

    /**
     * Initialize OkhttpClient with our interceptor
     */
    public OkHttpClient okhttpClient(Context context) {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(context))
                .build();
    }
}
