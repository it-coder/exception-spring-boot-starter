package com.github.lihang1991.handle;

import com.github.lihang1991.entity.ExceptionNotice;
import com.github.lihang1991.notice.EmailNoticeComponent;
import com.github.lihang1991.property.ExceptionSettingProperties;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 错误消息处理
 *
 * @author lih
 * @date 2019-04-20-10:12.
 */
public class ExceptionHandler {

    private EmailNoticeComponent emailNoticeComponent;

    private ExceptionSettingProperties exceptionSettingProperties;

    private Set<String> UNIQUE_CHECK = Collections.synchronizedSet(new HashSet<>());

    public ExceptionHandler(EmailNoticeComponent emailNoticeComponent, ExceptionSettingProperties exceptionSettingProperties) {
        this.emailNoticeComponent = emailNoticeComponent;
        this.exceptionSettingProperties = exceptionSettingProperties;
    }

    public boolean createNotice(Throwable ex, String method, Object[] args) {
        ExceptionNotice exceptionNotice = new ExceptionNotice(ex, args, exceptionSettingProperties.getProjectName());

        messageSend(exceptionNotice);

        return true;
    }

    private void messageSend(ExceptionNotice exceptionNotice) {
        boolean notExit = checkCacheStore(exceptionNotice);
        // 已发送过的错误不再发送
        if (notExit) {
            emailNoticeComponent.send(exceptionNotice);
        }
    }


    private void cacheStore(String uid) {
        this.UNIQUE_CHECK.add(uid);
    }

    private boolean checkCacheStore(ExceptionNotice exceptionNotice) {
        String uid = exceptionNotice.getUid();
        boolean notExit = !this.UNIQUE_CHECK.contains(uid);
        if (notExit) { //不存在
            // 缓存错误信息
            cacheStore(uid);
        }
        return notExit;
    }
}
