/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;


import java.util.List;

/**
 *
 * @author liujing01
 * @version Pipeline.java, v 0.1 2018-10-12 10:48 
 */
public interface Pipeline {

    Pipeline addFirst(String name, Handler handler);

    Pipeline addLast(String name, Handler handler);

    Pipeline addBefore(String baseName, String name, Handler handler);

    Pipeline addAfter(String baseName, String name, Handler handler);

    Pipeline addFirst(Handler... handlers);


    Pipeline addLast(Handler... handlers);


    Pipeline remove(Handler handler);

    Pipeline runHandlers() throws Exception;

    Handler remove(String name);

    <T extends Handler> T remove(Class<T> handlerType);

    Handler removeFirst();

    Handler removeLast();

    Handler first();

    Handler last();

    Handler get(String name);
    <T extends Handler> T get(Class<T> handlerType);

    HandlerContext context(String name);
    HandlerContext context(Handler handler);
    HandlerContext context(Class<? extends Handler> handlerType);
    HandlerContext firstContext();
    HandlerContext lastContext();

    List<String> names();

    int getProcessNumber();
    void setProcessNumber(int num);
}
