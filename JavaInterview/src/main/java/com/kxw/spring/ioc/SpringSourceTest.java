package com.kxw.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //指定资源位置，指定了xml文件的位置，并且设置了一个默认的类加载器
        ClassPathResource resource = new ClassPathResource("beans.xml");
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

    @Test
    public void testAlias() {
        String nameAttr = "animal2, animal3, animal4";
        List<String> aliases = new ArrayList<String>();
        if (StringUtils.hasLength(nameAttr)) {
            String[] nameArr = StringUtils.tokenizeToStringArray(nameAttr, ",; ");
            aliases.addAll(Arrays.asList(nameArr));
        }
        System.out.println(aliases);
    }


    @Test
    public void testXmlParser() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(this.getClass().getClassLoader().getResource("").getPath() + "/beans.xml");
        Element element = document.getDocumentElement();
        System.out.println(element);
    }


}
