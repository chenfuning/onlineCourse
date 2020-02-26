package com.ning.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "course_sort")
public class CourseSort {
    @Id
    private String csid;

    private String name;

    private Byte code;

    @Column(name = "parent_code")
    private Byte parentCode;

    private Date createtime;

    private Date updatetime;

    private String updateuser;

    /**
     * @return csid
     */
    public String getCsid() {
        return csid;
    }

    /**
     * @param csid
     */
    public void setCsid(String csid) {
        this.csid = csid;
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
     * @return code
     */
    public Byte getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(Byte code) {
        this.code = code;
    }

    /**
     * @return parent_code
     */
    public Byte getParentCode() {
        return parentCode;
    }

    /**
     * @param parentCode
     */
    public void setParentCode(Byte parentCode) {
        this.parentCode = parentCode;
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