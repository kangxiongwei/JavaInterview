package com.kxw.xml;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by kangxiongwei on 2015/7/16.
 * 解析XML文件
 * 前提：不知道xml的具体格式，递归将所有节点打印出来
 */
public class ParseXML {

    public static void main(String[] args) throws Exception{

        String path = ParseXML.class.getResource("").getPath();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(path+"/canlidate.xml"));

        Element root = document.getDocumentElement();
        parseXML(root);
    }

    /**
     * 递归遍历xml，将解析结果打印
     * @param element
     */
    public static void parseXML(Element element) {
        //先打印标签
        System.out.print("<"+element.getTagName());
        //解析属性
        NamedNodeMap map = element.getAttributes();
        if(map != null) {
            for(int i=0; i<map.getLength(); i++){
                Node node = map.item(i);
                System.out.print(" " + node.getNodeName() + "=\"" + node.getNodeValue() + "\"");
            }
        }
        System.out.print(">");
        //解析子节点
        NodeList nodeList = element.getChildNodes();
        for (int i=0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(Element.ELEMENT_NODE == node.getNodeType()) {
                parseXML((Element)node);
            } else {
                //内容
                System.out.print(node.getNodeValue());
            }
        }
        System.out.print("</"+element.getNodeName()+">");
    }


}
