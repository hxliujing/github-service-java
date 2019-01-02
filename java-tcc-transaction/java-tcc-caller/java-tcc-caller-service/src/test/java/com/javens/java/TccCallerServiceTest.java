/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java;

import com.fshows.fsframework.core.utils.LogUtil;
import com.fshows.fsframework.core.utils.OrderUtil;
import com.javens.java.intergration.client.TccAccountClient;
import com.javens.java.intergration.client.TccOrderClient;
import com.javens.java.intergration.client.domain.form.AccountTccFacadeForm;
import com.javens.java.intergration.client.domain.form.OrderSaveForm;
import com.javens.java.intergration.client.domain.form.TccAccountFindForm;
import com.javens.java.intergration.client.domain.result.OrderSaveResult;
import com.javens.java.intergration.client.domain.result.TccAccountFindResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author liujing01
 * @version TccCallerServiceTest.java, v 0.1 2019-01-02 15:09 
 */
@Slf4j
public class TccCallerServiceTest extends BaseTest {
    @Autowired
    private TccAccountClient tccAccountClient;
    @Autowired
    private TccOrderClient tccOrderClient;

    @Test
    public void findAccount(){
        TccAccountFindForm form = new TccAccountFindForm();
        form.setId(1);
        TccAccountFindResult result = tccAccountClient.find(form);
        LogUtil.info(log,"result={}",result);
    }

    @Test
    public void createOrder(){
        OrderSaveForm form = new OrderSaveForm();
        form.setAccountId(1);
        form.setAmount(BigDecimal.valueOf(99.99));
        form.setCreateTime(new Date());
        form.setIsDel(0);
        form.setType(1);
        form.setUpdateTime(new Date());
        form.setOrderSn(OrderUtil.createMessageId());
        form.setOrderStatus("INIT");
        OrderSaveResult result = tccOrderClient.save(form);
        LogUtil.info(log,"result={}",result);
    }

    /**
     * 调用Account 正常/异常情况
     * TCC事务调用测试
     */
    @Test
    public void tccRecord(){
        AccountTccFacadeForm form = new AccountTccFacadeForm();
        form.setId(999L);
        form.setAmount(BigDecimal.valueOf(987));
        String result = tccAccountClient.tccRecord(form);
        LogUtil.info(log,"result={}",result);
    }

    /**
     *
     * TCC-2组合调用情况--dubbo2个服务tcc调用
     *  调用Order正常，调用Account异常情况
     */
    @Test
    public void tccCompose2(){
        OrderSaveForm form = new OrderSaveForm();
        form.setAccountId(1);
        form.setAmount(BigDecimal.valueOf(99.99));
        form.setCreateTime(new Date());
        form.setIsDel(0);
        form.setType(1);
        form.setUpdateTime(new Date());
        form.setOrderSn(OrderUtil.createMessageId());
        form.setOrderStatus("INIT");
        tccOrderClient.tccSave(form);

        AccountTccFacadeForm form2 = new AccountTccFacadeForm();
        form2.setId(999L);
        form2.setAmount(BigDecimal.valueOf(987));
        String result = tccAccountClient.tccRecord(form2);
    }
    /**
     *
     * TCC-3组合调用情况--dubbo2个服务tcc调用 + 调用方本地tcc调用
     *  调用Order正常，调用Account异常情况
     */
    @Test
    public void tccCompose3(){

    }
}
