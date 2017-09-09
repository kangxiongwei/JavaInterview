package com.kxw.spring.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * Spring源码查看
 * Created by kangxiongwei3 on 2017/5/23 14:37.
 */
@Component
public class SpringSourceTest {
    private static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    /**
     * IoC的建立过程
     */
    @Test
    public void testBeanFactory() {
        //指定资源位置
        ClassPathResource resource = new ClassPathResource("beans.xml");
        //
        //XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
        //创建工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //创建XML的读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        //将resource的内容载入到内存，变成对象
        reader.loadBeanDefinitions(resource);

        World world = factory.getBean("world", World.class);
        System.out.println(world);

        World worldCache = factory.getBean("world", World.class);
        System.out.println(worldCache);
    }

}
