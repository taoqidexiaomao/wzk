package com.lhwl.wzk.jpa.controller;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhwl.wzk.Util.JsonUtil;
import com.lhwl.wzk.jpa.model.WzkCoureseEntity;
import com.lhwl.wzk.jpa.service.WzkService;
import com.lhwl.wzk.mybatis.entity.WzkResource;
import com.lhwl.wzk.mybatis.service.IWzkResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "wzk接口文档")
public class WzkController {
    @Autowired
    WzkService wzkService;
    @Autowired
    IWzkResourceService iWzkResourceService;
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
    @RequestMapping("SaveResource")
    public String SaveResource(@RequestBody String json) {
        JsonUtil jsonUtil = JSONObject.parseObject(json, new TypeReference<JsonUtil<WzkResource>>(){});
        jsonUtil.getData().forEach(System.out::println);
        List<WzkResource> wzkResources=jsonUtil.getData();
        //iWzkResourceService.saveBatch(wzkResources);
        QueryWrapper<WzkResource> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("resourceId");
        queryWrapper.select("majorId");
        iWzkResourceService.saveOrUpdateBatch(wzkResources);
        return "success";
    }
}

