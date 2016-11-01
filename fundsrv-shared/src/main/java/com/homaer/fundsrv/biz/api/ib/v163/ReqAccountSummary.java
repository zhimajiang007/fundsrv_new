package com.homaer.fundsrv.biz.api.ib.v163;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homaer.biz.framework.annotation.Api;
import com.homaer.biz.framework.api.OsType;
import com.homaer.common.cache.CacheManager;
import com.homaer.common.tools.jpush.JPushTool;
import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.common.tools.math.DateUtils;
import com.homaer.common.utils.SpringContextUtil;
import com.homaer.fundsrv.biz.api.AbstractApi;
import com.homaer.fundsrv.biz.apidata.ib.IbRequest;
import com.homaer.fundsrv.biz.apidata.ib.IbResponse;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.service.IbService;
import com.homaer.fundsrv.service.StockQueryService;
import com.homaer.service.ticker.bo.TickerBo;

import cn.jpush.api.push.model.Platform;


/**
 * 查询账户资产。全部资产、美元资产等等
 * 
 * 2016年3月10日
 * 
 * @author changhai.wang
 */
@Api(value = "/ib/reqAccountSummary", version = { "1.6.2" }, osType = { OsType.IOS, OsType.ANDROID })
public class ReqAccountSummary extends AbstractApi<IbResponse, IbRequest>
{
  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.API_LOGGER);
  @Autowired
  private IbService ibService;
  @Autowired
  private TickerBo ticketServer;
  @Autowired
  private StockQueryService stockQueryService;
  @Autowired
  private JPushTool pushTool;
  @SuppressWarnings("unused")
  private CacheManager cacheManager = (CacheManager) SpringContextUtil.getBean("cacheManager");


  @Override
  public IbResponse execute(IbRequest request)
  {
    IbResponse response = new IbResponse();
    MarketData objMarket = new MarketData();
    String needFresh = "0";
    // 参数判断
    // if (StringUtils.isEmpty(request.getAccount())) {
    // logger.info("getAccountValues传入Account为空！");
    // return response;
    // }
    try
    {
      // BigDecimal stockMarketValue = new BigDecimal("0");// 账户股票市值
      // BigDecimal unrealizedPnl = new BigDecimal("0");// 账户盈亏额
      // ibService.reqAccountSummary(request.getAccount());
      // 以下信息是测试数据
      // JPushTool push = (JPushTool) SpringUtil.getBean("pushTool");
      List<String> registrationIds = new ArrayList<String>();
      registrationIds.add("170976fa8a806d1aaf5");
      Map<String, String> extras = new HashMap<String, String>();
      // extras.put("tradeLogPage", "tradeLogPage");
      extras.put("tradeLogPage", "tradeLogPage");
      Calendar cal = Calendar.getInstance();
      cal.setTime(new Date());
      cal.add(Calendar.MINUTE, 1);
      String pushtime = DateUtils.getDateString(cal.getTime(), "yyyy-MM-dd HH:mm:ss");
      String message = "测试:您委托的“xx”股“股票代码”买单已成交，成本价“xxxx”";
      pushTool.pushMessage(pushtime, Platform.android_ios(), null, null, registrationIds, 1, message, message, message, extras, false);
      // ------------------------------推送
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    objMarket.setNeedFresh(needFresh);
    response.setMarketData(objMarket);
    // response.setLstMarket(lstMarket);
    return response;
  }
}
