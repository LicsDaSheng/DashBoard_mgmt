package com.scott.lee.user;

import com.scott.lee.user.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 * Created by Scott on 2017/1/17.
 */
@RestController
@RequestMapping("/api/login")
@Api(value = "登录接口", description = "LoginController")
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    User login(@RequestBody User user){
        return user;
    }
}
