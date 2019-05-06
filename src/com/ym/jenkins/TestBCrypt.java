package com.ym.jenkins;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @des  jenkins密码加密 （BCrypt算法）   
 * @author Administrator
 * 密文：$2a$10$Aa3l1Il6ZivZFYRcYEFXKOJEw.ua0IcgLix1YltynPK22e/y.Zzvu     zyxr123456
 *
 */
public class TestBCrypt {

	public static void main(String[] args) {
		String pwd = "zyxr123456";
		//这是加密方式
        String hashed = BCrypt.hashpw( pwd , BCrypt.gensalt());
        System.out.println(hashed);

        //这是解密方式
        if (BCrypt.checkpw(pwd , hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
		
	}

}
