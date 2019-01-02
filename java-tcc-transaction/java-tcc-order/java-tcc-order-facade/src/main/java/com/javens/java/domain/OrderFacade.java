/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.domain;

import com.javens.java.domain.request.OrderFacadeRequest;
import com.javens.java.domain.request.OrderFacadeSaveRequest;
import com.javens.java.domain.response.OrderFacadeResponse;
import com.javens.java.domain.response.OrderFacadeSaveResponse;

/**
 *
 * @author liujing01
 * @version OrderFacade.java, v 0.1 2019-01-02 14:27 
 */
public interface OrderFacade {
    /**
     * 根据ID获取记录
     * @param request
     * @return
     */
    OrderFacadeResponse getById(OrderFacadeRequest request);

    /**
     * 保存记录
     * @param request
     * @return
     */
    OrderFacadeSaveResponse save(OrderFacadeSaveRequest request);

}
