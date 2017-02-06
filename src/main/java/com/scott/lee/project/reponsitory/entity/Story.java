package com.scott.lee.project.reponsitory.entity;

import com.scott.lee.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 功能模块实体类
 * Created by Scott on 2017/1/24.
 */
@Table(name = "t_story")
@Entity
public class Story extends BaseEntity{

    /**
     * 模块名称
     */
    private String name;


    /**
     * 父模块ID
     */
    private String parentId;

    /**
     * 项目负责人ID
     */
    private String userId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "scrum_id")
    private Scrum scrum;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Scrum getScrum() {
        return scrum;
    }

    public void setScrum(Scrum scrum) {
        this.scrum = scrum;
    }
}
