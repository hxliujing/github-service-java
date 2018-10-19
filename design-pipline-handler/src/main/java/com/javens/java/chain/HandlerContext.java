/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;


/**
 *
 * @author liujing01
 * @version HandlerContext.java, v 0.1 2018-10-12 10:47 
 */
public interface HandlerContext {
    Pipeline pipeline();

    String name();

    Handler handler();

    HandlerModel data();
    void setData(HandlerModel model);
   // boolean isRemoved();
}
