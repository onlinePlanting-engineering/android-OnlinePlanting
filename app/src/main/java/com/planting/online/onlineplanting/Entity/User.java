package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Model.Profile;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by eleven on 2017/9/1.
 */

@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String username;

    Profile profile;

    @Generated
    public User() {
    }

    @Generated
    public User(String username, Profile profile) {
        this.username = username;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
