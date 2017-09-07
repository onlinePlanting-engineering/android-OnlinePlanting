package com.planting.online.onlineplanting.Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.planting.online.onlineplanting.Entity.Converter.CameraConverter;
import com.planting.online.onlineplanting.Entity.Converter.MetaConverter;
import java.util.List;

import com.planting.online.onlineplanting.Entity.Land;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LAND".
*/
public class LandDao extends AbstractDao<Land, Long> {

    public static final String TABLENAME = "LAND";

    /**
     * Properties of entity Land.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property Farm = new Property(2, String.class, "farm", false, "FARM");
        public final static Property Cat = new Property(3, Boolean.class, "cat", false, "CAT");
        public final static Property Is_trusteed = new Property(4, Boolean.class, "is_trusteed", false, "IS_TRUSTEED");
        public final static Property Size = new Property(5, Float.class, "size", false, "SIZE");
        public final static Property Name = new Property(6, String.class, "name", false, "NAME");
        public final static Property Desc = new Property(7, String.class, "desc", false, "DESC");
        public final static Property Is_active = new Property(8, Boolean.class, "is_active", false, "IS_ACTIVE");
        public final static Property Cameras = new Property(9, String.class, "cameras", false, "CAMERAS");
        public final static Property Metas = new Property(10, String.class, "metas", false, "METAS");
    }

    private final CameraConverter camerasConverter = new CameraConverter();
    private final MetaConverter metasConverter = new MetaConverter();

    public LandDao(DaoConfig config) {
        super(config);
    }
    
    public LandDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LAND\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"URL\" TEXT," + // 1: url
                "\"FARM\" TEXT," + // 2: farm
                "\"CAT\" INTEGER," + // 3: cat
                "\"IS_TRUSTEED\" INTEGER," + // 4: is_trusteed
                "\"SIZE\" REAL," + // 5: size
                "\"NAME\" TEXT," + // 6: name
                "\"DESC\" TEXT," + // 7: desc
                "\"IS_ACTIVE\" INTEGER," + // 8: is_active
                "\"CAMERAS\" TEXT," + // 9: cameras
                "\"METAS\" TEXT);"); // 10: metas
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LAND\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Land entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String farm = entity.getFarm();
        if (farm != null) {
            stmt.bindString(3, farm);
        }
 
        Boolean cat = entity.getCat();
        if (cat != null) {
            stmt.bindLong(4, cat ? 1L: 0L);
        }
 
        Boolean is_trusteed = entity.getIs_trusteed();
        if (is_trusteed != null) {
            stmt.bindLong(5, is_trusteed ? 1L: 0L);
        }
 
        Float size = entity.getSize();
        if (size != null) {
            stmt.bindDouble(6, size);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(7, name);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(8, desc);
        }
 
        Boolean is_active = entity.getIs_active();
        if (is_active != null) {
            stmt.bindLong(9, is_active ? 1L: 0L);
        }
 
        List cameras = entity.getCameras();
        if (cameras != null) {
            stmt.bindString(10, camerasConverter.convertToDatabaseValue(cameras));
        }
 
        List metas = entity.getMetas();
        if (metas != null) {
            stmt.bindString(11, metasConverter.convertToDatabaseValue(metas));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Land entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String farm = entity.getFarm();
        if (farm != null) {
            stmt.bindString(3, farm);
        }
 
        Boolean cat = entity.getCat();
        if (cat != null) {
            stmt.bindLong(4, cat ? 1L: 0L);
        }
 
        Boolean is_trusteed = entity.getIs_trusteed();
        if (is_trusteed != null) {
            stmt.bindLong(5, is_trusteed ? 1L: 0L);
        }
 
        Float size = entity.getSize();
        if (size != null) {
            stmt.bindDouble(6, size);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(7, name);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(8, desc);
        }
 
        Boolean is_active = entity.getIs_active();
        if (is_active != null) {
            stmt.bindLong(9, is_active ? 1L: 0L);
        }
 
        List cameras = entity.getCameras();
        if (cameras != null) {
            stmt.bindString(10, camerasConverter.convertToDatabaseValue(cameras));
        }
 
        List metas = entity.getMetas();
        if (metas != null) {
            stmt.bindString(11, metasConverter.convertToDatabaseValue(metas));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Land readEntity(Cursor cursor, int offset) {
        Land entity = new Land( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // farm
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0, // cat
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // is_trusteed
            cursor.isNull(offset + 5) ? null : cursor.getFloat(offset + 5), // size
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // name
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // desc
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // is_active
            cursor.isNull(offset + 9) ? null : camerasConverter.convertToEntityProperty(cursor.getString(offset + 9)), // cameras
            cursor.isNull(offset + 10) ? null : metasConverter.convertToEntityProperty(cursor.getString(offset + 10)) // metas
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Land entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFarm(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCat(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
        entity.setIs_trusteed(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setSize(cursor.isNull(offset + 5) ? null : cursor.getFloat(offset + 5));
        entity.setName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDesc(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIs_active(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setCameras(cursor.isNull(offset + 9) ? null : camerasConverter.convertToEntityProperty(cursor.getString(offset + 9)));
        entity.setMetas(cursor.isNull(offset + 10) ? null : metasConverter.convertToEntityProperty(cursor.getString(offset + 10)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Land entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Land entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Land entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
