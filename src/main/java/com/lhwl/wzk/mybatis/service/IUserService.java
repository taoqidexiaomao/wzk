package com.lhwl.wzk.mybatis.service;

import com.lhwl.wzk.mybatis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mrli
 * @since 2020-09-22
 */
public interface IUserService extends IService<User> {

    List<User> test();
}
