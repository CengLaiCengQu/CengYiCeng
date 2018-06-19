package com.example.rubrub.EntityClass;

import cn.bmob.v3.BmobObject;

/**
 * Created by wx‘mac pro on 2018/6/8.
 */

public class MyClass extends BmobObject {
    //private String objectId;
    private String Uname;
    private String Cnumber;
    private String college;
    private String Cplace;
    private Number Credit;
    private String Ctime;
    private String KCname;
    private String Password;
    private String Semester;
    private String Tname;
    private String type;
    private String Uid;
    private String Bookname;

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        this.Uname = uname;
    }

    public String getCnumber() {
        return Cnumber;
    }

    public void setCnumber(String cnumber) {
        this.Cnumber = cnumber;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCplace() {
        return Cplace;
    }

    public void setCplace(String cplace) {
        this.Cplace = cplace;
    }

    public Number getCredit() {
        return Credit;
    }

    public void setCredit(Number credit) {
        Credit = credit;
    }

    public String getCtime() {
        return Ctime;
    }

    public void setCtime(String ctime) {
        this.Ctime = ctime;
    }

    public String getKCname() {
        return KCname;
    }

    public void setKCname(String KCname) {
        this.KCname = KCname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        this.Semester = semester;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        this.Tname = tname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        this.Uid = uid;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        this.Bookname = bookname;
    }
}
