package com.ym.thread.countDownlatch;

/**
 * countDownlatch的应用：
 * 效果：在闭锁上面等待的主线程（TestMain）,
 *     会在三个子线程（CacheHealthChecker、DatabaseHealthChecker、NetworkHealthChecker）执行完毕后，继续执行！
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
