package com.homaer.fundsrv.biz.api.ib.v161;


/**  
* 测试Runnable类实现的多线程程序  
*  
* @author leizhimin 2008-9-13 18:15:02  
*/   
public class TestRunnable {   
    public static void main(String[] args) throws InterruptedException {   
        DoSomething ds1 = new DoSomething("阿三");   
        DoSomething ds2 = new DoSomething("李四");   
  
        System.out.println("---any U where i will follow U, say something I gaving up U , an");
        Thread t1 = new Thread(ds1);   
        Thread t2 = new Thread(ds2);   
  
        t1.start();  
        for (int i = 0; i < 10; i++) {
			Thread.sleep(300);
			 System.out.println("---");
		}
       
        t2.start();   
    }   
} 