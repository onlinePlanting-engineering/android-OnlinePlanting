package com.planting.online.onlineplanting.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Model.LandURL;
import com.planting.online.onlineplanting.Model.Meta;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 05/09/2017.
 */

public class MetaConverter implements PropertyConverter<List<Meta>, String> {
    @Override
    public List<Meta> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<Meta>>() {
        }.getType();
        List<Meta> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<Meta> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
