package com.planting.online.onlineplanting.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Model.CommentURL;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ibm on 04/09/2017.
 */

public class UserConverter implements PropertyConverter<User, String> {

    @Override
    public User convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<User>() {
        }.getType();
        User user = new Gson().fromJson(databaseValue, type);
        return user;
    }

    @Override
    public String convertToDatabaseValue(User entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
