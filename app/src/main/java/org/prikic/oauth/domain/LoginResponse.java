package org.prikic.oauth.domain;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("auth_token")
    private String authToken;

    @SerializedName("user")
    private User user;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
