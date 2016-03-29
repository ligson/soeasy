package org.ligson.se.api.dto;

import org.ligson.fw.facade.base.dto.BaseRequestDto;

import java.util.Date;

/**
 * Created by ligson on 2016/3/28.
 */
public class RegisterRequestDto extends BaseRequestDto {
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
     * 手机号
     */
    private String mobile;

    /***
     * 邮箱
     */
    private String email;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegisterRequestDto{" +
                "birth=" + birth +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
