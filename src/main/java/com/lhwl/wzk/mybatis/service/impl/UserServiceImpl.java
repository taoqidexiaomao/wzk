package com.lhwl.wzk.mybatis.service.impl;

import com.lhwl.wzk.mybatis.entity.User;
import com.lhwl.wzk.mybatis.mapper.UserMapper;
import com.lhwl.wzk.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mrli
 * @since 2020-09-22
 */
@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<User> test() {
        return userMapper.test();
    }
}
