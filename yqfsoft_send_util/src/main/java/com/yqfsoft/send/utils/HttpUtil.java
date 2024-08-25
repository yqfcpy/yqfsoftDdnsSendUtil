package com.yqfsoft.send.utils;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.yqfsoft.send.entity.YqfsoftDdnsInfo;

public class HttpUtil {
	public static void send(YqfsoftDdnsInfo yqfsoftDdnsInfo){
		String url = yqfsoftDdnsInfo.getUrl()+ "?"+ "name="+ yqfsoftDdnsInfo.getDomain()+ "&" + "content="+ yqfsoftDdnsInfo.getContent()+ "&" + "sn="+ yqfsoftDdnsInfo.getSn();
		HttpResponse response = HttpRequest.get(url)
			.timeout(20000)
			.execute();
	}
	public static String getIp(){
		String[] url = new String[]{"https://ip.3322.net","https://4.ipw.cn"};
		String ip = "";
		for (int i=0;i<url.length;i++){
			HttpResponse response = HttpRequest.get(url[i])
				.timeout(10000)
				.execute();
			if (response.isOk()) {
				ip = response.body();
				break;
			}
		}
		if ("".equals(ip)){
			throw new RuntimeException("获取ip失败");
		}
		return ip;
	}
}
