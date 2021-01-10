package com.lpl.mpdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lpl.mpdemo.entity.User;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }


    @Test
    public void test2(){
        User user=new User();
        user.setName("刘涛");
        user.setAge(17);
        user.setAddress("无锡市");
        userMapper.insert(user);
    }


    @Test
    public void test3(){
//        userMapper.deleteById(1348129708477292545L);

//        userMapper.deleteBatchIds(Arrays.asList(1348129124302999553l,1348127881765617666L));

        Map<String,Object> map=new HashMap<>();
        map.put("username","刘涛2");
        userMapper.deleteByMap(map);
    }


    @Test
    public void test4(){
//        User user=new User();
//        user.setId(1348129047371157506L);
//        user.setAge(23);
//        user.setAddress(null);
//        userMapper.updateById(user);

//        User user=new User();
//        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
//        updateWrapper.eq("id",1348129047371157506L).set("address",null);
//        userMapper.update(user,updateWrapper);


        User user=new User();
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("username","刘涛").eq("age",23).set("address","常州市");
        userMapper.update(user,updateWrapper);

    }


    @Test
    public void test5(){
//        User user = userMapper.selectById(1348127881765617665L);
//        System.out.println(user);

//        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1348127881765617665L, 1348129047371157506L));
//        userList.forEach(System.out::println);

//        Map<String,Object> map=new HashMap<>();
//        map.put("username","刘涛");
//        List<User> userList = userMapper.selectByMap(map);
//        userList.forEach(System.out::println);


//        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("username","刘涛");
//        List<User> userList = userMapper.selectList(queryWrapper);
//        userList.forEach(System.out::println);


//        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getName,"刘涛");
//        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
//        userList.forEach(System.out::println);

//        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getName,"刘涛");
//        List<Map<String, Object>> list = userMapper.selectMaps(lambdaQueryWrapper);
//        list.forEach(System.out::println);


//        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getName,"刘涛");
//        List<Object> objects = userMapper.selectObjs(lambdaQueryWrapper);
//        objects.forEach(System.out::println);

        IPage<User> iPage=new Page<>(1,3);
        IPage<User> selectPage = userMapper.selectPage(iPage, null);
        List<User> records = selectPage.getRecords();
        records.forEach(System.out::println);
        long total = selectPage.getTotal();
        System.out.println("总记录数："+total);
        long pages = selectPage.getPages();
        System.out.println("总页数："+pages);
        long current = selectPage.getCurrent();
        System.out.println("当前页："+current);
        long size = selectPage.getSize();
        System.out.println("每页条数："+size);

    }

    @Test
    public void test6(){
//        List<User> userList = userMapper.selectList(null);
//        userList.forEach(System.out::println);

        userMapper.deleteById(9L);

    }


    @Test
    public void test7(){
//        User user=new User();
//        user.setName("吴迪");
//        user.setAge(22);
//        user.setAddress("苏州市");
//        userMapper.insert(user);

        User user=new User();
        user.setId(1348158743718686721L);
        user.setAge(30);
        userMapper.updateById(user);

    }


    @Test
    public void test8(){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getName,"刘涛").eq(User::getAge,23);

//        lambdaQueryWrapper.ne(User::getName,"刘涛");

//        lambdaQueryWrapper.ge(User::getAge,25);

//        lambdaQueryWrapper.between(User::getAge,16,25);

//        lambdaQueryWrapper.like(User::getAddress,"上海");

//        lambdaQueryWrapper.likeRight(User::getAddress,"上海");

//        lambdaQueryWrapper.isNull(User::getAddress);

//        lambdaQueryWrapper.in(User::getAge,Arrays.asList(23,24,29));

//        lambdaQueryWrapper.inSql(User::getId,"select id from t_user where age>25");

//        lambdaQueryWrapper.orderByAsc(User::getAge);

//        lambdaQueryWrapper.groupBy(User::getAddress).having("count(*)>={0}",2);

//        lambdaQueryWrapper.eq(User::getName,"刘涛").or().eq(User::getAge,15);

//        lambdaQueryWrapper.apply("length(id)={0}",1);

//        lambdaQueryWrapper.last("order by id desc");

//        lambdaQueryWrapper.select(User.class,tfi->!tfi.getColumn().equals("age"));

        lambdaQueryWrapper.select(User::getId, User::getName);

        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        userList.forEach(System.out::println);
    }


    @Test
    public void test9(){
        List<User> list = userMapper.findAll();
        list.forEach(System.out::println);
    }



}