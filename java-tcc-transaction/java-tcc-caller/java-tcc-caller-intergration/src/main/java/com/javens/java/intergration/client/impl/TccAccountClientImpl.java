/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.intergration.client.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fshows.fsframework.core.utils.FsBeanUtil;
import com.fshows.fsframework.core.utils.LogUtil;
import com.javens.java.domain.OrderFacade;
import com.javens.java.facade.AccountFacade;
import com.javens.java.facade.AccountTccFacade;
import com.javens.java.facade.domain.request.AccountFacadeRequest;
import com.javens.java.facade.domain.request.AccountFacadeSepRequest;
import com.javens.java.facade.domain.request.AccountTccFacadeRequest;
import com.javens.java.facade.domain.response.AccountFacadeResponse;
import com.javens.java.facade.domain.response.AccountFacadeSepResponse;
import com.javens.java.intergration.client.TccAccountClient;
import com.javens.java.intergration.client.domain.form.AccountTccFacadeForm;
import com.javens.java.intergration.client.domain.form.TccAccountFindForm;
import com.javens.java.intergration.client.domain.form.TccAccountUpdateForm;
import com.javens.java.intergration.client.domain.result.TccAccountFindResult;
import com.javens.java.intergration.client.domain.result.TccAccountUpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author liujing01
 * @version TccAccountClientImpl.java, v 0.1 2019-01-02 14:56 
 */
@Component
@Slf4j
public class TccAccountClientImpl implements TccAccountClient {
    @Reference(version = "${dubbo.version}",
            application = "${dubbo.application.id}")
    private AccountFacade accountFacade;

    @Reference(version = "${dubbo.version}",
            application = "${dubbo.application.id}")
    private AccountTccFacade accountTccFacade;

    @Override
    public TccAccountUpdateResult update(TccAccountUpdateForm form) {
        LogUtil.info(log,"update param:{}",form);
        AccountFacadeSepRequest request = FsBeanUtil.map(form,AccountFacadeSepRequest.class);
        AccountFacadeSepResponse response =  accountFacade.sepAccount(request);
        return FsBeanUtil.map(response,TccAccountUpdateResult.class);
    }

    @Override
    public TccAccountFindResult find(TccAccountFindForm form) {
        LogUtil.info(log,"find param:{}",form);
        AccountFacadeRequest request = FsBeanUtil.map(form,AccountFacadeRequest.class);
        AccountFacadeResponse response =  accountFacade.getAccountById(request);
        return FsBeanUtil.map(response,TccAccountFindResult.class);
    }

    /**
     * TCC 事务调用
     * @param form
     * @return
     */
    @Override
    public String tccRecord(AccountTccFacadeForm form){
        LogUtil.info(log,"tccRecord param:{}",form);
        AccountTccFacadeRequest request = FsBeanUtil.map(form,AccountTccFacadeRequest.class);
        return accountTccFacade.record(request);
    }
}
