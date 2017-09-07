package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Entity.Converter.ImageGroupConverter;
import com.planting.online.onlineplanting.Entity.Data.ImageInfor;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by ibm on 05/09/2017.
 */

@Entity
public class ImageGroup {

    @Id private Long id;
    private String desc;
    private String timestamp;

    @Convert(converter = ImageGroupConverter.class, columnType = String.class)
    private List<ImageInfor> imgs;

    @Generated(hash = 880259988)
    public ImageGroup(Long id, String desc, String timestamp, List<ImageInfor> imgs) {
        this.id = id;
        this.desc = desc;
        this.timestamp = timestamp;
        this.imgs = imgs;
    }

    @Generated(hash = 575084589)
    public ImageGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<ImageInfor> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImageInfor> imgs) {
        this.imgs = imgs;
    }
}
