package com.planting.online.onlineplanting.Entity;

import com.planting.online.onlineplanting.Dao.DaoSession;
import com.planting.online.onlineplanting.Dao.ProfileDao;
import com.planting.online.onlineplanting.Dao.UserDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by eleven on 2017/9/1.
 */

@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String username;

    private Long profileID;

    @ToOne(joinProperty = "profileID")
    Profile profile;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 71388887)
    private transient Long profile__resolvedKey;

    public User(String username, Long profileID, Profile profile) {
        this.username = username;
        this.profileID = profileID;
        this.profile = profile;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    @Generated(hash = 2041531443)
    public User(Long id, String username, Long profileID) {
        this.id = id;
        this.username = username;
        this.profileID = profileID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getProfileID() {
        return profileID;
    }

    public void setProfileID(Long profileID) {
        this.profileID = profileID;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 2080799757)
    public Profile getProfile() {
        Long __key = this.profileID;
        if (profile__resolvedKey == null || !profile__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProfileDao targetDao = daoSession.getProfileDao();
            Profile profileNew = targetDao.load(__key);
            synchronized (this) {
                profile = profileNew;
                profile__resolvedKey = __key;
            }
        }
        return profile;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1327540569)
    public void setProfile(Profile profile) {
        synchronized (this) {
            this.profile = profile;
            profileID = profile == null ? null : profile.getId();
            profile__resolvedKey = profileID;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
