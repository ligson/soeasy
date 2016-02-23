package org.ligson.soeasy.entity;

import org.ligson.soeasy.biz.core.base.entity.BasicEntity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.lang.String;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Integer;

public class UserEntity extends BasicEntity implements Serializable {
    /***
     *
     */
    private BigInteger id;
    /***
     * 生日
     */
    private Date birth;
    /***
     * 姓名
     */
    private String name;
    /***
     * 密码
     */
    private String password;
    /***
     * 性别
     */
    private Boolean sex;
    /***
     * 状态
     */
    private Integer status;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(BigInteger birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(BigInteger name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(BigInteger password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(BigInteger sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ",birth=" + birth +
                ",name=" + name +
                ",password=" + password +
                ",sex=" + sex +
                ",status=" + status +
                '}';
    }
}
