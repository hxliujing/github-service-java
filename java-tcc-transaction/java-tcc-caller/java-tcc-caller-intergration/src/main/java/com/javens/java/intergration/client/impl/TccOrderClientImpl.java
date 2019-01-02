/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.intergration.client.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fshows.fsframework.core.utils.FsBeanUtil;
import com.fshows.fsframework.core.utils.LogUtil;
import com.javens.java.domain.OrderFacade;
import com.javens.java.domain.request.OrderFacadeSaveRequest;
import com.javens.java.domain.response.OrderFacadeSaveResponse;
import com.javens.java.intergration.client.TccOrderClient;
import com.javens.java.intergration.client.domain.form.OrderSaveForm;
import com.javens.java.intergration.client.domain.result.OrderSaveResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author liujing01
 * @version TccOrderClientImpl.java, v 0.1 2019-01-02 14:56 
 */
@Component
@Slf4j
public class TccOrderClientImpl implements TccOrderClient {
    @Reference(version = "${dubbo.version}",
            application = "${dubbo.application.id}")
    private OrderFacade orderFacade;

    @Override
    public OrderSaveResult save(OrderSaveForm form) {
        LogUtil.info(log,"save param:{}",form);
        OrderFacadeSaveRequest request = FsBeanUtil.map(form,OrderFacadeSaveRequest.class);
        OrderFacadeSaveResponse response = orderFacade.save(request);
        return FsBeanUtil.map(response,OrderSaveResult.class);
    }
}
