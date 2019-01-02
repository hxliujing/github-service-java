/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.facade;

import com.javens.java.facade.domain.request.AccountFacadeRequest;
import com.javens.java.facade.domain.request.AccountFacadeSepRequest;
import com.javens.java.facade.domain.response.AccountFacadeResponse;
import com.javens.java.facade.domain.response.AccountFacadeSepResponse;

/**
 *
 * @author liujing01
 * @version AccountFacade.java, v 0.1 2019-01-02 11:24 
 */
public interface AccountFacade {
    /**
     * 获取账户信息
     * @param request
     * @return
     */
    AccountFacadeResponse getAccountById(AccountFacadeRequest request);

    /**
     * 返回受影响的行数
     * @param request
     * @return
     */
    AccountFacadeSepResponse sepAccount(AccountFacadeSepRequest request);
}
