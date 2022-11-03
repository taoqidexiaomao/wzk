package com.lhwl.wzk.jpa.controller;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lhwl.wzk.Util.JsonUtil;
import com.lhwl.wzk.jpa.dao.StudentRepository;
import com.lhwl.wzk.jpa.dao.WzkCourseRepository;
import com.lhwl.wzk.jpa.model.Student;
import com.lhwl.wzk.jpa.model.WzkCoureseEntity;
import com.lhwl.wzk.jpa.service.WzkService;
import com.lhwl.wzk.mybatis.service.IWzkResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
@Api(tags = "wzk接口文档")
public class WzkController {
    @Autowired
    WzkService wzkService;
    @Autowired
    IWzkResourceService iWzkResourceService;
    @Resource
    private WzkCourseRepository wzkCourseRepository;
    @Resource
    private StudentRepository studentRepository;
    @RequestMapping("SaveCourse")
    @ApiOperation("课程数据接口")
    @ApiImplicitParam()
    public String SaveCourse(@RequestBody String json) {
        JsonUtil jsonUtil = JSONObject.parseObject(json, new TypeReference<JsonUtil<WzkCoureseEntity>>(){});
        jsonUtil.getData().forEach(System.out::println);
        List<WzkCoureseEntity> wzkCoureseEntity=jsonUtil.getData();
        wzkService.SaveCourse(wzkCoureseEntity);
        return "success";
    }
    @ApiOperation("资源数据接口")
    @RequestMapping("wzkCourse")
    public String wzkCourse(WzkCoureseEntity wzkCoureseEntity) {
        wzkCoureseEntity.setSchoolName(new Random().nextInt(10000)+"学校");
        Set<Student> set=new HashSet<>();
        for (int i = 0; i <3 ; i++) {
            Student student=new Student();
            student.setSname("张三"+i);
            student.setSsex(String.valueOf(i));
            set.add(student);
        }
        wzkCoureseEntity.setStudents(set);
        wzkCourseRepository.save(wzkCoureseEntity);
        return "success";
    }
    @RequestMapping("get")
    public List<WzkCoureseEntity> getWzkCourse(String name) {
        List<WzkCoureseEntity> list=wzkCourseRepository.queryList(name);
        return wzkCourseRepository.findAll();
    }
    @RequestMapping("get2")
    public List<Student> get2(Integer id) {
        return studentRepository.findAll();
    }
}

