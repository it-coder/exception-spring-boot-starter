package com.github.lihang1991.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;

/**
 *  钉钉配置文件
 * @author lih
 * @create 2019-06-02-17:00.
 */
@ConfigurationProperties(prefix = "exception-handle.dingtalk")
public class ExceptionDingtalkProperties {

    String[] phone;

    String webhook;

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    @Override
    public String toString() {
        return "ExceptionDingtalkProperties{" +
                "phone=" + Arrays.toString(phone) +
                ", webhook='" + webhook + '\'' +
                '}';
    }
}
