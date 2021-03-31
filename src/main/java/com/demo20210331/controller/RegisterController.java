package com.demo20210331.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo20210331.entity.User;
import com.demo20210331.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping("/register")
    public ModelAndView toRegister() {
        return new ModelAndView("register");
    }

    @ResponseBody
    @RequestMapping("/registerHandler")
    public Map<Object, Object> registerHandler(@RequestBody Map<String, String> body) {
        Map<Object, Object> res = new HashMap<>();
//        res.put("code", 50000);
        String username = body.get("username");
        String password = body.get("password");
        if (username.length()<=5 || username.length()>=20){
            res.put("code", 50000);
            res.put("msg", "用户名过长或者过短");
            return res;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            res.put("code", 50000);
            res.put("msg", "注册失败，用户已存在");
        } else {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.insert(user);
            res.put("code", 20000);
            res.put("msg", "注册成功");
        }
        return res;
    }

}
