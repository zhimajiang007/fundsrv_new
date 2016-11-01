package com.homaer.fundsrv.biz.api.ib;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class test {
	
	@SuppressWarnings("static-access")
  public static void main(String[] args) throws ParseException {
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar calendar = Calendar.getInstance();
//		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//		// 判断时间是否开盘
//		// 20160322  16:53:37
//		
//		System.out.println(sdf.format(calendar.getTime()));
//		System.out.println(sdf.parse("20160322  16:53:37") + "");
		
		double a = 77.20811111;
		double c = 90;
		double d = 76.69;
		@SuppressWarnings("unused")
    double b = 6902.099999999999;

		BigDecimal e = new BigDecimal(c + "");
		BigDecimal f = new BigDecimal(d + "");
		System.out.println(e.setScale(2, BigDecimal.ROUND_DOWN));
		System.out.println(e.multiply(f).setScale(2, BigDecimal.ROUND_DOWN));
		
		
		
		String avgCost = a + "";
		BigDecimal bigAvgCost= new BigDecimal(avgCost).setScale(2, BigDecimal.ROUND_DOWN);
		  System.out.println(bigAvgCost);
		  
		
		String myMoney = "100.01644";
		System.out.println(Double.parseDouble(myMoney) + "mmmmmmmm");

		  BigDecimal money= new BigDecimal(myMoney);
		 //  money.setScale(2,BigDecimal.ROUND_HALF_DOWN);

		  //设置精度，以及舍入规则
		  money= money.setScale(2, BigDecimal.ROUND_DOWN);
		  System.out.println(money);
		  System.out.println((new Date().getTime() + "").substring(6));
		  
		 
		  BigDecimal bigLast = new BigDecimal("21.97");
			BigDecimal bigClose = new BigDecimal("21.88");
			MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
			System.out.println();
			BigDecimal change = bigLast.subtract(bigClose).setScale(2,BigDecimal.ROUND_HALF_DOWN);
			BigDecimal change_per;
			BigDecimal zero = new BigDecimal(0).setScale(2,BigDecimal.ROUND_HALF_DOWN);
			if (change.equals(zero)) {
				change_per = new BigDecimal(0);
			}
			else {
				// change_per = change.divide(bigClose).multiply(new BigDecimal("100"));

				change_per = change.divide(bigClose, mc).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
//				change_per = change_per.setScale(2, BigDecimal.ROUND_HALF_UP);
				System.out.println(change_per);
			}
			
			
			// 获取美国时间
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//			SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
//			// sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//			sdfHour.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
//			
//			
//			System.out.println(sdf.format(calendar.getTime()));
//			System.out.println(sdfHour.format(calendar.getTime()));
//			System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//			
//
//			
//			String str=String.format("Hi, %s", "林计钦"); // 格式化字符串
//		    System.out.println(str); // 输出字符串变量str的内容
//		    
//		    String ff = "630400045@qq.com";
//		    
//		    String[] aa = ff.split(",");
//		    System.out.println(aa.length);
		    
		    
		    
		    
		 // 获取美国时间
		 			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		 			SimpleDateFormat sdf2 = new SimpleDateFormat("MM月dd日");
		 			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		 			sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		 			System.out.println(sdf.format(calendar.getTime()));

		 			// 判断时间是否开盘
		 			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		 			int hour = calendar.get(Calendar.HOUR_OF_DAY);
		 			int minute = calendar.get(Calendar.MINUTE);
		 			System.out.println(dayOfWeek);
		 			// 美股交易时间9:30--16:00
		 			if (1 == dayOfWeek || 7 == dayOfWeek) {
		 				// 周六日
		 				System.out.println("未开盘1");
		 			}
		 			else if (9 > hour || 16 < hour){
		 				System.out.println("未开盘2");
		 			}
		 			else if (9 == hour && minute < 30) {
		 				System.out.println("未开盘3");
		 			}
		 			else {
		 				System.out.println("已开盘");
		 			}
		    
		 			Calendar calendar2 = Calendar.getInstance();
		 			calendar2.setTime(calendar.getTime());
		 			calendar2.add(Calendar.DATE, -1);
		 			System.out.println(sdf2.format(calendar2.getTime()) + " 16:00");
		 			
		 			if (1 == dayOfWeek) {
		 				// 周日
		 				calendar2.add(Calendar.DATE, -2);
			 			System.out.println(sdf2.format(calendar2.getTime()));
		 			}
		 			if (7 == dayOfWeek) {
		 				// 周六
		 				calendar2.add(Calendar.DATE, -1);
			 			System.out.println(sdf2.format(calendar2.getTime()));
		 			}
		 			System.out.println(sdf2.format(calendar2.getTime()));
		 			
		 			String aa = "+34.1";
		 			DecimalFormat myformat=new java.text.DecimalFormat("0.00");
		 			
		 			System.out.println(myformat.format(Double.parseDouble(aa)));
		 			
		 			aa = "0.00";
		 			if (Double.parseDouble(aa) == 0) {
						System.out.println(aa);
					}
		 			
//		 			DecimalFormat df = new DecimalFormat("0.00");
//		 			String Volume = "11043922.233"; // 成交量
//					String MarketCapitalization = "200599340000";// 总市值
//					String TotalEquity = "2546000000";// 总股本
//					Integer yi = 100000000;
//					Integer wan = 10000;
//					String use = Volume;
//		 			if (new BigDecimal(use).compareTo(new BigDecimal(yi)) == 1) {
//		 				 String b3 = df.format(new BigDecimal(use).divide(new BigDecimal(yi)));
//		 				 System.out.println(b3 + "亿");
//					}
//		 			else if (new BigDecimal(use).compareTo(new BigDecimal(wan)) == 1) {
//		 				String b3 = df.format(new BigDecimal(use).divide(new BigDecimal(wan)));
//		 				 System.out.println(b3 + "万");
//					}
		 			
		 			SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                

					 Date date = sdfs.parse("2016-04-26 15:54:00");
					 System.out.println(date.toString());
					 
					 Date dNow = new Date(); //当前时间
					 Date dBefore = new Date();
					 Calendar calendarf = Calendar.getInstance(); //得到日历
					 calendarf.setTime(dNow);//把当前时间赋给日历
					 calendarf.add(calendar.MONTH, -3); //设置为前3月
					 dBefore = calendarf.getTime(); //得到前3月的时间

					 String defaultStartDate = sdfs.format(dBefore); //格式化前3月的时间
					 String defaultEndDate = sdfs.format(dNow); //格式化当前时间

					 System.out.println("前3个月的时间是：" + defaultStartDate);
					 System.out.println("生成的时间是：" + defaultEndDate); 
					 
					 if (dNow.after(dBefore)) {
						System.out.println("dddd");
					}
					 
					 
					 
					 
					 

//					 999884股票账户总资产
//					 -199股票账户总盈亏1000305股票账户总资产
					// -329股票账户总盈亏
						// 计算账户涨跌百分比
					 	// 当前涨跌额
						BigDecimal realizedPnl = new BigDecimal("-329");
						// 当前总资产
						BigDecimal netLiquidationByCurrency = new BigDecimal("999671");
						// 初始资产
						BigDecimal accountInitial = netLiquidationByCurrency.subtract(realizedPnl);
						// 当前涨跌百分比
						BigDecimal accountRiseFall = realizedPnl.divide(accountInitial, 6, RoundingMode.DOWN);
						System.out.println(accountRiseFall);


				        NumberFormat percent = NumberFormat.getPercentInstance();
				        percent.setMaximumFractionDigits(2);

				        System.out.println(percent.format(accountRiseFall.doubleValue()));
						
						
				        BigDecimal aaa = new BigDecimal("6");
				        BigDecimal bb = new BigDecimal("4.446666666668");
				        BigDecimal cc = new BigDecimal("3000");
				        
				        System.out.println((aaa.subtract(bb)).multiply(cc));
				        
		 			
		    

		
	}
	
	

}
