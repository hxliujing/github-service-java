package com.javens.java.facade;

import com.javens.java.facade.domain.request.AccountTccFacadeRequest;
import org.mengyun.tcctransaction.api.Compensable;

/**
 *事务方法
 * @author liujing01
 * @version AccountFacade.java, v 0.1 2019-01-02 11:24
 */
public interface AccountTccFacade {

    /**
     * 事务方法
     * @param request
     * @return
     */
    @Compensable
    public String record(AccountTccFacadeRequest request);

}
