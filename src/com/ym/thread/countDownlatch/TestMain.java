package com.ym.thread.countDownlatch;

/**
 * countDownlatch��Ӧ�ã�
 * Ч�����ڱ�������ȴ������̣߳�TestMain��,
 *     �����������̣߳�CacheHealthChecker��DatabaseHealthChecker��NetworkHealthChecker��ִ����Ϻ󣬼���ִ�У�
 * @author ming.yang
 *
 */
public class TestMain {
    public static void main(String[] args)
    {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }
}
