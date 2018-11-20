package com.javens.study

/**
 * Groovy变量
 * Groovy中的变量可以通过两种方式定义 - \
 * 使用数据类型的本地语法，或者使用def关键字。
 * 对于变量定义，必须明确提供类型名称或在替换中使用“def”。
 * 这是Groovy解析器需要的。
 */
class VariableGroovy {
    static void main(String[] args){
        // x is defined as a variable
        String x = "Hello";
        // The value of the variable is printed to the console
        println(x);

        // Defining a variable in lowercase
        int i = 5;

        // Defining a variable in uppercase
        int I = 6;

        // Defining a variable with the underscore in it's name
        def _Name = "Joe";

        println(i);
        println(I);
        println(_Name);
    }
}
