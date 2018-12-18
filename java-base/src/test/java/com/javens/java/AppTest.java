package com.javens.java;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.Lists;
import com.javens.java.singletion.Singleton;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    @Test
    public void testGetNum() {
        List<Future<Integer>> futures = Lists.newArrayList();
        for(int i=0;i<10;i++){
            Callable<Integer> callableObj = () -> { return Singleton.getSingleton().getNum(); };
            Future<Integer> future = pool.submit(callableObj);
            futures.add(future);
        }
        futures.parallelStream().forEach(item->{
            try {
                System.out.println(item.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    @Test
    public void testGetAtomicNum() {
        List<Future<Integer>> futures = Lists.newArrayList();
        for(int i=0;i<10;i++){
            Callable<Integer> callableObj = () -> { return Singleton.getSingleton().getAtomicNum(); };
            Future<Integer> future = pool.submit(callableObj);
            futures.add(future);
        }
        futures.parallelStream().forEach(item->{
            try {
                System.out.println(item.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
