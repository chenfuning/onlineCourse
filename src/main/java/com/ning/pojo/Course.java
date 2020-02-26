package com.ning.pojo;

import java.util.Date;
import javax.persistence.*;

public class Course {
    @Id
    private String cid;

    private String name;

    private String type;

    private String classify;

    private String username;

    private String level;

    private String onsole;

    private String brief;

    private String imgurl;

    private String imgbigurl;

    private Byte recommerd;

    private Date createtime;

    private Date updatetime;

    private String updateuser;

    /**
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid;
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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return classify
     */
    public String getClassify() {
        return classify;
    }

    /**
     * @param classify
     */
    public void setClassify(String classify) {
        this.classify = classify;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return onsole
     */
    public String getOnsole() {
        return onsole;
    }

    /**
     * @param onsole
     */
    public void setOnsole(String onsole) {
        this.onsole = onsole;
    }

    /**
     * @return brief
     */
    public String getBrief() {
        return brief;
    }

    /**
     * @param brief
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * @return imgurl
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * @param imgurl
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * @return imgbigurl
     */
    public String getImgbigurl() {
        return imgbigurl;
    }

    /**
     * @param imgbigurl
     */
    public void setImgbigurl(String imgbigurl) {
        this.imgbigurl = imgbigurl;
    }

    /**
     * @return recommerd
     */
    public Byte getRecommerd() {
        return recommerd;
    }

    /**
     * @param recommerd
     */
    public void setRecommerd(Byte recommerd) {
        this.recommerd = recommerd;
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
    public String getUpdateuser() {
        return updateuser;
    }

    /**
     * @param updateuser
     */
    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }
}