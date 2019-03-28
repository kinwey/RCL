package com.kw.rcl.common.simpleext;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanInitializationException;

/**
 * @author kinwey
 * @Date 2019-03-28
 */
@Slf4j
public abstract class SimpleExtensionBeanManager {
    private static final ConcurrentMap<String, SimpleExtensionBean> BEAN_MAP = new ConcurrentHashMap<>();
    /**
     * 注册simpleExtensionBean
     * @param simpleExtensionBean bean对象
     */
    public static void register(SimpleExtensionBean simpleExtensionBean) {
        List<String> applicationScenes = simpleExtensionBean.applicationScenes();
        for (String applicationScene : applicationScenes) {
            String identifyKey = generateIdentifyKey(simpleExtensionBean.getExtensionInterfaceClass(),applicationScene);
            if (BEAN_MAP.containsKey(identifyKey)) {
                String errMsg = String.format("Extension point class[%s], bizType[%s] register conflicts. "
                        + "Please review your extension class canonical name and biz type.",
                    simpleExtensionBean.getExtensionInterfaceClass(), applicationScene);
                throw new BeanInitializationException(errMsg);
            }
            BEAN_MAP.put(identifyKey, simpleExtensionBean);
            log.info("applicationScene:{},beanInstance:{}",applicationScene,simpleExtensionBean.getClass().getName());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends SimpleExtensionBean> T beanOf(
        Class<T> clazz,String bizType) {
        String identifyKey = clazz.getName() + "_" + bizType;
        T extensionBean = (T)BEAN_MAP.get(identifyKey);
        if(null == extensionBean){
            identifyKey = clazz.getName() + "_" + SimpleExtensionBean.DEFAULT_APPLICATION_SCENE;
            extensionBean = (T)BEAN_MAP.get(identifyKey);
        }
        return extensionBean;
    }

    /**
     * 默认的bean识别key,用来辅助从SimpleExtensionBeanManager获取对应扩展实现
     * @param bizType
     * @return
     */
    private static <T extends SimpleExtensionBean> String generateIdentifyKey(Class<T> clazz, String bizType){
        return clazz.getName() + "_" + bizType;
    }
}
