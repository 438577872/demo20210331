package com.demo20210331.controller;

import com.demo20210331.entity.User;
import com.demo20210331.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping("/")
    public ModelAndView toIndex() {
        return new ModelAndView("home");
    }

    @ResponseBody
    @RequestMapping("/home/list")
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 20000);
        List<User> users = userMapper.selectList(null);
        map.put("list", users);
        return map;


    }
}
