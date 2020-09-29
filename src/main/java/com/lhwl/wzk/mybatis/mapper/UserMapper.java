package com.lhwl.wzk.mybatis.mapper;

import com.lhwl.wzk.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mrli
 * @since 2020-09-22
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> test();
}
