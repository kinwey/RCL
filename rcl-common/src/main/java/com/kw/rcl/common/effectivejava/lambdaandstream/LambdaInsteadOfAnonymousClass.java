package com.kw.rcl.common.effectivejava.lambdaandstream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 单个抽象方法的接口作为一类特殊接口，现在被称为函数接口(function interface),
 * java8利用lambda表达式来创建这类接口实例。比匿名类要更加简洁。
 * @author kinwey
 * @Date 2019-04-27
 */
public class LambdaInsteadOfAnonymousClass {

    void anonymous(List<String> words){
        Collections.sort(words,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
    }


    void lambda(List<String> words){
        Collections.sort(words,(o1,o2) -> Integer.compare(o1.length(),o2.length()));
    }

    void comparingInt(List<String> words){
        Collections.sort(words, Comparator.comparingInt(String::length));
    }

    void listSort(List<String> words){
        words.sort(Comparator.comparingInt(String::length));
    }
}
