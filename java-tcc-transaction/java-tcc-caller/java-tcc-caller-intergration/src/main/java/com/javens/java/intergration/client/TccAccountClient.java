/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.javens.java.intergration.client;

import com.javens.java.intergration.client.domain.form.AccountTccFacadeForm;
import com.javens.java.intergration.client.domain.form.TccAccountFindForm;
import com.javens.java.intergration.client.domain.form.TccAccountUpdateForm;
import com.javens.java.intergration.client.domain.result.TccAccountFindResult;
import com.javens.java.intergration.client.domain.result.TccAccountUpdateResult;

/**
 *
 * @author liujing01
 * @version TccAccountClient.java, v 0.1 2019-01-02 14:52 
 */
public interface TccAccountClient {
    /**
     * 更新账户信息
     * @param form
     * @return
     */
    TccAccountUpdateResult update(TccAccountUpdateForm form);

    /**
     * 查找账号
     * @param form
     * @return
     */
    TccAccountFindResult find(TccAccountFindForm form);

    /**
     * TCC事务调用
     * @param form
     * @return
     */
    public String tccRecord(AccountTccFacadeForm form);
}
