package com.ym.jenkins;

import org.mindrot.jbcrypt.BCrypt;

public class Test {

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
