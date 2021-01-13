package com.lpl.mpdemo.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.lpl.mpdemo.entity.Risk;
import com.lpl.mpdemo.mapper.RiskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lipuliang
 * Date: 2021/1/13
 * FileName: RiskService
 * Description: .
 */
@Service
public class RiskService {

    @Autowired
    private RiskMapper riskMapper;



    @DS("slave")
    public void testSlave(){
        List<Risk> riskList = riskMapper.selectList(null);
        riskList.forEach(System.out::println);
    }


}
