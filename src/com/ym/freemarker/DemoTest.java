package com.ym.freemarker;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DemoTest {
	
	public static void main(String[] args) throws IOException, TemplateException {
		 //����һ��ģ����� 
        Template t = new Template(null, new StringReader("�û�����${user};URL��    ${url};������ ��${name}"), null); 
        //������ֵ��Map 
        Map map = new HashMap(); 
        map.put("user", "lavasoft"); 
        map.put("url", "http://www.baidu.com/"); 
        map.put("name", "�ٶ�"); 
        //ִ�в�ֵ���������ָ����������� 
        t.process(map, new OutputStreamWriter(System.out)); 
	}
	
}
