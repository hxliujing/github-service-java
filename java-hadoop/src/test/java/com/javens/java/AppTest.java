package com.javens.java;

import static org.junit.Assert.assertTrue;

import com.javens.java.hadoop.HadoopTools;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 创建文件夹
     */
    @Test
    public void test_create_dir() throws IOException {
        HadoopTools.createDir("/demo3");
    }

    /**
     * 创建文件
     * @throws IOException
     */
    @Test
    public void test_create_file() throws IOException {
        HadoopTools.createFile("/demo2/create_file.txt","create_file\r\n中文\r\n");
    }

    /**
     * 查看文件列表
     * @throws IOException
     * result: hdfs://localhost/demo2/create_file.txt
     */
    @Test
    public void test_list_files() throws IOException {
        HadoopTools.listFiles("/demo2");
    }

    /**
     * 复制文件到HDFS
     * @throws IOException
     * hdfs://localhost/demo3/侣行-张昕宇.pdf
     */
    @Test
    public void test_copy_file() throws IOException {
        HadoopTools.copyFile("/Users/liujing/Downloads/侣行-张昕宇.pdf","/demo3");
    }

    /**
     * 读取文件内容
     * @throws IOException
     */
    @Test
    public void test_read_file() throws IOException{
        HadoopTools.readFile("/demo2/create_file.txt");
    }
}
