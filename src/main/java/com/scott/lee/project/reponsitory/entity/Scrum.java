package com.scott.lee.project.reponsitory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scott.lee.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 迭代实体类
 * Created by Scott on 2017/1/24.
 */
@Table(name = "t_scrum")
@Entity
public class Scrum extends BaseEntity{

    /**
     * 迭代名称
     */
    private String name;

    /**
     * 项目负责人ID
     */
    private String userId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    /**
     * 开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    /**
     * 结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    /**
     * 一个迭代对用多个功能呢模块
     */
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="scrum_id")
    private List<Story> stories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
