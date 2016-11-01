package com.homaer.fundsrv.ib;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.homaer.common.cache.CacheManager;
import com.homaer.common.utils.SpringContextUtil;
import com.homaer.fundsrv.module.ib.PositionsInfo;
import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;

/**  
* 实现Runnable接口的类  
*  
* @author changhai.wang 2008-9-13 18:12:10  
*/   
public class ReqPositions implements Runnable {
    private String account;
    
    private EWrapper objEwrapper;
    
    private EClientSocket objSocket;
//    private int reqId;
    @Autowired
	private CacheManager cacheManager = (CacheManager) SpringContextUtil.getBean("cacheManager");
  
    public ReqPositions(String account, EClientSocket objSocket, EWrapper objEwrapper) {   
        this.account = account;
        this.objEwrapper = objEwrapper;
        this.objSocket = objSocket;
    }  
  
    @SuppressWarnings("unchecked")
    public void run() {   
    	try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
		objSocket.cancelPositions();
		objEwrapper = (EWrapper) objSocket.wrapper();
    	
		List<PositionsInfo> lstPositionNew = new ArrayList<PositionsInfo>();

		System.out.println("缓存更新持仓时间11111==" + new Date());
    	if (null != cacheManager.get(account + "-newPositions")) {
    		lstPositionNew = (List<PositionsInfo>) cacheManager.get(account + "-newPositions");
		}else {
			System.out.println(account + "最新持仓数据获取为空1111" + new Date());
		}

    	cacheManager.set(account + "-oldPositions", 0, lstPositionNew);
		objEwrapper.getPositions(account);
		// objSocket.reqPositions();
		
    }   
} 
