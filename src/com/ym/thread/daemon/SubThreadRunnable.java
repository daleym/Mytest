package com.ym.thread.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class SubThreadRunnable implements Runnable{     
    public void run(){     
               try{     
                  Thread.sleep(1);//◊Ë»˚1√Î∫Û‘À––     
                  File f=new File("daemon.txt");     
                  FileOutputStream os=new FileOutputStream(f,true);     
                  os.write(String.format("daemon%s   " ,Thread.currentThread().getName() ).getBytes());     
           }     
               catch(IOException e1){     
          e1.printStackTrace();     
               }     
               catch(InterruptedException e2){     
                  e2.printStackTrace();     
           }     
    }     
}  
