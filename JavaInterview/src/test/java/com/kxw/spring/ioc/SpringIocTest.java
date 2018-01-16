package com.kxw.spring.ioc;

import com.kxw.spring.ioc.subele.GetBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by kangxiongwei on 2018/1/15 10:17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class SpringIocTest {

    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    /**
     * 测试xml载入
     */
    @Test
    public void testLoadBeanDefinitions() {
        //指定资源位置，指定了xml文件的位置，并且设置了一个默认的类加载器
        ClassPathResource resource = new ClassPathResource("beans.xml");
        //创建工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //创建XML的读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        //将resource的内容载入到内存，变成对象
        reader.loadBeanDefinitions(resource);

        //实例化bean
        factory.getBean("world2");
    }

    /**
     * 测试depends-on属性
     */
    @Test
    public void testAttributeDependsOn() {
        Object obj = context.getBean("world2");
        System.out.println(obj);
    }

    /**
     * 测试bean的parent属性
     */
    @Test
    public void testAttributeParent() {
        Object obj = context.getBean("person2");
        System.out.println(obj.toString());

        Object person = context.getBean("person");
        System.out.println(person.toString());
    }

    /**
     * 测试bean的id属性
     * 不指定id和name属性时，默认的id名称为：
     * 第一个：类的全限定名
     * 第二个：类的全限定名#1
     * 第三个：类的全限定名#2
     * 以此类推...
     */
    @Test
    public void testAttributeId() {
        Object id1 = context.getBean("com.kxw.spring.ioc.Person");
        System.out.println(id1.toString());

        Object id2 = context.getBean("com.kxw.spring.ioc.Person#1");
        System.out.println(id2.toString());
    }

    /**
     * 测试bean的子元素lookup-method的作用
     */
    @Test
    public void testAttributeLookupMethod() {
        GetBean getBean = (GetBean) context.getBean("getBean");
        getBean.who();
    }

    /**
     * 测试bean的别名
     */
    @Test
    public void testAttributeName() {
        Object obj = context.getBean("person3");
        System.out.println(obj.toString());

        Object obj2 = context.getBean("person4");
        System.out.println(obj2.toString());

        Object obj3 = context.getBean("person5");
        System.out.println(obj3.toString());

        Object obj4 = context.getBean("person6");
        System.out.println(obj4.toString());
    }


}
