package com.planting.online.onlineplanting.Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.planting.online.onlineplanting.Entity.Converter.VegetableSubCategoryConverter;
import java.util.List;

import com.planting.online.onlineplanting.Entity.VegetableCategories;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VEGETABLE_CATEGORIES".
*/
public class VegetableCategoriesDao extends AbstractDao<VegetableCategories, Long> {

    public static final String TABLENAME = "VEGETABLE_CATEGORIES";

    /**
     * Properties of entity VegetableCategories.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Vegetables = new Property(3, String.class, "vegetables", false, "VEGETABLES");
    }

    private final VegetableSubCategoryConverter vegetablesConverter = new VegetableSubCategoryConverter();

    public VegetableCategoriesDao(DaoConfig config) {
        super(config);
    }
    
    public VegetableCategoriesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VEGETABLE_CATEGORIES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"URL\" TEXT," + // 1: url
                "\"NAME\" TEXT," + // 2: name
                "\"VEGETABLES\" TEXT);"); // 3: vegetables
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VEGETABLE_CATEGORIES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, VegetableCategories entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        List vegetables = entity.getVegetables();
        if (vegetables != null) {
            stmt.bindString(4, vegetablesConverter.convertToDatabaseValue(vegetables));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, VegetableCategories entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        List vegetables = entity.getVegetables();
        if (vegetables != null) {
            stmt.bindString(4, vegetablesConverter.convertToDatabaseValue(vegetables));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public VegetableCategories readEntity(Cursor cursor, int offset) {
        VegetableCategories entity = new VegetableCategories( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : vegetablesConverter.convertToEntityProperty(cursor.getString(offset + 3)) // vegetables
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, VegetableCategories entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setVegetables(cursor.isNull(offset + 3) ? null : vegetablesConverter.convertToEntityProperty(cursor.getString(offset + 3)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(VegetableCategories entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(VegetableCategories entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(VegetableCategories entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
