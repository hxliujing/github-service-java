/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.service;

import java.math.BigDecimal;

/**
 *
 * @author liujing01
 * @version OrderService.java, v 0.1 2018-12-28 14:26 
 */
public interface OrderService {
    /**
     * 订单
     * @param amount
     * @param userId
     * @return
     */
    boolean order(BigDecimal amount, Integer userId);
}
