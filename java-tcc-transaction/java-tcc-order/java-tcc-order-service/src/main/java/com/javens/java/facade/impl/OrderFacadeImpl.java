package com.javens.java.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fshows.fsframework.core.utils.FsBeanUtil;
import com.fshows.fsframework.core.utils.LogUtil;
import com.javens.java.domain.OrderFacade;
import com.javens.java.domain.request.OrderFacadeRequest;
import com.javens.java.domain.request.OrderFacadeSaveRequest;
import com.javens.java.domain.response.OrderFacadeResponse;
import com.javens.java.domain.response.OrderFacadeSaveResponse;
import com.javens.java.service.dal.tcc_java_order.dao.OrderDAO;
import com.javens.java.service.dal.tcc_java_order.dataobject.OrderDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liujing01
 * @version OrderFacadeImpl.java, v 0.1 2019-01-02 14:34
 */
@Service(version = "${dubbo.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
@Component
@Slf4j
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    private OrderDAO orderDAO;
    @Override
    public OrderFacadeResponse getById(OrderFacadeRequest request) {
        LogUtil.info(log,"getById param:{}",request);
        OrderDO orderDO = orderDAO.getById(request.getId());
        return FsBeanUtil.map(orderDO,OrderFacadeResponse.class);
    }

    @Override
    public OrderFacadeSaveResponse save(OrderFacadeSaveRequest request) {
        LogUtil.info(log,"save param:{}",request);
        OrderDO orderDO = FsBeanUtil.map(request,OrderDO.class);
        Long result = orderDAO.insert(orderDO);
        OrderFacadeSaveResponse response = new OrderFacadeSaveResponse();
        response.setResult(result);
        return response;
    }
}