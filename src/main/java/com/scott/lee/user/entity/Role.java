package com.scott.lee.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scott.lee.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色（管理员，普通用户等）
 * Created by Scott on 2017/1/17.
 */

@Entity
@Table(name = "t_role")
public class Role extends BaseEntity{

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 角色权限
     * 一个角色对应多个权限
     */
    @OneToMany(mappedBy = "role", fetch=FetchType.EAGER)
    private List<Permission> permissionList;

    /**
     * 角色用户
     * 一个角色对应多个用户
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
            @JoinColumn(name = "user_id") })
    private List<User> userList;



    @Transient
    public List<String> getPermissionsName() {
        List<String> list = new ArrayList<String>();
        List<Permission> perlist = getPermissionList();
        for (Permission per : perlist) {
            list.add(per.getPermissionname());
        }
        return list;
    }



    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
