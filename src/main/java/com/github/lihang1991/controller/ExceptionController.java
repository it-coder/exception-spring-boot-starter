package com.github.lihang1991.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lih
 * @date 2019-04-19-19:18.
 */
@Controller
@RequestMapping
public class ExceptionController {

    @GetMapping("err")
    @ResponseBody
    public Object exce() {
        int i = 1/0;
        return "error";
    }
}
