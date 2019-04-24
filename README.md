# 错误自动通知starter

## 使用

> 该jar正在申请发布到中央仓库(地址待完善)

+ maven引用
``` xml
<dependency>
    <groupId>com.github.lihang1991</groupId>
    <artifactId>exception-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

+ 配置

``` yml
exception-handle:
  project-name: com.lihang.exception.client ## 工程名称
  email:
    from: ceshi@163.com # 发送邮箱
    to:
      - ceshi@139.com # 发送到(支持list)
    cc:
      - ceshi@139.com # 抄送(支持list)
spring:
  mail:
    host: smtp.163.com
    port: 25
    password: ceshi123456
    username: ceshi@163.com
```

``` java
@SpringBootApplication
// 切面
@EnableExceptionHandle(value = "execution(* com.lihang.exception.client.controller.*.*(..))")
public class ExceptionCilentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionCilentApplication.class, args);
    }
}

```

## 结果展示

![](https://ws1.sinaimg.cn/large/006ktDSkly1g2e0myqylzj30qi0bxtac.jpg)

## 计划

- 支持钉钉消息通知