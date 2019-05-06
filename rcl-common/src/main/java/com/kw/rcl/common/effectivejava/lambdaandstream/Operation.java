package com.kw.rcl.common.effectivejava.lambdaandstream;

import java.util.function.DoubleBinaryOperator;

/**
 * lambda通过构造器注入并保存到枚举实例的成员变量中，
 * 减少重复的接口样板代码
 * lambda没有
 * @author kinwey
 * @Date 2019-04-27
 */
public enum  Operation {
    PLUS("+",(x,y) -> x + y),
    MINUS("+",(x,y) -> x - y),
    TIMES("+",(x,y) -> x * y),
    DIVIDE("+",(x,y) -> x / y);

    private final String symbol;

    private final DoubleBinaryOperator op;

    Operation(String symbol,DoubleBinaryOperator op){
        this.symbol=symbol;
        this.op=op;
    }

    public double apply(double x,double y){
        return op.applyAsDouble(x,y);
    }
}
