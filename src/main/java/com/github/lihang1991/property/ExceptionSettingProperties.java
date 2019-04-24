package com.github.lihang1991.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 错误拦截配置项
 *
 * @author lih
 * @create 2019-04-23-14:20.
 */
@ConfigurationProperties(prefix = "exception-handle")
@Getter
@Setter
@ToString
public class ExceptionSettingProperties {

    /** 工程名称 **/
    String projectName;
}
