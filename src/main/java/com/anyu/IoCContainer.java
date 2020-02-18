package com.anyu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
/*1.实例化一个bean
  2.保存bean
  3.提供bean
  4.每一个bean有一个与之独一无二的id
*/
public class IoCContainer {
    private ConcurrentHashMap<String,Object> beans=new ConcurrentHashMap<String, Object>();

    /**
     * 从IOC容器得到bean
     * @param beanId 所需要bean的id
     * @return 返回bean
     */
    public Object getBeans(String beanId){
        return beans.get(beanId);
    }

    /**
     * 委托IOC容器创建一个bean
     * @param clazz 创建bean所需要的类
     * @param beanId bean的id
     * @param paras 创建bean的class所需要参数的beanID们
     */
    public void setBeans(Class<?> clazz,String beanId,String... paras)  {
        //组装创建bean的构造函数的参数值
        Object[] params=new Object[paras.length];
        for (int i=0;i<paras.length;i++) {
            params[i]=beans.get(paras[i]);
        }
        //调用构造方法实例化bean
        Object bean=null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean=constructor.newInstance(params);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (bean==null){
            throw new RuntimeException("找不到合适的构造方法实例化bean");
        }
        //将实例化的bean放入IOC容器
        beans.put(beanId,bean);

    }
}
