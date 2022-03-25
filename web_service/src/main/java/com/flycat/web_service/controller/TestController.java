package com.flycat.web_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flying cat
 * @date 2022/3/25 16:04
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
