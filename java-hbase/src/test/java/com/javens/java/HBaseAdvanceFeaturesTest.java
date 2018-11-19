/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java;

import com.javens.java.hbase.HBaseTools;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;

/**
 *
 * @author liujing01
 * @version HBaseAdvanceFeaturesTest.java, v 0.1 2018-11-18 22:27 
 */
public class HBaseAdvanceFeaturesTest {

    /**
     * 查看表缓冲区是否自动
     */
    @Test
    public void test_table_is_auto_flush(){
        HTableInterface table  = HBaseTools.getTable("test");
        System.out.println("缓冲区状态：" + table.isAutoFlush());
    }

    /**
     * 测试缓冲区
     */
    @Test
    public void test_table_buffer() throws IOException {
        HTableInterface table  = HBaseTools.getTable("test");
        System.out.println("Auto flush: " + table.isAutoFlush());

        table.setAutoFlush(false);
        System.out.println("Auto flush: " + table.isAutoFlush());


        Put put1 = new Put(Bytes.toBytes("p005"));
        put1.add(Bytes.toBytes("column1"),Bytes.toBytes("qualifier1"),Bytes.toBytes("buffer-test-1"));
        table.put(put1);


        Put put2 = new Put(Bytes.toBytes("p006"));
        put2.add(Bytes.toBytes("column1"),Bytes.toBytes("qualifier1"),Bytes.toBytes("buffer-test-2"));
        table .put(put2);


        Put put3 = new Put(Bytes.toBytes("p007"));
        put3.add(Bytes.toBytes("column1"),Bytes.toBytes("qualifier1"),Bytes.toBytes("buffer-test-3"));
        table .put(put3);


        // 根据rowkey查询
        Get scan = new Get(Bytes.toBytes("p005"));
        Result r = table.get(scan);
        for (KeyValue keyValue : r.raw()) {
            System.out.println("列：" + new String(keyValue.getFamily())+ "====值:" + new String(keyValue.getValue()));
        }

        table.flushCommits();
        r = table.get(scan);
        for (KeyValue keyValue : r.raw()) {
            System.out.println("列：" + new String(keyValue.getFamily())+ "====值:" + new String(keyValue.getValue()));
        }
    }
}
