package com.yqfsoft;


import com.yqfsoft.send.YqfsoftDdnsSend;


/**
 * @author Oscar Yang Liu
 */
public class Main {
	public static void main(String[] args) {
		new Thread(new YqfsoftDdnsSend()).start();
		System.out.println("清峰科技动态域名发送中......");
	}
}