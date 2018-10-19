package com.javens.java;

import static org.junit.Assert.assertTrue;

import com.javens.java.chain.DefaultPipeline;
import com.javens.java.chain.HandlerRequest;
import com.javens.java.chain.HandlerResult;
import com.javens.java.chain.Pipeline;
import com.javens.java.chain.handler.Business1Handler;
import com.javens.java.chain.handler.Business2Handler;
import com.javens.java.chain.handler.Business3Handler;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void createPipeline(){
        HandlerRequest request = new HandlerRequest();
        Pipeline pipeline = new DefaultPipeline(request);
        pipeline.addLast("first",new Business1Handler());
        pipeline.addLast("second",new Business2Handler());
        pipeline.addLast("third",new Business3Handler());
        try {
            System.out.println("End:"+ pipeline.process());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThread() throws InterruptedException {
        AtomicInteger ai = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i=0;i<1000;i++){
            executorService.submit(()->{
                Pipeline pipeline = new DefaultPipeline(new HandlerRequest());
                pipeline.addLast("first",new Business1Handler());
                pipeline.addLast("second",new Business2Handler());
                pipeline.addLast("third",new Business3Handler());
                ai.incrementAndGet();
                try {
                    pipeline.process();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        if (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
            System.out.println("=======>" + ai.get());
            executorService.shutdown();
        }
    }
}
