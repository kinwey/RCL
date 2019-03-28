package com.kw.rcl.common.simpleext;

/**
 * @author kinwey
 * @Date 2019-03-28
 */
public class InvalidSimpleExtensionBeanException extends RuntimeException {
    public InvalidSimpleExtensionBeanException(){
        super();
    }


    public InvalidSimpleExtensionBeanException(String msg){
        super(msg);
    }
}
