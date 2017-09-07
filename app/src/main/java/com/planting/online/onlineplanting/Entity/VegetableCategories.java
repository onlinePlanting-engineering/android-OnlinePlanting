package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Entity.Converter.VegetableSubCategoryConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ibm on 06/09/2017.
 */

@Entity
public class VegetableCategories {

    @Id(autoincrement = true)
    private Long id;

    private String url;
    private String name;

    @Convert(converter = VegetableSubCategoryConverter.class, columnType = String.class)
    private List<VegetableSubCategory> vegetables;

    @Generated(hash = 1895006407)
    public VegetableCategories(Long id, String url, String name,
            List<VegetableSubCategory> vegetables) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.vegetables = vegetables;
    }

    @Generated(hash = 267633729)
    public VegetableCategories() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VegetableSubCategory> getVegetables() {
        return this.vegetables;
    }

    public void setVegetables(List<VegetableSubCategory> vegetables) {
        this.vegetables = vegetables;
    }
}
