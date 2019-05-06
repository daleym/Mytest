package com.ym.jenkins;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @des  jenkins������� ��BCrypt�㷨��   
 * @author Administrator
 * ���ģ�$2a$10$Aa3l1Il6ZivZFYRcYEFXKOJEw.ua0IcgLix1YltynPK22e/y.Zzvu     zyxr123456
 *
 */
public class TestBCrypt {

	public static void main(String[] args) {
		String pwd = "zyxr123456";
		//���Ǽ��ܷ�ʽ
        String hashed = BCrypt.hashpw( pwd , BCrypt.gensalt());
        System.out.println(hashed);

        //���ǽ��ܷ�ʽ
        if (BCrypt.checkpw(pwd , hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
		
	}

}
