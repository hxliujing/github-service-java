/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 *
 * @author liujing01
 * @version HadoopTools.java, v 0.1 2018-11-22 10:11 
 */
public class HadoopTools {
    public static Configuration configuration;
    public static FileSystem hdfs;
    static {
        configuration = new Configuration();
        String path ="/Users/liujing/Documents/server/hadoop-2.8.5/etc/hadoop/";
        configuration.addResource(new Path(path + "core-site.xml"));
        configuration.addResource(new Path(path + "hdfs-site.xml"));
        configuration.addResource(new Path(path + "mapred-site.xml"));
        try {
            hdfs =FileSystem.get(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * list all files
     * @param dirName
     * @throws IOException
     */
    public static void listFiles(String dirName)throws IOException {
        Path f = new Path(dirName);
        FileStatus[] status =hdfs.listStatus(f);
        System.out.println(dirName +" has all files:");
        for (int i = 0; i<status.length; i++) {
            System.out.println(status[i].getPath().toString());
        }
    }

    /**
     * create a new file
     * @param fileName
     * @param fileContent
     * @throws IOException
     */
    public static void createFile(String fileName,String fileContent) throws IOException {
        Path dst = new Path(fileName);
        byte[] bytes =fileContent.getBytes();
        FSDataOutputStream output =hdfs.create(dst);
        output.write(bytes);
        System.out.println("newfile \t" + configuration.get("fs.default.name") + fileName);
    }

    /**
     * create a direction
     * @param dir
     * @throws IOException
     */
    public static void createDir(String dir)throws IOException {
        Path path = new Path(dir);
        hdfs.mkdirs(path);
        System.out.println("newdir \t" + configuration.get("fs.default.name") + dir);
    }

    /**
     * copy from local file to HDFS file
     * @param localSrc
     * @param hdfsDst
     * @throws IOException
     */
    public static void copyFile(String localSrc,String hdfsDst) throws IOException{
        Path src = new Path(localSrc);
        Path dst = new Path(hdfsDst);
        hdfs.copyFromLocalFile(src,dst);

        //list all the files in thecurrent direction
        FileStatus files[] =hdfs.listStatus(dst);
        System.out.println("Uploadto \t" + configuration.get("fs.default.name") + hdfsDst);
        for (FileStatus file : files){
            System.out.println(file.getPath());
        }
    }


    /**
     * judge a file existed? and delete it!
     * @param fileName
     * @throws IOException
     */
    public static  void deleteFile(String fileName)throws IOException {
        Path f = new Path(fileName);
        boolean isExists =hdfs.exists(f);
        //if exists, delete
        if (isExists) {
            boolean isDel =hdfs.delete(f,true);
            System.out.println(fileName+ "  delete? \t" + isDel);
        } else {
            System.out.println(fileName+ "  exist? \t" + isExists);
        }
    }


    public static void main(String[] args) throws IOException {
        //HadoopTools.createDir("/demo3");
        HadoopTools.createFile("/demo2/create_file.txt","create_file");
        HadoopTools.listFiles("/demo2");

    }
}
