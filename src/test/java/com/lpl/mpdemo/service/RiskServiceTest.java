package com.lpl.mpdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: lipuliang
 * Date: 2021/1/13
 * FileName: RiskServiceTest
 * Description:
 */
@SpringBootTest
public class RiskServiceTest {

    @Autowired
    private RiskService riskService;


    @Test
    public void testSlave() {
        riskService.testSlave();
    }
}