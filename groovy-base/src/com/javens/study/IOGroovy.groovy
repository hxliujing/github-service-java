package com.javens.study

/**
 * Groovy 文件I/O
 */
class IOGroovy {
    static void main(String[] args){

        //读取文件
        String fileName = "/Users/liujing/Downloads/111.txt";
        new File(fileName).eachLine {
            line -> println "line : $line";
        }

        //读取文件的内容到字符串
        File file = new File(fileName);
        println file.text;

        //写入文件
        new File(fileName).withWriter('utf-8') {
            writer -> writer.writeLine 'Hello World'
        }

       // 获取文件的大小
        println "The file ${file.absolutePath} has ${file.length()} bytes"
        println "File? ${file.isFile()}"
        println "Directory? ${file.isDirectory()}"
    }
}
