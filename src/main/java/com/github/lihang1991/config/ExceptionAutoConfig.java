package com.github.lihang1991.config;

import com.github.lihang1991.handle.ExceptionHandler;
import com.github.lihang1991.notice.DingNoticeComponent;
import com.github.lihang1991.notice.EmailNoticeComponent;
import com.github.lihang1991.property.ExceptionDingtalkProperties;
import com.github.lihang1991.property.ExceptionEmailProperties;
import com.github.lihang1991.property.ExceptionSettingProperties;
import com.github.lihang1991.util.SimpleHttpClient;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;


/**
 *  自动装配
 * @author lih
 * @date 2019-04-20-9:31.
 */
@Configuration
// 自动装载配置属性
@EnableConfigurationProperties({ ExceptionEmailProperties.class, ExceptionSettingProperties.class, ExceptionDingtalkProperties.class})
@ConditionalOnBean(name = { "exceptionAspect" })
public class ExceptionAutoConfig {

    @Bean
    @ConditionalOnBean(name = { "exceptionAspect" })
    @ConditionalOnProperty(prefix = "exception-handle.email", name = "from")
    public EmailNoticeComponent emailNoticeComponent(MailSender mailSender, MailProperties mailProperties, ExceptionEmailProperties exceptionEmailProperties) {
        return new EmailNoticeComponent(mailSender, mailProperties, exceptionEmailProperties);
    }

    @Bean
    @ConditionalOnBean(name = { "exceptionAspect" })
    public ExceptionHandler exceptionHandler(EmailNoticeComponent emailNoticeComponent, ExceptionSettingProperties exceptionSettingProperties) {
        ExceptionHandler exceptionHandler = new ExceptionHandler(emailNoticeComponent, exceptionSettingProperties);
        return exceptionHandler;
    }

    @Bean
    @ConditionalOnBean(name = { "exceptionAspect" })
    @ConditionalOnProperty(prefix = "exception-handle.dingtalk", name = "webhook")
    public DingNoticeComponent dingNoticeComponent(SimpleHttpClient simpleHttpClient, ExceptionDingtalkProperties exceptionDingtalkProperties) {
        return new DingNoticeComponent(simpleHttpClient, exceptionDingtalkProperties);
    }

    @Bean
    @ConditionalOnBean(name = { "exceptionAspect" })
    @ConditionalOnProperty(prefix = "exception-handle.dingtalk", name = "webhook")
    public SimpleHttpClient simpleHttpClient(Gson gson) {
        return new SimpleHttpClient(gson);
    }
}
