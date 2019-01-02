/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.intergration.client;

import com.javens.java.intergration.client.domain.form.OrderSaveForm;
import com.javens.java.intergration.client.domain.result.OrderSaveResult;

/**
 *
 * @author liujing01
 * @version TccOrderClient.java, v 0.1 2019-01-02 14:52 
 */
public interface TccOrderClient {
    /**
     * 保存订单记录
     * @param form
     * @return
     */
    OrderSaveResult save(OrderSaveForm form);
}
