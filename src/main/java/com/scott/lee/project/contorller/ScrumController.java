package com.scott.lee.project.contorller;

import com.scott.lee.base.JSONResult;
import com.scott.lee.project.reponsitory.ScrumRepository;
import com.scott.lee.project.reponsitory.entity.Scrum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目Controller
 * Created by Scott on 2017/1/24.
 */
@RestController
@RequestMapping("/scrum")
@Api(value = "项目接口", description = "ProjectController")
public class ScrumController {


    @Autowired
    ScrumRepository scrumRepository;

    @RequestMapping(value="/findall",  method= RequestMethod.GET)
    @ApiOperation(value = "查询所有项目", notes = "分页查询所有人员")
    public @ResponseBody
    JSONResult<Page<Scrum>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "15") Integer size){
        Pageable pageable = new PageRequest(page, size);
        JSONResult<Page<Scrum>> result = new JSONResult<>();
        result.setData(scrumRepository.findAll(pageable));
        return result;
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    @ApiOperation(value = "根据项目ID查询项目详细",notes = "根据项目ID查询项目详细")
    public @ResponseBody
    JSONResult<Scrum> findScrumById(@PathVariable("id")String id){
        JSONResult<Scrum> result = new JSONResult<>();
        result.setData(scrumRepository.findOne(id));
        return result ;
    }

    @RequestMapping(value="/save",  method=RequestMethod.POST)
    @ApiOperation(value = "新增项目", notes = "新增项目")
    public @ResponseBody Scrum saveScrum(@RequestBody Scrum scrum) {
        return scrumRepository.save(scrum);
    }

    @RequestMapping(value="/{id}",  method=RequestMethod.PATCH)
    @ApiOperation(value = "更新项目",notes = "更新项目")
    public @ResponseBody Scrum updateScrum(@PathVariable("id")String id,@RequestBody Scrum scrum){
        scrum.setId(id);
        return scrumRepository.save(scrum);
    }

    @RequestMapping(value="/findProject/{projectId}",  method= RequestMethod.GET)
    @ApiOperation(value = "查询所有项目", notes = "分页查询所有人员")
    public @ResponseBody
    JSONResult<List<Scrum>> findByProjectId(@PathVariable("projectId")String projectId){
        JSONResult<List<Scrum>> result = new JSONResult<>();
        result.setData(scrumRepository.findByProjectId(projectId));
        return result;
    }
}
