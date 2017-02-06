package com.scott.lee.project.reponsitory;

import com.scott.lee.project.reponsitory.entity.Project;
import com.slyak.spring.jpa.GenericJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 项目数据库处理类
 * Created by Scott on 2017/1/24.
 */
@Repository
public interface ProjectRepository extends GenericJpaRepository<Project,String> {

}
