package com.github.lihang1991.notice;

import com.github.lihang1991.entity.ExceptionNotice;

/**
 *
 * @author lih
 * @create 2019-06-02-17:07.
 */
public interface INoticeComponent {

    void send(ExceptionNotice exceptionNotice);
}
