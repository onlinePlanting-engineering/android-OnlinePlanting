package com.planting.online.onlineplanting.Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.planting.online.onlineplanting.Entity.Converter.CommentConverter;
import com.planting.online.onlineplanting.Entity.Converter.ImageConverter;
import com.planting.online.onlineplanting.Entity.Converter.LandConverter;
import java.util.List;

import com.planting.online.onlineplanting.Entity.Farm;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FARM".
*/
public class FarmDao extends AbstractDao<Farm, Long> {

    public static final String TABLENAME = "FARM";

    /**
     * Properties of entity Farm.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Owner = new Property(3, String.class, "owner", false, "OWNER");
        public final static Property Price = new Property(4, String.class, "price", false, "PRICE");
        public final static Property Subject = new Property(5, String.class, "subject", false, "SUBJECT");
        public final static Property Addr = new Property(6, String.class, "addr", false, "ADDR");
        public final static Property Phone = new Property(7, String.class, "phone", false, "PHONE");
        public final static Property Is_delete = new Property(8, Boolean.class, "is_delete", false, "IS_DELETE");
        public final static Property Notice = new Property(9, String.class, "notice", false, "NOTICE");
        public final static Property Content = new Property(10, String.class, "content", false, "CONTENT");
        public final static Property Home_img_url = new Property(11, String.class, "home_img_url", false, "HOME_IMG_URL");
        public final static Property Comments = new Property(12, String.class, "comments", false, "COMMENTS");
        public final static Property Lands = new Property(13, String.class, "lands", false, "LANDS");
        public final static Property Imgs = new Property(14, String.class, "imgs", false, "IMGS");
    }

    private final CommentConverter commentsConverter = new CommentConverter();
    private final LandConverter landsConverter = new LandConverter();
    private final ImageConverter imgsConverter = new ImageConverter();

    public FarmDao(DaoConfig config) {
        super(config);
    }
    
    public FarmDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FARM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"URL\" TEXT," + // 1: url
                "\"NAME\" TEXT," + // 2: name
                "\"OWNER\" TEXT," + // 3: owner
                "\"PRICE\" TEXT," + // 4: price
                "\"SUBJECT\" TEXT," + // 5: subject
                "\"ADDR\" TEXT," + // 6: addr
                "\"PHONE\" TEXT," + // 7: phone
                "\"IS_DELETE\" INTEGER," + // 8: is_delete
                "\"NOTICE\" TEXT," + // 9: notice
                "\"CONTENT\" TEXT," + // 10: content
                "\"HOME_IMG_URL\" TEXT," + // 11: home_img_url
                "\"COMMENTS\" TEXT," + // 12: comments
                "\"LANDS\" TEXT," + // 13: lands
                "\"IMGS\" TEXT);"); // 14: imgs
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FARM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Farm entity) {
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
 
        String owner = entity.getOwner();
        if (owner != null) {
            stmt.bindString(4, owner);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(5, price);
        }
 
        String subject = entity.getSubject();
        if (subject != null) {
            stmt.bindString(6, subject);
        }
 
        String addr = entity.getAddr();
        if (addr != null) {
            stmt.bindString(7, addr);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(8, phone);
        }
 
        Boolean is_delete = entity.getIs_delete();
        if (is_delete != null) {
            stmt.bindLong(9, is_delete ? 1L: 0L);
        }
 
        String notice = entity.getNotice();
        if (notice != null) {
            stmt.bindString(10, notice);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(11, content);
        }
 
        String home_img_url = entity.getHome_img_url();
        if (home_img_url != null) {
            stmt.bindString(12, home_img_url);
        }
 
        List comments = entity.getComments();
        if (comments != null) {
            stmt.bindString(13, commentsConverter.convertToDatabaseValue(comments));
        }
 
        List lands = entity.getLands();
        if (lands != null) {
            stmt.bindString(14, landsConverter.convertToDatabaseValue(lands));
        }
 
        List imgs = entity.getImgs();
        if (imgs != null) {
            stmt.bindString(15, imgsConverter.convertToDatabaseValue(imgs));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Farm entity) {
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
 
        String owner = entity.getOwner();
        if (owner != null) {
            stmt.bindString(4, owner);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(5, price);
        }
 
        String subject = entity.getSubject();
        if (subject != null) {
            stmt.bindString(6, subject);
        }
 
        String addr = entity.getAddr();
        if (addr != null) {
            stmt.bindString(7, addr);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(8, phone);
        }
 
        Boolean is_delete = entity.getIs_delete();
        if (is_delete != null) {
            stmt.bindLong(9, is_delete ? 1L: 0L);
        }
 
        String notice = entity.getNotice();
        if (notice != null) {
            stmt.bindString(10, notice);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(11, content);
        }
 
        String home_img_url = entity.getHome_img_url();
        if (home_img_url != null) {
            stmt.bindString(12, home_img_url);
        }
 
        List comments = entity.getComments();
        if (comments != null) {
            stmt.bindString(13, commentsConverter.convertToDatabaseValue(comments));
        }
 
        List lands = entity.getLands();
        if (lands != null) {
            stmt.bindString(14, landsConverter.convertToDatabaseValue(lands));
        }
 
        List imgs = entity.getImgs();
        if (imgs != null) {
            stmt.bindString(15, imgsConverter.convertToDatabaseValue(imgs));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Farm readEntity(Cursor cursor, int offset) {
        Farm entity = new Farm( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // owner
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // price
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // subject
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // addr
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // phone
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // is_delete
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // notice
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // content
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // home_img_url
            cursor.isNull(offset + 12) ? null : commentsConverter.convertToEntityProperty(cursor.getString(offset + 12)), // comments
            cursor.isNull(offset + 13) ? null : landsConverter.convertToEntityProperty(cursor.getString(offset + 13)), // lands
            cursor.isNull(offset + 14) ? null : imgsConverter.convertToEntityProperty(cursor.getString(offset + 14)) // imgs
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Farm entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setOwner(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPrice(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSubject(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddr(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPhone(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIs_delete(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setNotice(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setContent(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setHome_img_url(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setComments(cursor.isNull(offset + 12) ? null : commentsConverter.convertToEntityProperty(cursor.getString(offset + 12)));
        entity.setLands(cursor.isNull(offset + 13) ? null : landsConverter.convertToEntityProperty(cursor.getString(offset + 13)));
        entity.setImgs(cursor.isNull(offset + 14) ? null : imgsConverter.convertToEntityProperty(cursor.getString(offset + 14)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Farm entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Farm entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Farm entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
