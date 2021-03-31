package com.demo20210331.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo20210331.entity.User;
import com.demo20210331.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping("/login")
    public ModelAndView toRegister() {
        return new ModelAndView("login");
    }

    @ResponseBody
    @RequestMapping("/loginHandler")
    public Map<Object, Object> loginHandler(@RequestBody Map<String, String> body) {
        Map<Object, Object> res = new HashMap<>();
        String username = body.get("username");
        String password = body.get("password");

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            res.put("code", 20000);
            res.put("msg", "登录成功");
        } else {
            res.put("code", 50000);
            res.put("msg", "登录失败");
        }
        return res;
    }

}
