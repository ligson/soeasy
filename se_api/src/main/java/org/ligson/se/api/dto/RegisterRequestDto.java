package org.ligson.se.api.dto;

import org.ligson.fw.core.facade.base.dto.BaseRequestDto;
import org.ligson.fw.core.facade.annotation.Param;

import java.util.Date;

/**
 * Created by ligson on 2016/3/28.
 */
public class RegisterRequestDto extends BaseRequestDto {
    /***
     * 生日
     */
    @Param(name = "生日", required = false)
    private Date birth;

    /***
     * 姓名
     */
    @Param(name = "姓名", required = false, minLen = 2, maxLen = 20)
    private String name;

    /***
     * 密码
     */
    @Param(name = "密码", required = true)
    private String password;

    /***
     * 性别
     */
    @Param(name = "性别", required = false)
    private Boolean sex;

    /***
     * 手机号
     */
    @Param(name = "手机号", required = false, mobile = true)
    private String mobile;

    /***
     * 邮箱
     */
    @Param(name = "邮箱", required = false, email = true)
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
