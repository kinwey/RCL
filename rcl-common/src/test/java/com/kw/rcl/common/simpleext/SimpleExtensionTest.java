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
public class SimpleExtensionTest extends BaseTest {
    private Long a,b;

    //given
    @Before
    public void setUp(){
        a = 100L;
        b = 50L;
    }

    @Test
    public void testAdd(){
        //when ADD
        OperatorExtensionPoint addOperatorExtension = SimpleExtensionBeanManager.beanOf(
            OperatorExtensionPoint.class,"ADD");
        //Then
        Assert.assertTrue(addOperatorExtension.operate(a,b).equals(a+b));
    }

    @Test
    public void testSub(){
        //when ADD
        OperatorExtensionPoint addOperatorExtension = SimpleExtensionBeanManager.beanOf(
            OperatorExtensionPoint.class,"SUB");
        //Then
        Assert.assertTrue(addOperatorExtension.operate(a,b).equals(a-b));
    }
}
