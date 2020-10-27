package org.prikic.oauth.network;

import org.prikic.oauth.domain.LoginRequest;
import org.prikic.oauth.domain.LoginResponse;
import org.prikic.oauth.domain.PostResponse;
import org.prikic.oauth.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET(Constants.POSTS_URL)
    Call<PostResponse> fetchPosts();
}
