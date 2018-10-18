/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain.handler;

import com.javens.java.chain.DefaultPipeline;
import com.javens.java.chain.Handler;
import com.javens.java.chain.HandlerContext;
import com.javens.java.chain.HandlerModel;
import com.javens.java.chain.handler.model.BusinessModel;
import com.javens.java.chain.internal.StringUtil;

import java.util.UUID;

/**
 *
 * @author liujing01
 * @version Business1Handler.java, v 0.1 2018-10-13 10:22 
 */
public class Business2Handler  implements  Handler{

    @Override
    public void handlerAdded(HandlerContext ctx) throws Exception {
       // System.out.println("handlerAdded===="+ StringUtil.simpleClassName(ctx.handler()));
    }

    @Override
    public void handlerRemoved(HandlerContext ctx) throws Exception {
       // System.out.println("handlerRemoved===="+ StringUtil.simpleClassName(ctx.handler()));
    }

    @Override
    public void process(HandlerContext ctx, HandlerModel model) throws Exception {
        if(model instanceof BusinessModel){
            BusinessModel model1 = (BusinessModel)model;
            System.out.println(model1.getID());
        }
        System.out.println(StringUtil.simpleClassName(ctx.handler())+" Start!");
    }

}
