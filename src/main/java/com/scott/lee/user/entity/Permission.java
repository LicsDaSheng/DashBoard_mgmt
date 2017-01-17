package com.scott.lee.user.entity;

import com.scott.lee.base.BaseEntity;

import javax.persistence.*;

/**
 * 权限（增删改查等）
 *
 * Created by Scott on 2017/1/17.
 */
@Entity
@Table(name = "t_permission")
public class Permission extends BaseEntity{

    /**
     * 权限名称
     */
    private String permissionname;

    /**
     * 权限角色
     * 一个权限对应一个角色
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;



    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



}
