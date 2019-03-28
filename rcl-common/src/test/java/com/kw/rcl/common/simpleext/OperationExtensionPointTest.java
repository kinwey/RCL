package com.kw.rcl.common.simpleext;

import com.kw.rcl.common.simpleext.sample.OperatorExtensionPoint;
import com.kw.rcl.common.util.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author kinwey
 * @Date 2019-03-28
 */
public class OperationExtensionPointTest extends BaseTest {
    private Long a,b;
    private OperatorExtensionPoint operatorExtensionPoint;

    //given
    @Before
    public void setUp(){
        a = 100L;
        b = 50L;
    }

    @Test
    public void testAdd(){
        //when ADD
        operatorExtensionPoint = SimpleExtensionBeanManager.beanOf(
            OperatorExtensionPoint.class,"ADD");
        //Then
        Assert.assertTrue(operatorExtensionPoint.operate(a,b).equals(a+b));
    }

    @Test
    public void testSub(){
        //when SUB
        operatorExtensionPoint = SimpleExtensionBeanManager.beanOf(
            OperatorExtensionPoint.class,"SUB");
        //Then
        Assert.assertTrue(operatorExtensionPoint.operate(a,b).equals(a-b));
    }
}
