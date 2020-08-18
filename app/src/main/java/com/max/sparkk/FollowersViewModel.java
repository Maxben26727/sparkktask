package com.max.sparkk;

import androidx.lifecycle.ViewModel;

public class FollowersViewModel extends ViewModel {
String username,name,image_url;
int personal;
    int professional;
    int user_id;

    public FollowersViewModel(String username, String name, String image_url, int personal, int professional, int user_id, int following) {
        this.username = username;
        this.name = name;
        this.image_url = image_url;
        this.personal = personal;
        this.professional = professional;
        this.user_id = user_id;
        this.following = following;
    }

    int following;

    public FollowersViewModel() {
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
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

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public int getProfessional() {
        return professional;
    }

    public void setProfessional(int professional) {
        this.professional = professional;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}