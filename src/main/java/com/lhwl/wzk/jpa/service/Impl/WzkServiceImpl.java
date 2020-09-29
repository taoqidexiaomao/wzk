package com.lhwl.wzk.jpa.service.Impl;


import com.lhwl.wzk.jpa.dao.WzkCourseRepository;
import com.lhwl.wzk.jpa.model.WzkCoureseEntity;
import com.lhwl.wzk.jpa.service.WzkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
public class WzkServiceImpl implements WzkService {
    @Resource
    WzkCourseRepository wzkCourseRepository;

    @Override
    public void SaveCourse(List<WzkCoureseEntity> wzkCoureseEntity) {
        List<WzkCoureseEntity>list=wzkCourseRepository.saveAll(wzkCoureseEntity);
    }
}
