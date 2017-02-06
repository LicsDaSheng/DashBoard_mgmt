package com.scott.lee.project.reponsitory;

import com.scott.lee.project.reponsitory.entity.Project;
import com.scott.lee.project.reponsitory.entity.Scrum;
import com.slyak.spring.jpa.GenericJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 迭代数据库处理类
 * Created by Scott on 2017/1/24.
 */
@Repository
public interface ScrumRepository extends GenericJpaRepository<Scrum,String> {

    /**
     * 根据项目ID查询迭代列表
     * @param projectId 项目ID
     * @return 迭代列表
     */
    List<Scrum> findByProjectId(String projectId);
}
