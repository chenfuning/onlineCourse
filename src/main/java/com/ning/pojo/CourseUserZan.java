package com.ning.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "course_user_zan")
public class CourseUserZan {
    @Id
    private String courseid;

    @Id
    private String userid;

    private Boolean status;

    private Date createtime;

    /**
     * @return courseid
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * @param courseid
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * @return userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}