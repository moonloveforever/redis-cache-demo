package com.zhaoxl.redisdemo.service.impl;

import com.zhaoxl.redisdemo.entity.SysUser;
import com.zhaoxl.redisdemo.repository.SysUserDao;
import com.zhaoxl.redisdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * title: SysUserServiceImpl
 * description: TODO
 * author: zhaoxl
 * date: 2020/1/9 16:03
 */
@Service
@CacheConfig(cacheNames = "test")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    // @Cacheable(value = "12h",keyGenerator = "listkeyGenerator")
    // RedisConfig.java中配置的 定时失效的缓存，可以在这里指定value就是那边设定的缓存名
    // keyGenerator 可以指定RedisConfig.java中配置的key生成策略

    // key的值可以设定为字符串【字符串必须要用''引起来，否则会将其认定为字段而报错】    例如：key = "'EDS'"
    // key的值也可以设定为spEL表达式书写     例如：key = "#userId"
    // key的值也可以设定为      例如:key = "T(java.util.UUID).randomUUID().toString()"

    // 关于注解中每个属性的详细使用，可以详细去查看API
    @Cacheable(value = "myCache", key = "'EDS'")
    @Override
    public List<SysUser> findAllUser() {
        List<SysUser> ls = sysUserDao.findAll();
        return ls;
    }

    @Cacheable(value = "myCache", key = "#id")
    @Override
    public SysUser findUserById(Long id) {
        return sysUserDao.getOne(id);
    }

    @CacheEvict(value = "myCache", key = "#id")
    @Override
    public SysUser deleteUserCacheById(Long id) {
        return sysUserDao.getOne(id);
    }
}
