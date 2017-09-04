package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Model.CommentURL;
import com.planting.online.onlineplanting.Model.ImageURL;
import com.planting.online.onlineplanting.Model.LandURL;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by ibm on 04/09/2017.
 */
@Entity
public class Farm {

    @Id private Long id;
    private String url;
    private String name;
    private String owner;
    private String price;
    private String subject;
    private String addr;
    private String phone;
    private Boolean is_delete;
    private String notice;
    private String content;
    private String home_img_url;

    @Convert(converter = CommentConverter.class, columnType = String.class)
    private List<CommentURL> comments;

    @Convert(converter = CommentConverter.LandConverter.class, columnType = String.class)
    private List<LandURL> lands;

    @Convert(converter = ImageConverter.class, columnType = String.class)
    private List<ImageURL> imgs;

    @Generated(hash = 1001851944)
    public Farm(Long id, String url, String name, String owner, String price, String subject, String addr, String phone, Boolean is_delete, String notice, String content, String home_img_url, List<CommentURL> comments, List<LandURL> lands, List<ImageURL> imgs) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.owner = owner;
        this.price = price;
        this.subject = subject;
        this.addr = addr;
        this.phone = phone;
        this.is_delete = is_delete;
        this.notice = notice;
        this.content = content;
        this.home_img_url = home_img_url;
        this.comments = comments;
        this.lands = lands;
        this.imgs = imgs;
    }

    @Generated(hash = 1108117748)
    public Farm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHome_img_url() {
        return home_img_url;
    }

    public void setHome_img_url(String home_img_url) {
        this.home_img_url = home_img_url;
    }

    public List<CommentURL> getComments() {
        return comments;
    }

    public void setComments(List<CommentURL> comments) {
        this.comments = comments;
    }

    public List<LandURL> getLands() {
        return lands;
    }

    public void setLands(List<LandURL> lands) {
        this.lands = lands;
    }

    public List<ImageURL> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImageURL> imgs) {
        this.imgs = imgs;
    }
}
