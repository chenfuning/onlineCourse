package com.ning.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "course_zj")
public class CourseZj {
    @Id
    private String zid;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "parent_id")
    private String parentId;

    private String name;

    private Byte sort;

    private String timelong;

    @Column(name = "video_url")
    private String videoUrl;

    private Date createtime;

    private Date updatetime;

    private Date updateuser;

    private String updatecontent;

    /**
     * @return zid
     */
    public String getZid() {
        return zid;
    }

    /**
     * @param zid
     */
    public void setZid(String zid) {
        this.zid = zid;
    }

    /**
     * @return course_id
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sort
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * @return timelong
     */
    public String getTimelong() {
        return timelong;
    }

    /**
     * @param timelong
     */
    public void setTimelong(String timelong) {
        this.timelong = timelong;
    }

    /**
     * @return video_url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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
     * @return updatetime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return updateuser
     */
    public Date getUpdateuser() {
        return updateuser;
    }

    /**
     * @param updateuser
     */
    public void setUpdateuser(Date updateuser) {
        this.updateuser = updateuser;
    }

    /**
     * @return updatecontent
     */
    public String getUpdatecontent() {
        return updatecontent;
    }

    /**
     * @param updatecontent
     */
    public void setUpdatecontent(String updatecontent) {
        this.updatecontent = updatecontent;
    }
}