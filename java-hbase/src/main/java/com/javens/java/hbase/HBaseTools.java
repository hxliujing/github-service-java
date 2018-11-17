/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liujing01
 * @version HBaseTools.java, v 0.1 2018-11-15 23:33 
 */
public class HBaseTools {
    public static Configuration configuration;
    static {
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        configuration.set("hbase.zookeeper.quorum", "127.0.0.1");
        configuration.set("hbase.master", "127.0.0.1:600000");
    }

    /**
     * 创建表
     * @param tableName
     * @param descriptors
     * @return
     */
    public static boolean createTable(String tableName,String ... descriptors) {
        try {
            HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);
            if (hBaseAdmin.tableExists(tableName)) {
                // 如果存在要创建的表，那么先删除，再创建
                //hBaseAdmin.disableTable(tableName);
                //hBaseAdmin.deleteTable(tableName);
                //System.out.println(tableName + " is exist,detele....");
                return false;
            }
            HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
            for(String descriptor : descriptors){
                tableDescriptor.addFamily(new HColumnDescriptor(descriptor));
            }
            hBaseAdmin.createTable(tableDescriptor);
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
            return false;
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void insert(String tableName,Put put) {
        HTablePool pool = new HTablePool(configuration, 1000);
        HTableInterface table =  pool.getTable(tableName);
        try {
            table.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean  dropTable(String tableName) {
        try {
            HBaseAdmin admin = new HBaseAdmin(configuration);
            if (admin.tableExists(tableName)) {
                admin.disableTable(tableName);
                admin.deleteTable(tableName);
                return true;
            }

        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteRow(String tablename, String rowkey)  {
        try {
            HTable table = new HTable(configuration, tablename);
            List list = new ArrayList();
            Delete d1 = new Delete(rowkey.getBytes());
            list.add(d1);
            table.delete(list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void queryByRowKey(String tableName,String rowKey) {
        HTablePool pool = new HTablePool(configuration, 1000);
        HTable table = (HTable) pool.getTable(tableName);
        try {
            // 根据rowkey查询
            Get scan = new Get(Bytes.toBytes(rowKey));
            Result r = table.get(scan);
            for (KeyValue keyValue : r.raw()) {
                System.out.println("列：" + new String(keyValue.getFamily())+ "====值:" + new String(keyValue.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void queryByFilter(String tableName,Filter filter) {
        try {
            HTablePool pool = new HTablePool(configuration, 1000);
            HTable table = (HTable) pool.getTable(tableName);
            /*Filter filter = new SingleColumnValueFilter(Bytes
                    .toBytes(family), Bytes.toBytes(qualifier), CompareFilter.CompareOp.EQUAL, Bytes
                    .toBytes(value)); */
            Scan s = new Scan();
            s.setFilter(filter);
            ResultScanner rs = table.getScanner(s);
            for (Result r : rs) {
                System.out.println("获得到rowkey:" + new String(r.getRow()));
                for (KeyValue keyValue : r.raw()) {
                    System.out.println("列：" + new String(keyValue.getFamily())
                            + "====值:" + new String(keyValue.getValue()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void queryByFilters(String tableName,Filter ... filters) {
        try {
            HTablePool pool = new HTablePool(configuration, 1000);
            HTable table = (HTable) pool.getTable(tableName);
            FilterList filterList1 = new FilterList(filters);
            Scan scan = new Scan();
            scan.setFilter(filterList1);
            ResultScanner rs = table.getScanner(scan);
            for (Result r : rs) {
                System.out.println("获得到rowkey:" + new String(r.getRow()));
                for (KeyValue keyValue : r.raw()) {
                    System.out.println("列：" + new String(keyValue.getFamily())
                            + "====值:" + new String(keyValue.getValue()));
                }
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    public static void queryAll(String tableName) {
        HTablePool pool = new HTablePool(configuration, 1000);
        HTableInterface table = pool.getTable(tableName);
        TableName tableName1 = table.getName();
        try {
            ResultScanner rs = table.getScanner(new Scan());
            for (Result r : rs) {
                System.out.println("获得到rowkey:" + new String(r.getRow()));
                for (KeyValue keyValue : r.raw()) {
                    System.out.println("列：" + new String(keyValue.getFamily())
                            + "====值:" + new String(keyValue.getValue()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
