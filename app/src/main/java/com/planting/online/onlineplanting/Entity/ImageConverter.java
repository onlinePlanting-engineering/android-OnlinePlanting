package com.planting.online.onlineplanting.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Model.ImageURL;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 04/09/2017.
 */

public class ImageConverter implements PropertyConverter<List<ImageURL>, String> {
    @Override
    public List<ImageURL> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<ImageURL>>() {
        }.getType();
        List<ImageURL> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<ImageURL> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
