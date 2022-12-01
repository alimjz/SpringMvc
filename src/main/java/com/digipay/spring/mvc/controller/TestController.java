package com.digipay.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ResponseEntity<String> listAllUsers(){
        return new ResponseEntity<String>("Hi there", HttpStatus.OK);
    }
}
