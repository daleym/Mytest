package com.ym.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/** 
* @author ym: 
* @description 给定文件路径，按照行，读取内容
*/

public class TestReadFile {

	/** 
     * 以行为单位读取文件，常用于读面向行的格式化文件 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
//                System.out.print("line " + line + ": " + tempString);
                if(tempString.contains(" : ")){
                	System.out.print(tempString.split(" : ")[1]);
                }
                if(tempString.contains("create_time")){
                	System.out.println();
                }
                line++; 
                
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    } 
    
    public static void main(String[] args) {
		readFileByLines("D:\\A.txt");
	}
	
}
