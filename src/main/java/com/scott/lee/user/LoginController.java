package com.scott.lee.user;

import com.scott.lee.base.JSONResult;
import com.scott.lee.user.entity.User;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 * Created by Scott on 2017/1/17.
 */
@RestController
@Api(value = "登录接口", description = "LoginController")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    JSONResult<User> login(@RequestBody User user){
        logger.info("UserController.login()");
        //登录失败从request中获取shiro处理的异常信息
        // shiroLoginFailure:就是shiro异常类的全类名.
        //String exception = (String) request.getAttribute("shiroLoginFailure");
        String userName = user.getUsername();

        JSONResult<User> result = new JSONResult<>();

        //开始调用shiro验证
        UsernamePasswordToken token = new UsernamePasswordToken(userName,user.getPassword(),"login");
        //获取当前的subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.info("对用户[" + userName + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + userName + "]进行登录验证..验证通过");
        }catch(UnknownAccountException uae){
            logger.warn("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
            result.setSuccess(false);
            result.setMessage("未知账户");
            return result;
        }catch(IncorrectCredentialsException ice){
            logger.warn("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
            result.setSuccess(false);
            result.setMessage( "密码不正确");
            return result;
        }catch(LockedAccountException lae){
            logger.warn("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
            result.setSuccess(false);
            result.setMessage( "账户已锁定");
            return result;
        }catch(ExcessiveAttemptsException eae){
            logger.warn("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
            result.setSuccess(false);
            result.setMessage("用户名或密码错误次数过多");
            return result;
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.warn("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            result.setSuccess(false);
            result.setMessage("用户名或密码不正确");
            return result;
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            logger.info("用户[" + userName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            User loginUser = userRepository.findByUsername((String)SecurityUtils.getSubject().getPrincipal());
            result.setData(loginUser);
            result.setSuccess(true);
            result.setMessage("登录成功");
            return result;
        }else{
            token.clear();
            result.setSuccess(false);
            result.setMessage( "登录失败,未知错误");
            return result;
        }
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public @ResponseBody
    JSONResult logout(){
        SecurityUtils.getSubject().logout();
        return new JSONResult("您已安全退出");
    }
}
