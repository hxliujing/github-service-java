/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.service;

import com.fshows.fsframework.core.utils.LogUtil;
import com.javens.java.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 *
 * @author liujing01
 * @version OrderServiceTest.java, v 0.1 2018-12-28 14:31 
 */
@Slf4j
public class OrderServiceTest extends BaseTest{

    @Autowired
    private OrderService orderService;
    @Test
    public void testOrder(){
        LogUtil.info(log,"=========testOrder============");
        orderService.order(BigDecimal.valueOf(0.99),1001);
    }
}
