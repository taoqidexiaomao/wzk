package com.lhwl.wzk.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhwl.wzk.mybatis.entity.Student;
import com.lhwl.wzk.mybatis.mapper.StudentMapper;
import com.lhwl.wzk.mybatis.service.IStudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mrli
 * @since 2020-08-25
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
