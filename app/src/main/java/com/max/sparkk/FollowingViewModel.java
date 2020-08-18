package com.max.sparkk;

import androidx.lifecycle.ViewModel;

public class FollowingViewModel extends ViewModel {
    String username,name,image_url;

    public FollowingViewModel(String username, String name, String image_url, int user_id) {
        this.username = username;
        this.name = name;
        this.image_url = image_url;
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    int user_id;
}