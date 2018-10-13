/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;


import com.javens.java.chain.internal.ObjectUtil;

/**
 *
 * @author liujing01
 * @version AbstractChannelHandlerContext.java, v 0.1 2018-10-12 10:59 
 */
abstract class AbstractHandlerContext implements HandlerContext{
    volatile AbstractHandlerContext next;
    private final String name;


    volatile AbstractHandlerContext prev;

    private final DefaultPipeline pipeline;
    private static final int INIT = 0;
    private static final int ADD_PENDING = 1;
    private static final int ADD_COMPLETE = 2;
    private static final int REMOVE_COMPLETE = 3;

    private volatile int handlerState = INIT;

    AbstractHandlerContext(DefaultPipeline pipeline,String name){
        this.name = ObjectUtil.checkNotNull(name, "name");
        this.pipeline = pipeline;
    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public Pipeline pipeline() {
        return pipeline;
    }

    final void setRemoved() {
        handlerState = REMOVE_COMPLETE;
    }
}
