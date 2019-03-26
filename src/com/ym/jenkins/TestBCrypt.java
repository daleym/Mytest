package com.ym.jenkins;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @des  jenkins������� ��BCrypt�㷨��   
 * @author Administrator
 * ���ģ�$2a$10$UMQIk0CRh6aZI9aJtOIUbOo2i0HCxfr7SiYyFcNJS1b6NZsWovaJa
 *
 */
public class TestBCrypt {

	public static void main(String[] args) {

		//���Ǽ��ܷ�ʽ
        String hashed = BCrypt.hashpw("hello...world...", BCrypt.gensalt());
        System.out.println(hashed);

        //���ǽ��ܷ�ʽ
        if (BCrypt.checkpw("hello...world...", hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
		
	}

}
