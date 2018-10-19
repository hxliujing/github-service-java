/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.chain;


import com.javens.java.chain.internal.StringUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author liujing01
 * @version DefaultPipeline.java, v 0.1 2018-10-12 10:58 
 */
public class DefaultPipeline implements  Pipeline {
    final AbstractHandlerContext head;
    final AbstractHandlerContext tail;
    volatile  HandlerModel model;
    private static final String HEAD_NAME = generateName0(HeadContext.class);
    private static final String TAIL_NAME = generateName0(TailContext.class);
    private static final ThreadLocal<Map<Class<?>, String>> nameCaches = new ThreadLocal<>();

    private int processNumber;
    public DefaultPipeline(HandlerModel model){
        tail = new TailContext(this);
        head = new HeadContext(this);
        head.next = tail;
        tail.prev = head;
        this.model = model;
    }


    @Override
    public Pipeline addFirst(String name, Handler handler) {
        final AbstractHandlerContext newCtx;
        synchronized (this) {
            name = filterName(name, handler);
            newCtx = newContext( name, handler);
            addFirst0(newCtx);
        }
        callHandlerAdded0(newCtx);
        return this;
    }




    @Override
    public Pipeline addLast(String name, Handler handler) {
        final AbstractHandlerContext newCtx;
        synchronized (this) {
            name = filterName(name, handler);
            newCtx = newContext( name, handler);
            addLast0(newCtx);
        }
        callHandlerAdded0(newCtx);
        return this;
    }


    @Override
    public Pipeline addBefore(String baseName, String name, Handler handler) {
        final AbstractHandlerContext newCtx;
        final AbstractHandlerContext ctx;
        synchronized (this) {
            ctx = getContextOrDie(baseName);
            name = filterName(name, handler);
            newCtx = newContext( name, handler);
            addBefore0(ctx, newCtx);
        }
        callHandlerAdded0(newCtx);
        return this;
    }


    @Override
    public final HandlerContext context(Handler handler) {
        if (handler == null) {
            throw new NullPointerException("handler");
        }
        AbstractHandlerContext ctx = head.next;
        for (;;) {
            if (ctx == null) {
                return null;
            }
            if (ctx.handler() == handler) {
                return ctx;
            }
            ctx = ctx.next;
        }
    }

    @Override
    public final HandlerContext context(Class<? extends Handler> handlerType) {
        if (handlerType == null) {
            throw new NullPointerException("handlerType");
        }
        AbstractHandlerContext ctx = head.next;
        for (;;) {
            if (ctx == null) {
                return null;
            }
            if (handlerType.isAssignableFrom(ctx.handler().getClass())) {
                return ctx;
            }
            ctx = ctx.next;
        }
    }

    @Override
    public final HandlerContext context(String name) {
        if (name == null) {
            throw new NullPointerException("name");
        }
        return context0(name);
    }

    @Override
    public Pipeline addAfter(String baseName, String name, Handler handler) {
        final AbstractHandlerContext newCtx;
        final AbstractHandlerContext ctx;
        synchronized (this) {
            ctx = getContextOrDie(baseName);
            name = filterName(name, handler);
            newCtx = newContext( name, handler);
            addAfter0(ctx, newCtx);
        }
        callHandlerAdded0(newCtx);
        return this;
    }


    @Override
    public Pipeline addFirst(Handler... handlers) {
        if (handlers == null) {
            throw new NullPointerException("handlers");
        }
        if (handlers.length == 0 || handlers[0] == null) {
            return this;
        }

        int size;
        for (size = 1; size < handlers.length; size ++) {
            if (handlers[size] == null) {
                break;
            }
        }

        for (int i = size - 1; i >= 0; i --) {
            Handler h = handlers[i];
            addFirst(null, h);
        }
        return this;
    }

    @Override
    public Pipeline addLast(Handler... handlers) {
        if (handlers == null) {
            throw new NullPointerException("handlers");
        }

        for (Handler h: handlers) {
            if (h == null) {
                break;
            }
            addLast( null, h);
        }

        return this;
    }

    @Override
    public final Pipeline remove(Handler handler) {
        remove(getContextOrDie(handler));
        return this;
    }

    @Override
    public HandlerResult doProcess() throws Exception {
        AbstractHandlerContext ctx = head.next;
        ctx.setData(model);
        return ctx.handler().process(ctx);

        /*AbstractHandlerContext ctx = head.next;
        for (;;) {
            if (ctx == tail) {
                break;
            }
            ctx.handler().process(ctx,model);
            ctx = ctx.next;
            if (ctx == tail) {
                break;
            }
        }
        return this;*/

    }

    @Override
    public final Handler remove(String name) {
        return remove(getContextOrDie(name)).handler();
    }


    @Override
    public <T extends Handler> T remove(Class<T> handlerType) {
        return (T) remove(getContextOrDie(handlerType)).handler();
    }

    @Override
    public Handler removeFirst() {
        if (head.next == tail) {
            throw new NoSuchElementException();
        }
        return remove(head.next).handler();
    }

    @Override
    public Handler removeLast() {
        if (head.next == tail) {
            throw new NoSuchElementException();
        }
        return remove(tail.prev).handler();
    }

    @Override
    public Handler first() {
        HandlerContext first = firstContext();
        if (first == null) {
            return null;
        }
        return first.handler();
    }

    @Override
    public Handler last() {
        AbstractHandlerContext last = tail.prev;
        if (last == head) {
            return null;
        }
        return last.handler();
    }

    @Override
    public Handler get(String name) {
        HandlerContext ctx = context(name);
        if (ctx == null) {
            return null;
        } else {
            return ctx.handler();
        }
    }

    @Override
    public <T extends Handler> T get(Class<T> handlerType) {
        HandlerContext ctx = context(handlerType);
        if (ctx == null) {
            return null;
        } else {
            return (T) ctx.handler();
        }
    }

    @Override
    public final HandlerContext firstContext() {
        AbstractHandlerContext first = head.next;
        if (first == tail) {
            return null;
        }
        return head.next;
    }

    @Override
    public final HandlerContext lastContext() {
        AbstractHandlerContext last = tail.prev;
        if (last == head) {
            return null;
        }
        return last;
    }

    @Override
    public List<String> names() {
        List<String> list = new ArrayList<String>();
        AbstractHandlerContext ctx = head.next;
        for (;;) {
            if (ctx == null) {
                return list;
            }
            list.add(ctx.name());
            ctx = ctx.next;
        }
    }

    @Override
    public final String toString() {
        StringBuilder buf = new StringBuilder()
                .append(StringUtil.simpleClassName(this))
                .append('{');
        AbstractHandlerContext ctx = head.next;
        for (;;) {
            if (ctx == tail) {
                break;
            }

            buf.append('(')
                    .append(ctx.name())
                    .append(" = ")
                    .append(ctx.handler().getClass().getName())
                    .append(')');

            ctx = ctx.next;
            if (ctx == tail) {
                break;
            }

            buf.append(", ");
        }
        buf.append('}');
        return buf.toString();
    }




    private void callHandlerAdded0(final AbstractHandlerContext ctx) {
        try {
            ctx.handler().handlerAdded(ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AbstractHandlerContext newContext(String name, Handler handler) {
        return new DefaultHandlerContext(this, name, handler);
    }



    private String filterName(String name,Handler handler){
        if(name==null){
            return generateName(handler);
        }
        checkDuplicateName(name);
        return name;
    }
    private void checkDuplicateName(String name) {
        if (context0(name) != null) {
            throw new IllegalArgumentException("Duplicate handler name: " + name);
        }
    }

    private String generateName(Handler handler) {
        Map<Class<?>, String> cache = nameCaches.get();
        Class<?> handlerType = handler.getClass();
        String name = cache.get(handlerType);
        if (name == null) {
            name = generateName0(handlerType);
            cache.put(handlerType, name);
        }

        // It's not very likely for a user to put more than one handler of the same type, but make sure to avoid
        // any name conflicts.  Note that we don't cache the names generated here.
        if (context0(name) != null) {
            String baseName = name.substring(0, name.length() - 1); // Strip the trailing '0'.
            for (int i = 1;; i ++) {
                String newName = baseName + i;
                if (context0(newName) == null) {
                    name = newName;
                    break;
                }
            }
        }
        return name;
    }





    private static String generateName0(Class<?> handlerType) {
        return StringUtil.simpleClassName(handlerType) + "#0";
    }


    private AbstractHandlerContext context0(String name){
        AbstractHandlerContext context = head.next;
        while(context != tail){
            if(context.name().equals(name)){
                return context;
            }
            context = context.next;
        }
        return null;
    }


    private void addFirst0(AbstractHandlerContext newCtx) {
        AbstractHandlerContext nextCtx = head.next;
        newCtx.prev = head;
        newCtx.next = nextCtx;
        head.next = newCtx;
        nextCtx.prev = newCtx;
    }

    private void addLast0(AbstractHandlerContext newCtx) {
        AbstractHandlerContext prev = tail.prev;
        newCtx.prev = prev;
        newCtx.next = tail;
        prev.next = newCtx;
        tail.prev = newCtx;
    }

    private static void addBefore0(AbstractHandlerContext ctx, AbstractHandlerContext newCtx) {
        newCtx.prev = ctx.prev;
        newCtx.next = ctx;
        ctx.prev.next = newCtx;
        ctx.prev = newCtx;
    }

    private AbstractHandlerContext getContextOrDie(String name) {
        AbstractHandlerContext ctx = (AbstractHandlerContext) context(name);
        if (ctx == null) {
            throw new NoSuchElementException(name);
        } else {
            return ctx;
        }
    }
    private AbstractHandlerContext getContextOrDie(Handler handler) {
        AbstractHandlerContext ctx = (AbstractHandlerContext) context(handler);
        if (ctx == null) {
            throw new NoSuchElementException(handler.getClass().getName());
        } else {
            return ctx;
        }
    }

    private AbstractHandlerContext getContextOrDie(Class<? extends Handler> handlerType) {
        AbstractHandlerContext ctx = (AbstractHandlerContext) context(handlerType);
        if (ctx == null) {
            throw new NoSuchElementException(handlerType.getName());
        } else {
            return ctx;
        }
    }




    private static void addAfter0(AbstractHandlerContext ctx, AbstractHandlerContext newCtx) {
        newCtx.prev = ctx;
        newCtx.next = ctx.next;
        ctx.next.prev = newCtx;
        ctx.next = newCtx;
    }



    private AbstractHandlerContext remove(final AbstractHandlerContext ctx) {
        assert ctx != head && ctx != tail;
        synchronized (this) {
            remove0(ctx);
        }
        callHandlerRemoved0(ctx);
        return ctx;
    }
    private static void remove0(AbstractHandlerContext ctx) {
        AbstractHandlerContext prev = ctx.prev;
        AbstractHandlerContext next = ctx.next;
        prev.next = next;
        next.prev = prev;
    }
    private void callHandlerRemoved0(final AbstractHandlerContext ctx) {
            try {
                ctx.handler().handlerRemoved(ctx);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ctx.setRemoved();
            }
    }




    final class TailContext extends AbstractHandlerContext implements  Handler{

        TailContext(DefaultPipeline pipeline) {
            super(pipeline,TAIL_NAME);
        }

        @Override
        public Handler handler() {
            return this;
        }

        @Override
        public void handlerAdded(HandlerContext ctx) throws Exception {

        }

        @Override
        public void handlerRemoved(HandlerContext ctx) throws Exception {

        }

        @Override
        public HandlerResult process(HandlerContext ctx) throws Exception {
            return ctx.data().getResult();
        }


    }

    final class HeadContext extends AbstractHandlerContext implements  Handler{

        HeadContext(DefaultPipeline pipeline) {
            super(pipeline,HEAD_NAME);
        }


        @Override
        public Handler handler() {
            return this;
        }

        @Override
        public void handlerAdded(HandlerContext ctx) throws Exception {

        }

        @Override
        public void handlerRemoved(HandlerContext ctx) throws Exception {

        }

        @Override
        public HandlerResult process(HandlerContext ctx) throws Exception {
            return this.next.handler().process(ctx);
        }


    }
}
