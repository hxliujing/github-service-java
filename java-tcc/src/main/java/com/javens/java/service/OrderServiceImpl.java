/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.service;

import lombok.extern.slf4j.Slf4j;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 *
 * @author liujing01
 * @version OrderServiceImpl.java, v 0.1 2018-12-28 14:28 
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    /**
     * 订单
     * @param amount
     * @param userId
     * @return
     */
    @Override
    @Compensable(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    public boolean order(BigDecimal amount, Integer userId) {
        log.info("order->amount:{},userId:{}",amount,userId);
        return false;
    }

    public boolean confirmOrder(BigDecimal amount, Integer userId) {
        log.info("confirmOrder->amount:{},userId:{}",amount,userId);
        return false;
    }

    public boolean cancelOrder(BigDecimal amount, Integer userId) {
        log.info("cancelOrder->amount:{},userId:{}",amount,userId);
        return false;
    }
}
