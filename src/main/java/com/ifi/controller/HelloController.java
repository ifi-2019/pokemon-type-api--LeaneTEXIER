package com.ifi.controller;

import com.ifi.servlet.Controller;
import com.ifi.servlet.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(uri="/hello")
    public String sayHello(){
        return "Hello World !";
    }

    @RequestMapping(uri="/bye")
    public String sayGoodBye(){
        return "Goodbye !";
    }

    @RequestMapping(uri="/boum")
    public String explode(){
        throw new RuntimeException("Explosion !");
    }

}