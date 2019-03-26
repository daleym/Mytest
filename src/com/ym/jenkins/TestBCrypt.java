package com.ym.jenkins;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @des  jenkins密码加密 （BCrypt算法）   
 * @author Administrator
 * 密文：$2a$10$UMQIk0CRh6aZI9aJtOIUbOo2i0HCxfr7SiYyFcNJS1b6NZsWovaJa
 *
 */
public class TestBCrypt {

	public static void main(String[] args) {

		//这是加密方式
        String hashed = BCrypt.hashpw("hello...world...", BCrypt.gensalt());
        System.out.println(hashed);

        //这是解密方式
        if (BCrypt.checkpw("hello...world...", hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
		
	}

}
