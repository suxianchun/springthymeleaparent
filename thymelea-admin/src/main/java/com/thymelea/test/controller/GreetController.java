package com.thymelea.test.controller;

import com.thymelea.test.service.UserService;
import com.winter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/greet")
public class GreetController {

    @Autowired
    private UserService userService;

    @RequestMapping("/greeting")
    public String greet()
    {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "add",produces = {"application/json;charset=UTF-8"})
    public int addUser(User user)
    {
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
}
