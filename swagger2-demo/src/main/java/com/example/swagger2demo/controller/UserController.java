package com.example.swagger2demo.controller;

import com.example.swagger2demo.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    //为了使线程安全，能够接受高并发，这里使用ConcurrentHashMap，小伙伴可以百度一下具体深入一下
    static Map<Long , User> map = new ConcurrentHashMap<>();
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> getList() {
        List<User> list = new ArrayList<>(map.values());
        return  list;
    }
    @ApiOperation(value = "创建用户" , notes = "根据user对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详情实体类",required = true,dataType = "User")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        map.put(user.getId(),user);
        return "添加成功~~~";
    }


}
