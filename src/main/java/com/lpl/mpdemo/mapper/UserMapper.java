package com.lpl.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lpl.mpdemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

}
