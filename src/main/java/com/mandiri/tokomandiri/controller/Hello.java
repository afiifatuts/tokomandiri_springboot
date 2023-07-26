package com.mandiri.tokomandiri.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return  "Hello World";
    }

    @GetMapping("/holla")
    public String holla(){
        return "holla";
    }

    //PATH PARAMETER/ PATH VARIABLE
    @GetMapping("/path-var/{var}")
    public String pathVar(@PathVariable String var){
        return  "Valuenya"+var;
    }


}
