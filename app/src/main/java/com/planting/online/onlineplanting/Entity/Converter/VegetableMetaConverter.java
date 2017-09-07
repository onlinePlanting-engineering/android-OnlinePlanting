package com.planting.online.onlineplanting.Entity.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Entity.VegetableMeta;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 06/09/2017.
 */
public class VegetableMetaConverter implements PropertyConverter<List<VegetableMeta>, String> {

    @Override
    public List<VegetableMeta> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<VegetableMeta>>() {
        }.getType();
        List<VegetableMeta> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<VegetableMeta> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
