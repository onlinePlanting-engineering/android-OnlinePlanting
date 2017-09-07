package com.planting.online.onlineplanting.Entity.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Entity.VegetableSubCategory;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 06/09/2017.
 */

public class VegetableSubCategoryConverter implements PropertyConverter<List<VegetableSubCategory>, String> {

    @Override
    public List<VegetableSubCategory> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<VegetableSubCategory>>() {
        }.getType();
        List<VegetableSubCategory> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<VegetableSubCategory> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
