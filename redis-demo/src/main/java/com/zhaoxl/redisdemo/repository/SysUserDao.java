package com.zhaoxl.redisdemo.repository;

import com.zhaoxl.redisdemo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * title: SysUserDao
 * description: TODO
 * author: zhaoxl
 * date: 2020/1/9 15:59
 */
@Repository
public interface SysUserDao extends JpaRepository<SysUser,Long> {

    @Override
    List<SysUser> findAll();
}
