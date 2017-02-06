package com.scott.lee.project.contorller;

import com.scott.lee.base.JSONResult;
import com.scott.lee.project.reponsitory.StoryRepository;
import com.scott.lee.project.reponsitory.entity.Project;
import com.scott.lee.project.reponsitory.entity.Story;
import com.scott.lee.user.controller.LoginController;
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
 * 项目Controller
 * Created by Scott on 2017/1/24.
 */
@RestController
@RequestMapping("/story")
@Api(value = "项目接口", description = "ProjectController")
public class StoryController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    StoryRepository storyRepository;

    @RequestMapping(value="/findall",  method= RequestMethod.GET)
    @ApiOperation(value = "查询所有项目", notes = "分页查询所有人员")
    public @ResponseBody
    JSONResult<Page<Story>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "15") Integer size){
        Pageable pageable = new PageRequest(page, size);
        JSONResult<Page<Story>> result = new JSONResult<>();
        result.setData(storyRepository.findAll(pageable));
        return result;
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    @ApiOperation(value = "根据项目ID查询项目详细",notes = "根据项目ID查询项目详细")
    public @ResponseBody
    JSONResult<Story> findStoryById(@PathVariable("id")String id){
        JSONResult<Story> result = new JSONResult<>();
        result.setData(storyRepository.findOne(id));
        return result ;
    }

    @RequestMapping(value="/save",  method=RequestMethod.POST)
    @ApiOperation(value = "新增项目", notes = "新增项目")
    public @ResponseBody Story saveStory(@RequestBody Story story) {
        return storyRepository.save(story);
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.PATCH)
    @ApiOperation(value = "更新项目",notes = "更新项目")
    public @ResponseBody Story updateStory(@PathVariable("id")String id,@RequestBody Story story){
        story.setId(id);
        return storyRepository.save(story);
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.DELETE)
    @ApiOperation(value = "删除产品",notes = "删除产品")
    public void deleteStory(@PathVariable("id")String id){
        storyRepository.delete(id);
    }


}
