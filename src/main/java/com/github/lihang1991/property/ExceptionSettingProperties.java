package com.github.lihang1991.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 错误拦截配置项
 *
 * @author lih
 * @date  2019-04-23-14:20.
 */
@ConfigurationProperties(prefix = "exception-handle")
public class ExceptionSettingProperties {

    /** 工程名称 **/
    String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
