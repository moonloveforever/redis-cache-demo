package com.zhaoxl.redisdemo.controller;

import com.zhaoxl.redisdemo.pub.web.Result;
import com.zhaoxl.redisdemo.pub.web.Status;
import com.zhaoxl.redisdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * title: SysUserController
 * description: TODO
 * author: zhaoxl
 * date: 2020/1/9 16:26
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/findAllUserInfo")
    public Result findAllUserInfo() {
        Result result = Result.instance(Status.OK);
        result.add("userInfo", sysUserService.findAllUser());
        return result;
    }

    @GetMapping("/findUserById/{id}")
    public Result findUserById(@PathVariable(name = "id") Long id) {
        Result result = Result.instance(Status.OK);
        result.add("userInfo", sysUserService.findUserById(id));
        return result;
    }
}
