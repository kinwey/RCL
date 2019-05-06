package com.kw.rcl.common.effectivejava.lambdaandstream;

import java.util.Map;

/**
 * 方法引用比lambda更简洁
 * @author kinwey
 * @Date 2019-04-27
 */
public class MethodReferenceInsteadOfLambda {
    void methodReference(Map<String,Integer> map){
        map.merge("key",1,(count,incr) -> count + incr);

        //方法引用取代lambda函数
        map.merge("key",1,Integer::sum);
    }
}
