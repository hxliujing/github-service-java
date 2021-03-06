/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.javens.java.filesystem;

import com.javens.java.hadoop.HadoopTools;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author liujing01
 * @version FileSystemCat.java, v 0.1 2018-11-22 14:12 
 */
public class FileSystemDoubleCat {
    public static void main(String[] args) throws IOException {
        String uri = args[0];
        FSDataInputStream is = HadoopTools.hdfs.open(new Path(uri));
        try{
            IOUtils.copyBytes(is,System.out,4096,false);
            //seek方法可以移动到文件中任意一个绝对位置
            is.seek(0);
            IOUtils.copyBytes(is,System.out,4096,false);
        }finally {
            IOUtils.closeStream(is);
        }
    }
}
