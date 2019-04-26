package com.github.lihang1991.property;

import java.util.Arrays;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 邮件配置属性读取
 *
 *  stmp.host、port、username、password通过spring-boot-starter-mail配置
 * @author lih
 * @date 2019-04-20-9:34.
 */
@ConfigurationProperties(prefix = "exception-handle.email")
public class ExceptionEmailProperties {

    /** 发件人 **/
    String from;
    /** 发送给 **/
    String[] to;
    /** 抄送 **/
    String[] cc;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "ExceptionEmailProperties{" +
                "from='" + from + '\'' +
                ", to=" + Arrays.toString(to) +
                ", cc=" + Arrays.toString(cc) +
                '}';
    }
}
