package com.scott.lee.user;

import com.scott.lee.user.entity.User;
import com.slyak.spring.jpa.GenericJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户数据库资源类
 * Created by Scott on 2017/1/17.
 */
@Repository
public interface UserRepository extends GenericJpaRepository<User,String> {
    User findByUsername(String username);
}
