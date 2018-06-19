package com.example.rubrub.EntityClass;

import java.io.Serializable;
import java.util.Date;

import cn.bmob.v3.BmobObject;

/**
 * Created by wx‘mac pro on 2018/6/8.
 */

public class BlogClass extends BmobObject implements Serializable{
   // private transient String objectId;
    private String Uname;
    private String Uid;
    private Date time;
    private String MicroBlog;

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        this.Uname = uname;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        this.Uid = uid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMicroBlog() {
        return MicroBlog;
    }

    public void setMicroBlog(String microBlog) {
        this.MicroBlog = microBlog;
    }
}
