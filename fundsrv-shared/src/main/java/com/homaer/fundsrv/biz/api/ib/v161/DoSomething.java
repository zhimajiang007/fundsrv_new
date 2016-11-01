package com.homaer.fundsrv.biz.api.ib.v161;

/**  
* 实现Runnable接口的类  
*  
* @author leizhimin 2008-9-13 18:12:10  
*/   
public class DoSomething implements Runnable {   
    private String name;   
  
    public DoSomething(String name) {   
        this.name = name;   
    }   
  
    public void run() {   
        for (int i = 0; i < 5; i++) {   
            for (long k = 0; k < 100000000; k++) ;
            try {
				Thread.sleep(200);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(name + ": " + i);   
        }   
    }   
} 
