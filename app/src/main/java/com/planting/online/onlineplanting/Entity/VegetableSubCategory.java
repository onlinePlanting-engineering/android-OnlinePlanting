package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Entity.Converter.VegetableMetaConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by ibm on 06/09/2017.
 */

@Entity
public class VegetableSubCategory {

    @Id(autoincrement = true)
    private Long id;

    private String url;
    private String name;

    @Convert(converter = VegetableMetaConverter.class, columnType = String.class)
    private List<VegetableMeta> vegmetas;

    @Generated(hash = 1643982703)
    public VegetableSubCategory(Long id, String url, String name,
            List<VegetableMeta> vegmetas) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.vegmetas = vegmetas;
    }

    @Generated(hash = 13543990)
    public VegetableSubCategory() {
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

    public List<VegetableMeta> getVegmetas() {
        return vegmetas;
    }

    public void setVegmetas(List<VegetableMeta> vegmetas) {
        this.vegmetas = vegmetas;
    }
}
