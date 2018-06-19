package com.example.rubrub.EntityClass;

import cn.bmob.v3.BmobObject;

/**
 * Created by wx‘mac pro on 2018/6/8.
 */

public class ScheduleClass extends BmobObject {
  //  private transient String objectId;
    private String Semester;
    private String Cname;
    private String Cnumber;
    private String College;
    private String Cplace;
    private Number Credit;
    private String Cteacher;
    private String Ctime;
    private String Ctype;
    private String Bookname;

    public String getCname(){
        return Cname;
    }

    public String getSemester() {
        return Semester;
    }

    public String getCnumber(){
        return Cnumber;
    }

    public String getCollege() {
        return College;
    }

    public String getCplace() {
        return Cplace;
    }

    public Number getCredit() {
        return Credit;
    }

    public String getCteacher() {
        return Cteacher;
    }

    public String getCtime() {
        return Ctime;
    }

    public String getCtype() {
        return Ctype;
    }

    public String getBookname(){
        return Bookname;
    }
}
