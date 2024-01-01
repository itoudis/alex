package com.itoudis.alex;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    TestResponse test(String throwException) {
        if (throwException.equals("throw")) throw new RuntimeException("testException");
        return new TestResponse("test!!!!!");
    }
}