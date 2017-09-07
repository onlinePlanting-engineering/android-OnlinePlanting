package com.planting.online.onlineplanting.Entity.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Entity.Comment;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 04/09/2017.
 */

public class CommentContentConverter implements PropertyConverter<List<Comment>, String> {

    @Override
    public List<Comment> convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<List<Comment>>() {
        }.getType();
        List<Comment> list = new Gson().fromJson(databaseValue, type);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<Comment> entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
