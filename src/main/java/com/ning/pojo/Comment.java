package com.ning.pojo;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    @Id
    @Column(name = "commentId")
    private String commentid;

    @Column(name = "commentusernameId")
    private String commentusernameid;

    private String commentcontent;

    @Column(name = "commentTime")
    private Date commenttime;

    @Column(name = "commentCourseId")
    private String commentcourseid;

    @Column(name = "commentDZ")
    private String commentdz;

    @Column(name = "commentStatus")
    private Boolean commentstatus;

    private String commentusername;

    /**
     * @return commentId
     */
    public String getCommentid() {
        return commentid;
    }

    /**
     * @param commentid
     */
    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    /**
     * @return commentusernameId
     */
    public String getCommentusernameid() {
        return commentusernameid;
    }

    /**
     * @param commentusernameid
     */
    public void setCommentusernameid(String commentusernameid) {
        this.commentusernameid = commentusernameid;
    }

    /**
     * @return commentcontent
     */
    public String getCommentcontent() {
        return commentcontent;
    }

    /**
     * @param commentcontent
     */
    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    /**
     * @return commentTime
     */
    public Date getCommenttime() {
        return commenttime;
    }

    /**
     * @param commenttime
     */
    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    /**
     * @return commentCourseId
     */
    public String getCommentcourseid() {
        return commentcourseid;
    }

    /**
     * @param commentcourseid
     */
    public void setCommentcourseid(String commentcourseid) {
        this.commentcourseid = commentcourseid;
    }

    /**
     * @return commentDZ
     */
    public String getCommentdz() {
        return commentdz;
    }

    /**
     * @param commentdz
     */
    public void setCommentdz(String commentdz) {
        this.commentdz = commentdz;
    }

    /**
     * @return commentStatus
     */
    public Boolean getCommentstatus() {
        return commentstatus;
    }

    /**
     * @param commentstatus
     */
    public void setCommentstatus(Boolean commentstatus) {
        this.commentstatus = commentstatus;
    }

    /**
     * @return commentusername
     */
    public String getCommentusername() {
        return commentusername;
    }

    /**
     * @param commentusername
     */
    public void setCommentusername(String commentusername) {
        this.commentusername = commentusername;
    }
}