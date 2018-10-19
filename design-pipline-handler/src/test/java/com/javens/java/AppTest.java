package com.javens.java;

import static org.junit.Assert.assertTrue;

import com.javens.java.chain.DefaultPipeline;
import com.javens.java.chain.HandlerResult;
import com.javens.java.chain.Pipeline;
import com.javens.java.chain.handler.Business1Handler;
import com.javens.java.chain.handler.Business2Handler;
import com.javens.java.chain.handler.Business3Handler;
import com.javens.java.chain.handler.model.BusinessModel;
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
        BusinessModel model = new BusinessModel();
        HandlerResult result = new HandlerResult();
        result.setResult("INIT");
        model.setResult(result);
        Pipeline pipeline = new DefaultPipeline(model);
        pipeline.addLast("first",new Business1Handler());
        pipeline.addLast("second",new Business2Handler());
        pipeline.addLast("third",new Business3Handler());
       // Handler handlerFirst = pipeline.get("first");
       // Handler handlerSecond = pipeline.get(Business2Handler.class);
        try {
            HandlerResult result2 = pipeline.doProcess();
            System.out.println(result2.getResult());
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
                Pipeline pipeline = new DefaultPipeline(new BusinessModel());
                pipeline.addLast("first",new Business1Handler());
                pipeline.addLast("second",new Business2Handler());
                pipeline.addLast("third",new Business3Handler());
                ai.incrementAndGet();
                try {
                    pipeline.doProcess();
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
