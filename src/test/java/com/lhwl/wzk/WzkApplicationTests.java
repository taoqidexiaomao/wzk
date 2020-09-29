package com.lhwl.wzk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhwl.wzk.Util.JsonUtil;
import com.lhwl.wzk.mybatis.entity.Course;
import com.lhwl.wzk.mybatis.entity.Student;
import com.lhwl.wzk.mybatis.entity.User;
import com.lhwl.wzk.mybatis.mapper.CourseMapper;
import com.lhwl.wzk.mybatis.mapper.StudentMapper;
import com.lhwl.wzk.mybatis.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class WzkApplicationTests {

    @Test
    void contextLoads() {
    }
    @Resource
    private IUserService iUserService;
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private StudentMapper studentMapper;
    

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        String fullname="测试课";
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        //queryWrapper.ge("SId", 2);
        //queryWrapper.eq("SId", 2);
        queryWrapper.groupBy("Sname");
        queryWrapper.having("SId>{0}","5");
        Page<Student> page = new Page<>(1, 2);
        Page<Map<String,Object>> paget = new Page<>(1, 2);
        List<Course> userList = courseMapper.selectList(null);
        IPage<Student> pages=studentMapper.selectPage(page,queryWrapper);
        System.out.println("总条数"+pages.getTotal());
        System.out.println("总页数"+pages.getPages());
        IPage<Map<String,Object>> userIPage = studentMapper.selectMapsPage(paget, queryWrapper);
        System.out.println("总条数"+userIPage.getTotal());
        System.out.println("总页数"+userIPage.getPages());
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void queryUserForPage(){
        Page<Course> page=new Page();
        page.setCurrent(1);
        page.setSize(2);
        IPage<Course> coursePage = courseMapper.selectPage(page, null);
        List<Course> list = coursePage.getRecords();
        list.forEach(System.out::println);
    }

    @Test
    public void test() {
        List<User> user=iUserService.test();
        System.out.println(JSON.toJSONString(user));
        List<Apple> list = new ArrayList<>();
        Apple apple=new Apple();
        apple.setColor("green");
        apple.setWeight(20);
        list.add(apple);
        //对象实例语法	instanceRef::methodName
        list.forEach(Apple::print);
    }

    @Test
    void name() {
        Student s=new Student();
        s.setSId(1);
        s.setSname("张三");
        s.setSage(21);
        s.setSsex("男");
        List<Student> students = new ArrayList();
        students.add(s);
        String str = JSON.toJSONString(students); // List转json
        log.info(str);

        String str3 = "{\"data\":[{\"sId\":1,\"sage\":21,\"sname\":\"张三\",\"ssex\":\"男\"}]}";// 放进去的是List
        JsonUtil ss = JSON.parseObject(str3,new TypeReference<JsonUtil>(){}); // Json 转List
        ss.getData().forEach(System.out::println);
    }

    public static void print(Apple content){
        System.out.println(content);
    }
    protected void qc(){
        double bj=75.0;
        for (int i=0;i<30;i++){
            System.out.println(bj+=bj*=0.045);
        }
    }
    protected void lx(){
        double bj=75.0;
        for (int i=0;i<31;i++){
            if(i==0){
                System.out.println(bj*0.045);
            }
            else {
                System.out.println((bj*0.045));
            }
            bj=bj+bj*0.045;
        }
    }
    @Test
    void YaZi() {
        //lx();
       // qc();
           // log.info(String.valueOf(yz(1,8)));
        //log.info(String.valueOf(f(3)));
/*        for (int i=0;i<31;i++){
            System.out.println(q(0,i));
        }
        for (int i=0;i<31;i+=5){
            System.out.println(yh(0,i));
        }*/
        System.out.println(q(0,10));
    }
    public long yz(int cz,int end){
        if(cz==end){
            return 2;
        }
        return 2*(yz(cz+1,end)+1);

    }
    public static int f(int n ) {
        if (1== n || 2 == n)
            return 1;
        else
            return f(n-1) + f(n-2);
    }
    public double q(int nf,int end){
        if(nf==end){
            return 75.0;
        }
        else {
            return 0.045*q(nf+1,end)+q(nf+1,end);
        }
    }
    public double yh(int nf,int end){
        if(nf>=end){
            return 75.0;
        }
        else {
            return 0.250*yh(nf+5,end)+yh(nf+5,end);
        }
    }
}
