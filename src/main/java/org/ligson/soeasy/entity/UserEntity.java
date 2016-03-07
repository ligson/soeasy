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

        public Date getBirth() {
            return birth;
        }

        public void setBirth(Date birth) {
            this.birth = birth;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
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
        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

    @Override
    public String toString() {
        return "UserEntity{" +
               ",birth=" + birth +
               ",name=" + name +
               ",password=" + password +
               ",sex=" + sex +
               ",status=" + status +
               '}';
    }
}
