package org.prikic.oauth.network;

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.prikic.oauth.util.SessionManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Interceptor to add auth token to requests
 */
public class AuthInterceptor implements Interceptor {

    private Context context;

    public AuthInterceptor(Context context) {
        this.context = context;
    }

    private SessionManager sessionManager = new SessionManager(context);

    @NotNull
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();

        // If token has been saved, add it to the request
        if (sessionManager.fetchAuthToken() != null) {
            requestBuilder.addHeader("Authorization", "Bearer $it");
        }

        return chain.proceed(requestBuilder.build());
    }
}
