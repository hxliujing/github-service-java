package com.javens.java.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fshows.fsframework.core.utils.FsBeanUtil;
import com.fshows.fsframework.core.utils.LogUtil;
import com.javens.java.facade.AccountFacade;
import com.javens.java.facade.domain.request.AccountFacadeRequest;
import com.javens.java.facade.domain.request.AccountFacadeSepRequest;
import com.javens.java.facade.domain.response.AccountFacadeResponse;
import com.javens.java.facade.domain.response.AccountFacadeSepResponse;
import com.javens.java.service.dal.tcc_java_account.dao.AccountDAO;
import com.javens.java.service.dal.tcc_java_account.dataobject.AccountDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liujing01
 * @version AccountFacadeImpl.java, v 0.1 2019-01-02 11:34
 */
@Service(version = "${dubbo.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
@Component
@Slf4j
public class AccountFacadeImpl implements AccountFacade {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public AccountFacadeResponse getAccountById(AccountFacadeRequest request) {
        LogUtil.info(log,"getAccountById param:{}",request);
        AccountDO accountDO = accountDAO.getById(request.getId());
        return FsBeanUtil.map(accountDO,AccountFacadeResponse.class);
    }

    @Override
    public AccountFacadeSepResponse sepAccount(AccountFacadeSepRequest request) {
        LogUtil.info(log,"sepAccount param:{}",request);
        AccountDO accountDO = FsBeanUtil.map(request,AccountDO.class);
        Long result = accountDAO.updateAccountBalance(accountDO);
        AccountFacadeSepResponse response = new AccountFacadeSepResponse();
        response.setResult(result);
        return response;
    }
}