/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *
 * @author liujing01
 * @version App2Test.java, v 0.1 2018-12-15 11:07 
 */
public class App2Test {
    @Test
    public void test(){
        int[][] ii = new int[2][2];
        ii[0][0] =1;
        ii[0][1] =2;
        ii[1][0] =3;
        ii[1][1] =4;
        System.out.println(JSON.toJSONString(ii));


        int[][][] iii = new int[2][2][2];
        iii[0][0][0]  = 0;
        iii[0][0][1]  = 1;
        iii[0][1][0]  = 2;
        iii[0][1][1]  = 3;

        iii[1][0][0]  = 4;
        iii[1][0][1]  = 5;
        iii[1][1][0]  = 6;
        iii[1][1][1]  = 7;
        System.out.println(JSON.toJSONString(iii));

    }

    @Test
    public void test3(){
        BigDecimal totalMoney = BigDecimal.valueOf(1.);
        BigDecimal rateFee = BigDecimal.valueOf(0.0045);
        BigDecimal income = totalMoney.multiply(BigDecimal.ONE.subtract(rateFee)).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(totalMoney.subtract(income));
    }
}
