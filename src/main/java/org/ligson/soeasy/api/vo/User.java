package org.ligson.soeasy.api.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by ligson on 2016/3/28.
 */
public class User implements Serializable {
    /***
     * id
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

    /***
     * 手机号
     */
    private String mobile;

    /***
     * 邮箱
     */
    private String email;


    /***
     * 获取id
     *
     * @return 获取id
     */
    public BigInteger getId() {
        return id;
    }

    /***
     * 设置id
     *
     * @param id id
     */
    public void setId(BigInteger id) {
        this.id = id;
    }

    /***
     * 获取生日
     *
     * @return 获取生日
     */
    public Date getBirth() {
        return birth;
    }

    /***
     * 设置生日
     *
     * @param birth 生日
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /***
     * 获取姓名
     *
     * @return 获取姓名
     */
    public String getName() {
        return name;
    }

    /***
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * 获取密码
     *
     * @return 获取密码
     */
    public String getPassword() {
        return password;
    }

    /***
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /***
     * 获取性别
     *
     * @return 获取性别
     */
    public Boolean getSex() {
        return sex;
    }

    /***
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /***
     * 获取状态
     *
     * @return 获取状态
     */
    public Integer getStatus() {
        return status;
    }

    /***
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /***
     * 获取手机号
     *
     * @return 获取手机号
     */
    public String getMobile() {
        return mobile;
    }

    /***
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /***
     * 获取邮箱
     *
     * @return 获取邮箱
     */
    public String getEmail() {
        return email;
    }

    /***
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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

                ",mobile=" + mobile +

                ",email=" + email +
                '}';
    }
}
