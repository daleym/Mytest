package com.ym.thread.unlock;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * CVS�������ԣ��̰߳�ȫ֮UnSafe
 * @author Administrator
 *
 */
public class UnSafeDemo {

	public  static  void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // ͨ������õ�theUnsafe��Ӧ��Field����
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // ���ø�FieldΪ�ɷ���
        field.setAccessible(true);
        // ͨ��Field�õ���Field��Ӧ�ľ�����󣬴���null����Ϊ��FieldΪstatic��
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);

        //ͨ��allocateInstanceֱ�Ӵ�������
        User user = (User) unsafe.allocateInstance(User.class);

        Class userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field age = userClass.getDeclaredField("age");
        Field id = userClass.getDeclaredField("id");

        //��ȡʵ������name��age�ڶ����ڴ��е�ƫ����������ֵ
        unsafe.putInt(user,unsafe.objectFieldOffset(age),18);
        unsafe.putObject(user,unsafe.objectFieldOffset(name),"android TV");

        // ���ﷵ�� User.class��
        Object staticBase = unsafe.staticFieldBase(id);
        System.out.println("staticBase:"+staticBase);

        //��ȡ��̬����id��ƫ����staticOffset
        long staticOffset = unsafe.staticFieldOffset(userClass.getDeclaredField("id"));
        //��ȡ��̬������ֵ
        System.out.println("����ǰ��ID:"+unsafe.getObject(staticBase,staticOffset));
        //����ֵ
        unsafe.putObject(staticBase,staticOffset,"SSSSSSSS");
        //��ȡ��̬������ֵ
        System.out.println("����ǰ��ID:"+unsafe.getObject(staticBase,staticOffset));
        //���USER
        System.out.println("���USER:"+user.toString());

        long data = 1000;
        byte size = 1;//��λ�ֽ�

        //����allocateMemory�����ڴ�,����ȡ�ڴ��ַmemoryAddress
        long memoryAddress = unsafe.allocateMemory(size);
        //ֱ�����ڴ�д������
        unsafe.putAddress(memoryAddress, data);
        //��ȡָ���ڴ��ַ������
        long addrData=unsafe.getAddress(memoryAddress);
        System.out.println("addrData:"+addrData);

        /**
         * ������:
         sun.misc.Unsafe@6f94fa3e
         staticBase:class geym.conc.ch4.atomic.User
         ����ǰ��ID:USER_ID
         ����ǰ��ID:SSSSSSSS
         ���USER:User{name='android TV', age=18', id=SSSSSSSS'}
         addrData:1000
         */

    }
}

class User{
    public User(){
        System.out.println("user ���췽��������");
    }
    private String name;
    private int age;
    private static String id="USER_ID";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                ", id=" + id +'\'' +
                '}';
    }
	
}
