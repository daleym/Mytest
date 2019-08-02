package com.ym.jar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/** 
* @author ym: 
* @version 创建时间：2019年8月1日 上午10:19:43 
* @description 扫描jar包中的类文件，并递归输出目录、文件全路径
*/

public class TestJarFileAccess {

	public static  String readFileFromJar(String jarPath ) throws IOException {  
        JarFile jf = new JarFile(jarPath);  
        Enumeration<JarEntry> jfs = jf.entries();  
        StringBuffer sb  = new StringBuffer();  
        int n =1;
        while(jfs.hasMoreElements())  
        {  
            JarEntry jfn = jfs.nextElement();  
            System.out.println(n +":"+ jfn.getName());
            n++;
        }  
        return sb.toString();  
    }  
	
	public static void main(String[] args)throws IOException {
		/**部分输出如下
			8222:com/zyxr/activity/register/RegisterRewardCouponEvent.class
			8223:com/zyxr/activity/register/OpenAccountRewardCouponEvent.class
			8224:com/zyxr/activity/util/ActivityUtils.class
			8225:com/zyxr/activity/config/CustomerConfig$5.class
			8226:com/zyxr/activity/config/CustomerConfig$9.class
			8227:com/zyxr/activity/config/CustomerConfig$13.class
			8228:com/zyxr/activity/config/CustomerConfig$17.class
			8229:com/zyxr/activity/config/CustomerConfig$16.class
			8230:com/zyxr/activity/config/CustomerConfig$12.class
			8231:com/zyxr/activity/config/CustomerConfig$8.class
			8232:com/zyxr/activity/config/CustomerConfig$4.class
			8233:com/zyxr/activity/config/CustomerConfig.class
		 */
		readFileFromJar("D:\\ActivitySchedule-0.0.1-SNAPSHOT.jar");
	}
	
}
