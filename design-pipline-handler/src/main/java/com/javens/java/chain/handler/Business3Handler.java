/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain.handler;

import com.javens.java.chain.AbstractBusinessHandler;
import com.javens.java.chain.HandlerRequest;
import com.javens.java.chain.HandlerResult;

/**
 *
 * @author liujing01
 * @version Business1Handler.java, v 0.1 2018-10-13 10:22 
 */
public class Business3Handler extends AbstractBusinessHandler {

    @Override
    protected HandlerResult doProcess(HandlerRequest request) {
        System.out.println("Business3Handler"+request.getResult());
        return request.getResult();
    }
}
