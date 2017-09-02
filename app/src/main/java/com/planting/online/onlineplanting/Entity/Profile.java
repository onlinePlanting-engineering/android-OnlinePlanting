package com.planting.online.onlineplanting.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by eleven on 2017/8/31.
 */

@Entity
public class Profile {

    @Id(autoincrement = true)
    private Long id;
    private String addr;
    private String gender;
    private String img_heading;
    private String nickname;
    @Unique private String username;


    @Generated(hash = 1183583938)
    public Profile(Long id, String addr, String gender, String img_heading, String nickname,
            String username) {
        this.id = id;
        this.addr = addr;
        this.gender = gender;
        this.img_heading = img_heading;
        this.nickname = nickname;
        this.username = username;
    }

    @Generated(hash = 782787822)
    public Profile() {
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImg_heading() {
        return img_heading;
    }

    public void setImg_heading(String img_heading) {
        this.img_heading = img_heading;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return this.id;
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
}
