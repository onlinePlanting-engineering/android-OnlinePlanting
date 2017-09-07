package com.planting.online.onlineplanting.Entity.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Entity.Data.CommentURL;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 04/09/2017.
 */

public class CommentConverter implements PropertyConverter<List<CommentURL>, String> {

    @Override
    public List<CommentURL> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<CommentURL>>() {
        }.getType();
        List<CommentURL> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<CommentURL> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
