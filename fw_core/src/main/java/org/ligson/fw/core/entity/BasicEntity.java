package org.ligson.fw.core.entity;

import java.math.BigInteger;

/**
 * Created by ligso on 2016/1/27.
 * 基本类
 *
 * @author ligson
 */
//@SuppressWarnings("unused")
public class BasicEntity extends BasePageDto {

    /***
     * 是否要分页
     */
    private Boolean pageAble = true;

    /***
     * 排序字段
     */
    private String sort = "id";

    /***
     * 排序顺序
     */
    private String order = "ASC";

    public Boolean getPageAble() {
        return pageAble;
    }

    public void setPageAble(Boolean pageAble) {
        this.pageAble = pageAble;
    }

    /***
     * 主键字段
     *
     * @return 主键名
     */
    public String primaryKey() {
        return "id";
    }

    /***
     * 主键类型
     *
     * @return 主键类型
     */
    public Class primaryKeyType() {
        return BigInteger.class;
    }
}
