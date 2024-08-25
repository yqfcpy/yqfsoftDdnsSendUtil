package com.yqfsoft.send.utils;

import com.yqfsoft.send.entity.YqfsoftDdnsInfo;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class ResourceConfig {

	/**
	 * 读取配置文件信息
	 * @return
	 */
	public static YqfsoftDdnsInfo getInfoFromResouce() {
		String str = getFullPath();
		Properties prop = new Properties();
		YqfsoftDdnsInfo info = new YqfsoftDdnsInfo();
		BufferedReader bufferedReader = null;
		try {
			InputStreamReader input = new InputStreamReader(new FileInputStream(str + "config.properties"), "UTF-8");
			bufferedReader = new BufferedReader(input);
			prop.load(input);
			// 读取属性
			String domain = prop.getProperty("domain");
			String ip = prop.getProperty("ip");
			String sn = prop.getProperty("sn");
			info.setDomain(domain);
			info.setContent(ip);
			info.setSn(sn);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return info;
	}

	/**
	 * 把ip地址写到配置文件中
	 * @param ip
	 */
	public static void writeIpToResoucre(String ip) {
		YqfsoftDdnsInfo info = getInfoFromResouce();
		Properties prop = new Properties();
		prop.setProperty("domain",info.getDomain());
		prop.setProperty("ip", ip);
		prop.setProperty("sn", info.getSn());
		try {
			String path = getFullPath();
			FileOutputStream fos = new FileOutputStream(path + "config.properties");
			prop.store(fos, "Update properties file");
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 获得同级Jar包路径
	 * @return 路径
	 */
	public static String getFullPath () {
		URL url = ResourceConfig.class.getResource("/");
		if(url==null){
			url = ResourceConfig.class.getResource("");
		}
		// 执行后url为 jar:file:/D:/auth/myapp.jar!/com/abc/test/rpa/tools/

		String str = url.getPath();
		// str为 file:/D:/auth/myapp.jar!/com/abc/test/rpa/tools/

		int i2 = str.indexOf("/"); //第一个/的位置
		int i = str.indexOf(".jar!");
		if(i>0){
			str = str.substring(i2+1, i);
		}
		// str为 D:/auth/myapp

		int i3 = str.lastIndexOf("/");
		str = str.substring(0,i3+1);
		// str为 D:/auth/

		int i1 = str.indexOf(":");
		if(i1==-1){
			str = "/"+str;
		}
		return str;
	}
}
