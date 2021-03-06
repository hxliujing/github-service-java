package com.javens.java.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fshows.fsframework.common.exception.CommonException;
import com.fshows.fsframework.core.utils.LogUtil;
import com.javens.java.facade.AccountTccFacade;
import com.javens.java.facade.domain.request.AccountTccFacadeRequest;
import lombok.extern.slf4j.Slf4j;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liujing01
 * @version AccountTccServiceImpl.java, v 0.1 2019-01-02 18:36
 */
@Service(version = "${dubbo.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
@Component
@Slf4j
public class AccountTccFacadeImpl implements AccountTccFacade {

    @Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord", transactionContextEditor = DubboTransactionContextEditor.class)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String record(AccountTccFacadeRequest request) {
        LogUtil.info(log,"{} record param:{}",this.getClass().getSimpleName(),request);
        throw  CommonException.SYSTEM_ERROR;
        //return null;
    }

    /**
     *
     * confirmRecord
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void confirmRecord(AccountTccFacadeRequest request){
        LogUtil.info(log,"{}  confirmRecord param:{}",this.getClass().getSimpleName(),request);
    }

    /**
     *
     * cancelRecord
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancelRecord(AccountTccFacadeRequest request){
        LogUtil.info(log,"{} cancelRecord param:{}",this.getClass().getSimpleName(),request);
    }
}