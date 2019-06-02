package com.github.lihang1991;

import com.github.lihang1991.dingtalk.DingDingNotice;
import com.github.lihang1991.dingtalk.DingDingResult;
import com.github.lihang1991.util.SimpleHttpClient;
import com.google.gson.Gson;

/**
 * @author lih
 * @create 2019-05-31-10:58.
 */
public class DingNoticeTest {
    public static void main(String[] args) {
        DingDingNotice dingDingNotice = new DingDingNotice("测试@消息", "");

        SimpleHttpClient simpleHttpClient = new SimpleHttpClient(new Gson());
        DingDingResult result = simpleHttpClient.post("https://oapi.dingtalk.com/robot/send?access_token=d89e28c75ff21466c25f0c267e8b73ac5afdf8be1fbb618885418ab39c5eb5e3", dingDingNotice,
                DingDingResult.class);
        System.out.println(result.toString());
    }
}
