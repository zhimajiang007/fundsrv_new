package com.homaer.fundsrv.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.homaer.common.tools.log.LoggerUtils;

public class HttpRequestSimple {

	private Logger LOGGER = LoggerFactory.getLogger(LoggerUtils.UTILS_LOGGER);

	private static HttpRequestSimple instance;

	public static HttpRequestSimple getInstance() {
		if (null == instance) {
			instance = new HttpRequestSimple();
		}
		return instance;
	}

	private HttpRequestSimple() {

	}

	private static PoolingHttpClientConnectionManager cm;
	private static HttpClientContext context;

	private static final int MAX_CONNECTIONS_TOTAL = 200;
	private static final int MAX_CONNECTIONS_PER_ROUTE = 10;

	static {
		cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(MAX_CONNECTIONS_TOTAL);
		cm.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);
		context = HttpClientContext.create();
	}

	static class GetThread extends Thread {

		private final CloseableHttpClient httpClient;
		private final HttpContext context;
		private final HttpUriRequest request;

		public GetThread(CloseableHttpClient httpClient, HttpUriRequest request) {
			this.httpClient = httpClient;
			this.context = HttpClientContext.create();
			this.request = request;
		}

		@Override
		public void run() {
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(request, context);
				int ret = response.getStatusLine().getStatusCode();

				if (ret == HttpStatus.SC_OK) {
					// 响应分析
					HttpEntity entity = response.getEntity();
					String responseString = EntityUtils.toString(entity);
					System.out.println(responseString);
				} else {

				}
			} catch (ClientProtocolException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (response != null) {
					try {
						EntityUtils.consume(response.getEntity());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public String execute(HttpUriRequest request) {
		HttpHost localhost = new HttpHost(request.getURI().getHost(), request
				.getURI().getPort());
		cm.setMaxPerRoute(new HttpRoute(localhost), 50);
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(2000).setConnectTimeout(2000).build();// 设置请求和传输超时时间
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(requestConfig)
				.setConnectionManager(cm).build();
		CloseableHttpResponse response = null;
		try {

			response = httpClient.execute(request, context);
			int ret = response.getStatusLine().getStatusCode();

			if (ret == HttpStatus.SC_OK) {
				// 响应分析
				HttpEntity entity = response.getEntity();
				String responseString = EntityUtils.toString(entity);
				return responseString;
			} else {
				return null;
			}
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public String postSendHttp(String url, String body) {
		if (StringUtils.isBlank(url)) {
			LoggerUtils.error(LOGGER, "request url is empty.");
			return null;
		}
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/json;charset=UTF-8");
		try {
			StringEntity stringEntity = new StringEntity(body, "UTF-8");
			stringEntity.setContentEncoding(new BasicHeader(
					HTTP.CONTENT_ENCODING, "UTF-8"));
			stringEntity.setContentType("application/json");
			// 设置请求主体
			post.setEntity(stringEntity);
			// 响应分析
			return execute(post);
		} catch (Exception ex) {
			LoggerUtils.error(this.getClass(), LOGGER, ex, "Exception !");
			return null;
		}
	}

	public String getSendHttp(String url, String encoding) {
		if (StringUtils.isBlank(url)) {
			LoggerUtils.error(LOGGER, "request url is empty.");
			return null;
		}
		HttpGet get = new HttpGet(url);
		get.setHeader("Content-Type", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:40.0) Gecko/20100101 Firefox/40.0");
		try {
			// 发起交易
			// 响应分析
			return execute(get);
		} catch (Exception ex) {
			LoggerUtils.error(this.getClass(), LOGGER, ex, "Exception !");
			return null;
		}
	}
	
	public String getJSONSendHttp(String url, String encoding) {
		if (StringUtils.isBlank(url)) {
			LoggerUtils.error(LOGGER, "request url is empty.");
			return null;
		}
		HttpGet get = new HttpGet(url);
		get.setHeader("Content-Type", "text/html,application/json,text/json;q=0.9,*/*;q=0.8");
		get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:40.0) Gecko/20100101 Firefox/40.0");
		try {
			// 发起交易
			// 响应分析
			return execute(get);
		} catch (Exception ex) {
			LoggerUtils.error(this.getClass(), LOGGER, ex, "Exception !");
			return null;
		}
	}

	public String postPramaList(String url, NameValuePair[] list) {
		List<NameValuePair> nvList = new ArrayList<NameValuePair>();
		for (NameValuePair nameValue : list) {
			nvList.add(nameValue);
		}
		return postPramaList(nvList, url);
	}

	public String postPramaList(List<NameValuePair> list, String url) {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");
		try {
			// 设置请求参数
			post.setEntity(new UrlEncodedFormEntity(list, Consts.UTF_8));
			// 发起交易

			return execute(post);
		} catch (Exception ex) {
			LoggerUtils.error(this.getClass(), LOGGER, ex, "Exception !");
			return null;
		} 
	}
	
	public String postPramaList(List<NameValuePair> list, String url, String charset) {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=" + charset);
		try {
			// 设置请求参数
			post.setEntity(new UrlEncodedFormEntity(list, charset));
			// 发起交易

			return execute(post);
		} catch (Exception ex) {
			LoggerUtils.error(this.getClass(), LOGGER, ex, "Exception !");
			return null;
		} 
	}

	public static void main(String[] args) throws InterruptedException {
		// String url =
		// "http://www.homaer.com/ms/service/sendSms.do?cell=18601225948&smsContent=";
		// String content =
		// "cell=13208011326&smsContent=荷马网温馨提醒:感谢您对荷马网的信任，您在荷马网帮助下成功购买的基金查看收益地址如下：http://m.homaer.com，账号：自己手机；初始密码：homaer2015";
		//
		// String resJSON =
		// HttpRequestSimple.getInstance().postSendHttp("http://www.homaer.com/ms/service/sendSms.do",
		// content);
		// System.out.println(resJSON);

		// String url =
		// "http://www.homaer.com/ms/service/sendSms.do?cell=18601225948&smsContent=";
		// String content =
		// "cell=13208011326&smsContent=荷马网温馨提醒:感谢您对荷马网的信任，您在荷马网帮助下成功购买的基金查看收益地址如下：http://m.homaer.com，账号：自己手机；初始密码：homaer2015";
		@SuppressWarnings("unused")
    List<String> mobiles = new ArrayList<String>();
		// mobiles.add("13355719977");
		// mobiles.add("18616655373");
		// mobiles.add("18668128155");
		// mobiles.add("18610216008");

//		mobiles.add("18686346255");
//		for (String cell : mobiles) {
//			Map<String, String> params = new HashMap<String, String>();
//			params.put("cell", cell);
//			params.put(
//					"smsContent",
//					"荷马网温馨提醒:感谢您对荷马网的信任，您在荷马网帮助下成功购买的基金查看收益地址如下：http://m.homaer.com，账号：自己手机；初始密码：homaer2015");
//
//			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//
//			Set<String> keySet = params.keySet();
//			for (String key : keySet) {
//				nvps.add(new BasicNameValuePair(key, params.get(key)));
//			}
//
//			String resJSON = HttpRequestSimple.getInstance().postPramaList(
//					nvps, "http://www.homaer.com/ms/service/sendSms.do");
//			System.out.println(cell + resJSON);
//		}
		
	}

}
