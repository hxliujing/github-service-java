/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;


/**
 *
 * @author liujing01
 * @version Handler.java, v 0.1 2018-10-12 10:49 
 */
public interface Handler {

    void handlerAdded(HandlerContext ctx) throws Exception;

    void handlerRemoved(HandlerContext ctx) throws Exception;

    void process(HandlerContext ctx,HandlerModel model) throws Exception;
}
