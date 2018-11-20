package com.javens.study
/**
 * 方法
 */
class MethodGroovy {
    static def DisplayName() {
        println("This is how methods work in groovy");
        println("This is an example of a simple method");
    }
    static void sum(int a,int b) {
        int c = a+b;
        println(c);
    }
    static void sum2(int a,int b = 5) {
        int c = a+b;
        println(c);
    }


    static void main(String[] args){
        DisplayName();
        sum(3,5);
        sum2(6);
    }
}
