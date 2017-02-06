package com.scott.lee.user.controller;

import com.scott.lee.base.JSONResult;
import com.scott.lee.user.reponsitory.entity.User;
import com.scott.lee.user.reponsitory.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * Created by Scott on 2017/1/17.
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", description = "UserController")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value="/findall",  method=RequestMethod.GET)
    @ApiOperation(value = "查询所有人员", notes = "分页查询所有人员")
    public @ResponseBody JSONResult<Page<User>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                           @RequestParam(value = "size", defaultValue = "15") Integer size){
        Pageable pageable = new PageRequest(page, size);
        JSONResult<Page<User>> result = new JSONResult<>();
        result.setData(userRepository.findAll(pageable));
        return result;
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    @ApiOperation(value = "查询人员信息信息",notes = "根据ID查询人员详细信息")
    public @ResponseBody
    JSONResult<User> findUserById(@PathVariable("id")String id){
        JSONResult<User> result = new JSONResult<>();
        result.setData(userRepository.findOne(id));
        return result ;
    }

    @RequestMapping(value = "/findByUserNameContains/{userName}", method = RequestMethod.GET)
    @ApiOperation(value = "人员查询", notes = "根据人员名称查询人员详细信息")
    public
    @ResponseBody
    Page<User> getUser(@PathVariable("userName") String userName,
                       @RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "15") Integer size) {

        logger.info("userName", userName);
        Pageable pageable = new PageRequest(page, size);
        return userRepository.findByUsernameContains(userName,pageable);
    }


    @RequestMapping(value="/save",  method=RequestMethod.POST)
    @ApiOperation(value = "新增人员", notes = "新增人员")
    public @ResponseBody User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }



    @RequestMapping(value="/{id}",  method=RequestMethod.DELETE)
    @ApiOperation(value = "删除人员",notes = "删除人员")
    public void deleteUser(@PathVariable("id")String id){
        userRepository.delete(id);
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.PATCH)
    @ApiOperation(value = "编辑人员",notes = "编辑人员")
    public @ResponseBody User updateUser(@PathVariable("id")String id,@RequestBody User user){
        user.setId(id);
        return userRepository.save(user);

    }

}
