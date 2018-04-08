package com.ym.thread.unlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 * @author Administrator
 *
 */
public class AtomicReferenceDemo2 {

	public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("zejian", 18);
        atomicUserRef.set(user);
        User updateUser = new User("Shine", 25);
        atomicUserRef.compareAndSet(user, updateUser);
        //执行结果:User{name='Shine', age=25}
              System.out.println(atomicUserRef.get().toString());  
              System.out.println(user);
    }

    static class User {
        public String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
	
}
