/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;

/**
 *
 * @author liujing01
 * @version DefaultHandlerContext.java, v 0.1 2018-10-12 21:19 
 */
public class DefaultHandlerContext extends AbstractHandlerContext {
    private final Handler handler;
    DefaultHandlerContext(DefaultPipeline pipeline, String name,Handler handler) {
        super(pipeline, name);
        if (handler == null) {
            throw new NullPointerException("handler");
        }
        this.handler = handler;
    }

    @Override
    public Handler handler() {
        return handler;
    }

}
