package com.zhaoxl.redisdemo.service;

import com.zhaoxl.redisdemo.entity.SysUser;

import java.util.List;

/**
 * title: SysUserService
 * description: TODO
 * author: zhaoxl
 * date: 2020/1/9 16:02
 */
public interface SysUserService {

    List<SysUser> findAllUser();

    SysUser findUserById(Long id);

    SysUser deleteUserCacheById(Long id);
}
