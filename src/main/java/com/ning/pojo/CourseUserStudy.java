package com.ning.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "course_user_study")
public class CourseUserStudy {
    @Id
    @Column(name = "courseId")
    private String courseid;

    @Id
    @Column(name = "userId")
    private String userid;

    private Date createtime;

    private String studyzhang;

    private String studyjie;

    @Column(name = "studytoTime")
    private String studytotime;

    private String studybz;

    /**
     * @return courseId
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
     * @return userId
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

    /**
     * @return studyzhang
     */
    public String getStudyzhang() {
        return studyzhang;
    }

    /**
     * @param studyzhang
     */
    public void setStudyzhang(String studyzhang) {
        this.studyzhang = studyzhang;
    }

    /**
     * @return studyjie
     */
    public String getStudyjie() {
        return studyjie;
    }

    /**
     * @param studyjie
     */
    public void setStudyjie(String studyjie) {
        this.studyjie = studyjie;
    }

    /**
     * @return studytoTime
     */
    public String getStudytotime() {
        return studytotime;
    }

    /**
     * @param studytotime
     */
    public void setStudytotime(String studytotime) {
        this.studytotime = studytotime;
    }

    /**
     * @return studybz
     */
    public String getStudybz() {
        return studybz;
    }

    /**
     * @param studybz
     */
    public void setStudybz(String studybz) {
        this.studybz = studybz;
    }
}