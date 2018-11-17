package com.javens.java;

import static org.junit.Assert.assertTrue;

import com.javens.java.hbase.HBaseTools;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class HBaseToolsTest {

    @Test
    public void test_create_table(){
        HBaseTools.createTable("test");
    }

    @Test
    public void test_query_all_table(){
        HBaseTools.queryAll("test");
    }
    @Test
    public void test_insert(){
        Put put = new Put(Bytes.toBytes("p001"));
        put.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier1"), Bytes.toBytes("liujing-q1"));
        put.add(Bytes.toBytes("column1"), Bytes.toBytes("qualifier2"), Bytes.toBytes("liujing-q2"));
      //  put.add(Bytes.toBytes("column2"), null, Bytes.toBytes(1));
      //  put.add(Bytes.toBytes("column3"), null, Bytes.toBytes(31));
        HBaseTools.insert("test",put);
    }

}
