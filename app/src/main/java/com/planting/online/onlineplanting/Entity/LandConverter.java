package com.planting.online.onlineplanting.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Model.LandURL;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 04/09/2017.
 */

public class LandConverter implements PropertyConverter<List<LandURL>, String> {
    @Override
    public List<LandURL> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<LandURL>>() {
        }.getType();
        List<LandURL> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<LandURL> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
