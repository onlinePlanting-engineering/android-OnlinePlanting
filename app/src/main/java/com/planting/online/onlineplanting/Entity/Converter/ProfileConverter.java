package com.planting.online.onlineplanting.Entity.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.planting.online.onlineplanting.Entity.Data.Profile;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;

/**
 * Created by ibm on 04/09/2017.
 */

public class ProfileConverter implements PropertyConverter<Profile, String> {

    @Override
    public Profile convertToEntityProperty(String databaseValue) {
        Type type = new TypeToken<Profile>() {
        }.getType();
        Profile profile = new Gson().fromJson(databaseValue, type);
        return profile;
    }

    @Override
    public String convertToDatabaseValue(Profile entityProperty) {
        String dbString = new Gson().toJson(entityProperty);
        return dbString;
    }
}
