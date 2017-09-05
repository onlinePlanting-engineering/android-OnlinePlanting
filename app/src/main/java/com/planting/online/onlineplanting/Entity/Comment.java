package com.planting.online.onlineplanting.Entity;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by ibm on 04/09/2017.
 */

@Entity
public class Comment {

    @Id
    private Long id;
    private String url;
    @Convert(converter = UserConverter.class, columnType = String.class)
    private User user;
    private String content;
    private int grade;
    private String timestamp;
    private String parent;
    private String type;
    private Long object_id;
    private Long reply_count;

    @Convert(converter = CommentContentConverter.class, columnType = String.class)
    private List<Comment> replies;

    @Generated(hash = 252367127)
    public Comment(Long id, String url, User user, String content, int grade, String timestamp, String parent, String type, Long object_id, Long reply_count, List<Comment> replies) {
        this.id = id;
        this.url = url;
        this.user = user;
        this.content = content;
        this.grade = grade;
        this.timestamp = timestamp;
        this.parent = parent;
        this.type = type;
        this.object_id = object_id;
        this.reply_count = reply_count;
        this.replies = replies;
    }

    @Generated(hash = 1669165771)
    public Comment() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Long getReply_count() {
        return reply_count;
    }

    public void setReply_count(Long reply_count) {
        this.reply_count = reply_count;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }
}
