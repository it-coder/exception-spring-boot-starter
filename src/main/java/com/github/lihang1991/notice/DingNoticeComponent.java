package com.github.lihang1991.notice;

import com.github.lihang1991.dingtalk.DingDingNotice;
import com.github.lihang1991.dingtalk.DingDingResult;
import com.github.lihang1991.entity.ExceptionNotice;
import com.github.lihang1991.property.ExceptionDingtalkProperties;
import com.github.lihang1991.util.SimpleHttpClient;

/**
 * 钉消息组件
 *
 * @author lih
 * @create 2019-06-02-16:55.
 */
public class DingNoticeComponent implements INoticeComponent {

    SimpleHttpClient simpleHttpClient;

    ExceptionDingtalkProperties exceptionDingtalkProperties;

    public DingNoticeComponent(SimpleHttpClient simpleHttpClient, ExceptionDingtalkProperties exceptionDingtalkProperties) {
        this.exceptionDingtalkProperties = exceptionDingtalkProperties;
        this.simpleHttpClient = simpleHttpClient;
    }

    @Override
    public void send(ExceptionNotice exceptionNotice) {
        String[] phone = exceptionDingtalkProperties.getPhone();
        DingDingNotice dingDingNotice = new DingDingNotice(exceptionNotice.createText(), phone);
        DingDingResult result = simpleHttpClient.post(exceptionDingtalkProperties.getWebhook(), dingDingNotice,
                DingDingResult.class);
    }
}
