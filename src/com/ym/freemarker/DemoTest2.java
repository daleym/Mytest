package com.ym.freemarker;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DemoTest2 {
	
	private Configuration cfg;            //ģ�����ö��� 

    public void init() throws Exception { 
            //��ʼ��FreeMarker���� 
            //����һ��Configurationʵ�� 
            cfg = new Configuration(); 
            //����FreeMarker��ģ���ļ���λ�� 
            cfg.setDirectoryForTemplateLoading(new File("E:\\ZYXR\\tec\\buss-team\\my-git-workspace\\MyTest\\src")); 
    } 

    public void process() throws Exception { 
            //����������ݵ�Map 
            Map map = new HashMap(); 
            map.put("user", "lavasoft"); 
            map.put("url", "http://www.baidu.com/"); 
            map.put("name", "�ٶ�"); 
            //����ģ����� 
            Template t = cfg.getTemplate("test.ftl"); 
            //��ģ����ִ�в�ֵ��������������ƶ���������� 
            t.process(map, new OutputStreamWriter(System.out)); 
    } 

    public static void main(String[] args) throws Exception { 
            DemoTest2 hf = new DemoTest2(); 
            hf.init(); 
            hf.process(); 
    }
	
}
