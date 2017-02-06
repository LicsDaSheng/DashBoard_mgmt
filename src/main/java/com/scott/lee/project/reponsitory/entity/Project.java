package com.scott.lee.project.reponsitory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scott.lee.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 项目实体类
 * Created by Scott on 2017/1/24.
 */
@Table(name = "t_project")
@Entity
public class Project extends BaseEntity{

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    /**
     * 项目结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    /**
     * 项目描述
     */
    private String description;


    /**
     * 模块功能列表
     */
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="project_id")
    private List<Story> stories;

    /**
     * 产品迭代列表
     */
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="project_id")
    private List<Scrum> scrumList;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<Scrum> getScrumList() {
        return scrumList;
    }

    public void setScrumList(List<Scrum> scrumList) {
        this.scrumList = scrumList;
    }
}
