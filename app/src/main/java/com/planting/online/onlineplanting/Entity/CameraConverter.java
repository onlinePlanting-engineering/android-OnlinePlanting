package com.planting.online.onlineplanting.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Model.Camera;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 05/09/2017.
 */

public class CameraConverter implements PropertyConverter<List<Camera>, String> {

    @Override
    public List<Camera> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<Camera>>() {
        }.getType();
        List<Camera> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<Camera> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
