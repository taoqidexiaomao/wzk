package com.lhwl.wzk.mybatis.controller;


import com.lhwl.wzk.mybatis.service.ICourseService;
import com.lhwl.wzk.mybatis.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mrli
 * @since 2020-08-25
 */
@RestController
@RequestMapping("/mybatis/course")
public class CourseController {
        @GetMapping
        public String test(){
            return "test";
        }

}
