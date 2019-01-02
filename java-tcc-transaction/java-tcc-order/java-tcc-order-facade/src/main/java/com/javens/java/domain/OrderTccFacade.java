/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.domain;

import com.javens.java.domain.request.OrderFacadeSaveRequest;
import org.mengyun.tcctransaction.api.Compensable;

/**
 *
 * @author liujing01
 * @version OrderTccFacade.java, v 0.1 2019-01-02 21:27 
 */
public interface OrderTccFacade {
    @Compensable
    public String save(OrderFacadeSaveRequest request);
}
