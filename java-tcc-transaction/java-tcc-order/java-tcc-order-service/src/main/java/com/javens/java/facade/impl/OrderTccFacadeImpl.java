package com.javens.java.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fshows.fsframework.core.utils.LogUtil;
import com.javens.java.domain.OrderTccFacade;
import com.javens.java.domain.request.OrderFacadeSaveRequest;
import lombok.extern.slf4j.Slf4j;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liujing01
 * @version OrderTccFacadeImpl.java, v 0.1 2019-01-02 21:28
 */
@Service(version = "${dubbo.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
@Component
@Slf4j
public class OrderTccFacadeImpl implements OrderTccFacade {
    @Compensable(confirmMethod = "confirmSave", cancelMethod = "cancelSave", transactionContextEditor = DubboTransactionContextEditor.class)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String save(OrderFacadeSaveRequest request) {
        LogUtil.info(log,"{}  save param:{}",this.getClass().getSimpleName(),request);
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    public void confirmSave(OrderFacadeSaveRequest request) {
        LogUtil.info(log,"{}  confirmSave param:{}",this.getClass().getSimpleName(),request);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancelSave(OrderFacadeSaveRequest request) {
        LogUtil.info(log,"{}  cancelSave param:{}",this.getClass().getSimpleName(),request);
    }
}