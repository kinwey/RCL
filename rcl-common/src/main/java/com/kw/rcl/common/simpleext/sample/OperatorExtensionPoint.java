package com.kw.rcl.common.simpleext.sample;

import com.kw.rcl.common.simpleext.SimpleExtensionBean;

/**
 * @author kinwey
 * @Date 2019-03-28
 */
public interface OperatorExtensionPoint<T> extends SimpleExtensionBean {
    public T operate(T a,T b);
}
