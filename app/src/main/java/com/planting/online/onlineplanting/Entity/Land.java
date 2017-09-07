package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Entity.Converter.CameraConverter;
import com.planting.online.onlineplanting.Entity.Converter.MetaConverter;
import com.planting.online.onlineplanting.Entity.Data.Camera;
import com.planting.online.onlineplanting.Entity.Data.Meta;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by ibm on 05/09/2017.
 */

@Entity
public class Land {

    @Id private Long id;
    private String url;
    private String farm;
    private Boolean cat;
    private Boolean is_trusteed;
    private Float size;
    private String name;
    private String desc;
    private Boolean is_active;

    @Convert(converter = CameraConverter.class, columnType = String.class)
    private List<Camera> cameras;

    @Convert(converter = MetaConverter.class, columnType = String.class)
    private List<Meta> metas;

    @Generated(hash = 434467695)
    public Land(Long id, String url, String farm, Boolean cat, Boolean is_trusteed, Float size, String name, String desc, Boolean is_active, List<Camera> cameras, List<Meta> metas) {
        this.id = id;
        this.url = url;
        this.farm = farm;
        this.cat = cat;
        this.is_trusteed = is_trusteed;
        this.size = size;
        this.name = name;
        this.desc = desc;
        this.is_active = is_active;
        this.cameras = cameras;
        this.metas = metas;
    }

    @Generated(hash = 1574330841)
    public Land() {
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

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public Boolean getCat() {
        return cat;
    }

    public void setCat(Boolean cat) {
        this.cat = cat;
    }

    public Boolean getIs_trusteed() {
        return is_trusteed;
    }

    public void setIs_trusteed(Boolean is_trusteed) {
        this.is_trusteed = is_trusteed;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }
}
