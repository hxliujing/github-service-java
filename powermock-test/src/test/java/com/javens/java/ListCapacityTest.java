/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liujing01
 * @version ListCapacity.java, v 0.1 2018-10-24 08:21 
 */
public class ListCapacityTest {
    List<Integer> list = new ArrayList<>();
    public void capacity(int size){
        for(int i=0;i<size;i++){
            list.add(i);
        }
    }

    @Test
    public void test_capacity(){
        capacity(64);
    }
}
