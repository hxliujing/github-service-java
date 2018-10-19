/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain.handler;

import com.javens.java.chain.AbstractHandlerContext;
import com.javens.java.chain.DefaultHandlerContext;
import com.javens.java.chain.Handler;
import com.javens.java.chain.HandlerContext;
import com.javens.java.chain.HandlerModel;
import com.javens.java.chain.HandlerResult;
import com.javens.java.chain.handler.model.BusinessModel;
import com.javens.java.chain.internal.StringUtil;

import java.util.UUID;

/**
 *
 * @author liujing01
 * @version Business1Handler.java, v 0.1 2018-10-13 10:22 
 */
public class Business3Handler implements Handler{
    @Override
    public void handlerAdded(HandlerContext ctx) throws Exception {
       // System.out.println("handlerAdded===="+ StringUtil.simpleClassName(ctx.handler()));
    }

    @Override
    public void handlerRemoved(HandlerContext ctx) throws Exception {
        //System.out.println("handlerRemoved===="+ StringUtil.simpleClassName(ctx.handler()));
    }

    @Override
    public HandlerResult process(HandlerContext ctx) throws Exception {
        if(ctx.data() instanceof  BusinessModel){
            BusinessModel model1 = (BusinessModel)ctx.data();
            model1.setID(UUID.randomUUID().toString());
            System.out.println(model1.getID());
        }
        System.out.println(StringUtil.simpleClassName(ctx.handler())+" Start!");

        AbstractHandlerContext nextCtx = ((AbstractHandlerContext) ctx).next;
        ctx.data().getResult().setResult(ctx.data().getResult()+ StringUtil.simpleClassName(ctx.handler()));
        nextCtx.setData(ctx.data());
        return ((AbstractHandlerContext) ctx).next.handler().process(nextCtx);
    }
}
