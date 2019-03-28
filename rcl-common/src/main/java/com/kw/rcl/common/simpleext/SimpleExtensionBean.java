package com.kw.rcl.common.simpleext;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author kinwey
 * @Date 2019-03-28
 */
public interface SimpleExtensionBean extends InitializingBean {
    String DEFAULT_APPLICATION_SCENE = "DEFAULT_APPLICATION_SCENE";

    /**
     * 获取扩展点接口名字
     * @return
     */
    default <T extends SimpleExtensionBean> Class<T> getExtensionInterfaceClass(){
        Class<?> currentClazz = this.getClass();
        Class<?>[] classes = currentClazz.getInterfaces();
        while (classes.length == 0) {
            currentClazz = currentClazz.getSuperclass();
            classes = currentClazz.getInterfaces();
        }
        for(Class clazz : classes){
            if(SimpleExtensionBean.class.isAssignableFrom(clazz)){
                return clazz;
            }
        }
        //never happen
        throw new RuntimeException(String.format("class:%s is not a SimpleExtensionBean", this.getClass().getName()));
    }

    /**
     * 扩展实现适用的场景
     * @return
     */
    List<String> applicationScenes();

    @Override
    default void afterPropertiesSet() throws Exception {

    }
}
