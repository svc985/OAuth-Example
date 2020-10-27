package org.prikic.oauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.prikic.oauth.domain.LoginRequest;
import org.prikic.oauth.domain.LoginResponse;
import org.prikic.oauth.domain.PostResponse;
import org.prikic.oauth.network.ApiClient;
import org.prikic.oauth.util.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiClient = new ApiClient();

        login();

        fetchPosts();
    }


    /**
     * Function to fetch posts
     */
    private void fetchPosts() {
        apiClient.getApiService(this).fetchPosts()
                .enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<PostResponse> call, @NotNull Response<PostResponse> response) {
                        // Handle function to display posts

                    }

                    @Override
                    public void onFailure(@NotNull Call<PostResponse> call, @NotNull Throwable t) {
                        // Error fetching posts
                    }
                });

    }

    private void login() {

        final SessionManager sessionManager = new SessionManager(this);

        LoginRequest loginRequest = new LoginRequest("mail", "password");
        apiClient.getApiService(this).login(loginRequest)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();

                        if (loginResponse == null || loginResponse.getStatusCode() == null) {
                            return;
                        }

                        if (loginResponse.getStatusCode().equals("200") && loginResponse.getUser() != null) {
                            sessionManager.saveAuthToken(loginResponse.getAuthToken());
                        } else {
                            // Error logging in
                            Log.e(TAG, "Error logging in");
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                        // Error logging in
                    }
                });
    }

}
