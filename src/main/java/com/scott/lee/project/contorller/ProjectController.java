package com.scott.lee.project.contorller;

import com.scott.lee.base.JSONResult;
import com.scott.lee.project.reponsitory.ProjectRepository;
import com.scott.lee.project.reponsitory.entity.Project;
import com.scott.lee.user.controller.LoginController;
import com.scott.lee.user.reponsitory.entity.User;
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
@RequestMapping("/project")
@Api(value = "项目接口", description = "ProjectController")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value="/findall",  method= RequestMethod.GET)
    @ApiOperation(value = "查询所有项目", notes = "分页查询所有人员")
    public @ResponseBody
    JSONResult<Page<Project>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "15") Integer size){
        Pageable pageable = new PageRequest(page, size);
        JSONResult<Page<Project>> result = new JSONResult<>();
        result.setData(projectRepository.findAll(pageable));
        return result;
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    @ApiOperation(value = "根据项目ID查询项目详细",notes = "根据项目ID查询项目详细")
    public @ResponseBody
    JSONResult<Project> findProjectById(@PathVariable("id")String id){
        JSONResult<Project> result = new JSONResult<>();
        result.setData(projectRepository.findOne(id));
        return result ;
    }

    @RequestMapping(value="/save",  method=RequestMethod.POST)
    @ApiOperation(value = "新增项目", notes = "新增项目")
    public @ResponseBody Project saveProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.PATCH)
    @ApiOperation(value = "更新项目",notes = "更新项目")
    public @ResponseBody Project updateProject(@PathVariable("id")String id,@RequestBody Project project){
        project.setId(id);
        return projectRepository.save(project);
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.DELETE)
    @ApiOperation(value = "删除产品",notes = "删除产品")
    public void deleteProject(@PathVariable("id")String id){
        projectRepository.delete(id);
    }


}
