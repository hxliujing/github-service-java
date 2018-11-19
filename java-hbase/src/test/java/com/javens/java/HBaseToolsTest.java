package com.javens.java;

import static org.junit.Assert.assertTrue;

import com.javens.java.hbase.HBaseTools;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Unit test for simple App.
 */
public class HBaseToolsTest {

    /**
     * 创建表
     */
    @Test
    public void test_create_table(){
        HBaseTools.createTable("test");
    }

    @Test
    public void test_query_all_table(){
        HBaseTools.queryAll("test");
    }

    /**
     * 插入一条数据
     */
    @Test
    public void test_insert(){
        Put put = new Put(Bytes.toBytes("p001"));
        put.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier1"), Bytes.toBytes("liujing-q1"));
        put.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier2"), Bytes.toBytes("liujing-q2"));
      //  put.add(Bytes.toBytes("column2"), null, Bytes.toBytes(1));
      //  put.add(Bytes.toBytes("column3"), null, Bytes.toBytes(31));
        HBaseTools.insert("test",put);
    }

    /**
     * 插入多条数据
     */
    @Test
    public void test_inserts(){
        List<Put> list = new ArrayList<>();
        Put put1 = new Put(Bytes.toBytes("plist-001"));
        put1.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier1"), Bytes.toBytes("liujing-q1"));
        list.add(put1);
        Put put2 = new Put(Bytes.toBytes("plist-002"));
        put2.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier1"), Bytes.toBytes("liujing-q2"));
        list.add(put2);
        Put put3 = new Put(Bytes.toBytes("plist-002"));
        put3.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier2"), Bytes.toBytes("liujing-q3"));
        list.add(put3);

        HBaseTools.inserts("test",list);
    }


    /**
     * 插入多条数据，有某几条失败情况
     */
    @Test
    public void test_inserts_error(){
        List<Put> list = new ArrayList<>();
        Put put1 = new Put(Bytes.toBytes("plist-003"));
        put1.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier1"), Bytes.toBytes("liujing-q1"));
        list.add(put1);
        //不存在的列簇
        Put put2 = new Put(Bytes.toBytes("plist-004"));
        put2.add(Bytes.toBytes("JAVENS"), Bytes.toBytes("qualifier1"), Bytes.toBytes("liujing-q2"));
        list.add(put2);
        Put put3 = new Put(Bytes.toBytes("plist-004"));
        put3.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier2"), Bytes.toBytes("liujing-q3"));
        list.add(put3);

        HBaseTools.inserts("test",list);
    }

    @Test
    public void testObjectHashCode(){
        AtomicInteger i = new AtomicInteger(100);
        int hashcode = i.hashCode();
        byte[] ss = Bytes.toBytes(hashcode);
        System.out.println("byte array length:"+ ss.length);
        System.out.println(hashcode + "-->size: "+ String.valueOf(hashcode).length());
    }

}
