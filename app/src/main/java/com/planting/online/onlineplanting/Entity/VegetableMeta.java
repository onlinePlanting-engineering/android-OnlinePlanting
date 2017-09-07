package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Entity.Converter.ImageConverter;
import com.planting.online.onlineplanting.Entity.Data.ImageURL;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by ibm on 06/09/2017.
 */

@Entity
public class VegetableMeta {

    @Id(autoincrement = true)
    private Long id;

    private String url;
    private String name;
    private String first_letter;
    private String stime;
    private String etime;
    private int cycle;
    private String region;
    private Float output;
    private String seed_price;
    private String mature_price;
    private String desc;
    private String content;
    private Boolean is_active;

    @Convert(converter = ImageConverter.class, columnType = String.class)
    private List<ImageURL> imgs;

    @Generated(hash = 237741610)
    public VegetableMeta(Long id, String url, String name, String first_letter, String stime, String etime, int cycle, String region, Float output, String seed_price, String mature_price, String desc, String content, Boolean is_active,
            List<ImageURL> imgs) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.first_letter = first_letter;
        this.stime = stime;
        this.etime = etime;
        this.cycle = cycle;
        this.region = region;
        this.output = output;
        this.seed_price = seed_price;
        this.mature_price = mature_price;
        this.desc = desc;
        this.content = content;
        this.is_active = is_active;
        this.imgs = imgs;
    }

    @Generated(hash = 984677579)
    public VegetableMeta() {
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

    public String getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(String first_letter) {
        this.first_letter = first_letter;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getOutput() {
        return output;
    }

    public void setOutput(Float output) {
        this.output = output;
    }

    public String getSeed_price() {
        return seed_price;
    }

    public void setSeed_price(String seed_price) {
        this.seed_price = seed_price;
    }

    public String getMature_price() {
        return mature_price;
    }

    public void setMature_price(String mature_price) {
        this.mature_price = mature_price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public List<ImageURL> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImageURL> imgs) {
        this.imgs = imgs;
    }
}
