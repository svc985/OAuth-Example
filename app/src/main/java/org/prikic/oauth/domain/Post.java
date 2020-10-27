package org.prikic.oauth.domain;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("content")
    private String content;
}
