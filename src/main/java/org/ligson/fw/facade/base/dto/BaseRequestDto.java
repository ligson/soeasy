package org.ligson.fw.facade.base.dto;

/**
 * 请求实体基础类
 */
@SuppressWarnings("serial")
public class BaseRequestDto extends BaseDto {
    /**
     * 版本号
     */
    private String version;
    /**
     * 字符集
     */
    private String charset;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public String toString() {
        return "BaseRequestDto{" +
                "version='" + version + '\'' +
                ", charset='" + charset + '\'' +
                '}';
    }
}
