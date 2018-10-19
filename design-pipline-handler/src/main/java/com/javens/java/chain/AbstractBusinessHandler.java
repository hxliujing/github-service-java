/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;

import com.javens.java.chain.AbstractHandlerContext;
import com.javens.java.chain.Handler;
import com.javens.java.chain.HandlerContext;
import com.javens.java.chain.HandlerRequest;
import com.javens.java.chain.HandlerResult;
import com.javens.java.chain.HandlerResultEnum;
import org.springframework.util.StringUtils;

/**
 *
 * @author liujing01
 * @version AbstractBusinessHandler.java, v 0.1 2018-10-19 12:01 
 */
public abstract class AbstractBusinessHandler implements Handler{

    @Override
    public void handlerAdded(HandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerRemoved(HandlerContext ctx) throws Exception {

    }

    @Override
    public HandlerResult process(HandlerContext ctx) throws Exception {
        AbstractHandlerContext nextCtx = ((AbstractHandlerContext) ctx).next;
        HandlerRequest model = ctx.data();
        HandlerResult handlerResult = doProcess(ctx.data());
        if(handlerResult==null || handlerResult.getCode() != HandlerResultEnum.SUCCESS.getCode()){
            return handlerResult;
        }
        model.setResult(handlerResult);
        nextCtx.setData(model);
        return ((AbstractHandlerContext) ctx).next.handler().process(nextCtx);
    }

    /**
     * 主要逻辑处理点
     * @param request
     * @return
     */
    protected abstract HandlerResult doProcess(HandlerRequest request);
}
