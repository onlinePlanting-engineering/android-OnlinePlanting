package com.planting.online.onlineplanting.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Model.ImageInfor;
import com.planting.online.onlineplanting.Model.ImageURL;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 05/09/2017.
 */

public class ImageGroupConverter implements PropertyConverter<List<ImageInfor>, String> {
    @Override
    public List<ImageInfor> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<ImageInfor>>() {
        }.getType();
        List<ImageInfor> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<ImageInfor> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
