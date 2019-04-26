package com.github.lihang1991.handle;

import com.github.lihang1991.entity.ExceptionNotice;
import com.github.lihang1991.notice.EmailNoticeComponent;
import com.github.lihang1991.property.ExceptionSettingProperties;

/**
 * 错误消息处理
 *
 * @author lih
 * @date 2019-04-20-10:12.
 */
public class ExceptionHandler {

    private EmailNoticeComponent emailNoticeComponent;

    private ExceptionSettingProperties exceptionSettingProperties;

    public ExceptionHandler(EmailNoticeComponent emailNoticeComponent, ExceptionSettingProperties exceptionSettingProperties) {
        this.emailNoticeComponent = emailNoticeComponent;
        this.exceptionSettingProperties = exceptionSettingProperties;
    }

    public boolean createNotice(Throwable ex, String method, Object[] args) {
        ExceptionNotice exceptionNotice = new ExceptionNotice(ex,args, exceptionSettingProperties.getProjectName());
        messageSend(exceptionNotice);
        return true;
    }

    private void messageSend(ExceptionNotice exceptionNotice) {
        emailNoticeComponent.send(exceptionNotice);
    }
}
