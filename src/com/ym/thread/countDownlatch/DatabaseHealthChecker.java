package com.ym.thread.countDownlatch;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthChecker
{
	private final static String serviceName = "database Service";
	private final static long sleepTime     = 10000;
	
    public DatabaseHealthChecker (CountDownLatch latch)  {
        super(serviceName , latch);
    }
 
    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
