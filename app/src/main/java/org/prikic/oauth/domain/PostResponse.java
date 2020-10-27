package org.prikic.oauth.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostResponse {
    @SerializedName("status_code")
    private Integer status;

    @SerializedName("message")
    private String message;

    @SerializedName("posts")
    List<Post> posts;
}
