/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author liujing01
 * @version ListCapacity.java, v 0.1 2018-10-24 08:21 
 */
public class ListCapacityTest {
    List<Integer> list = PowerMockito.spy(new ArrayList<Integer>());
    private  void capacity(int size){
        for(int i=0;i<size;i++){
            list.add(i);
        }
    }

    @Test
    public void test_capacity() throws Exception {
        when(list.add(anyInt())).thenReturn(true);
        //PowerMockito.doNothing().when(list, "grow", any(Integer.class));
        capacity(64);
        verify(list,times(64)).add(any(Integer.class));
        //PowerMockito.verifyPrivate(list, times(2)).invoke("grow", any(Integer.class));

    }
}
