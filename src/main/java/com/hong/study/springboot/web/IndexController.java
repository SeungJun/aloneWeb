package com.hong.study.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 머스테치 URL 매핑
@Controller
public class IndexController {
    @GetMapping("/")
    public  String index(){
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
