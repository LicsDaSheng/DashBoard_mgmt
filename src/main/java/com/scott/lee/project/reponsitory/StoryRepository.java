package com.scott.lee.project.reponsitory;

import com.scott.lee.project.reponsitory.entity.Project;
import com.scott.lee.project.reponsitory.entity.Story;
import com.slyak.spring.jpa.GenericJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 功能模块数据库操作类
 * Created by Scott on 2017/1/24.
 */
@Repository
public interface StoryRepository extends GenericJpaRepository<Story,String> {
}
