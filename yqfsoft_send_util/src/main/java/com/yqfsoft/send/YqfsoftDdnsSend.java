package com.yqfsoft.send;

import com.yqfsoft.send.entity.YqfsoftDdnsInfo;
import com.yqfsoft.send.utils.HttpUtil;
import com.yqfsoft.send.utils.ResourceConfig;

public class YqfsoftDdnsSend implements Runnable{
	@Override
	public void run() {
		while (true){
			String url ="https://ddns.yqfsoft.com/prod-api/updateIp";
			YqfsoftDdnsInfo info = ResourceConfig.getInfoFromResouce();
			info.setUrl(url);
			try {
				if ("".equals(info.getSn()) && "".equals(info.getDomain())){
					throw new RuntimeException("不合法的文件名");
				}
				String currentIp = HttpUtil.getIp();
				if(!currentIp.equals(info.getContent())){
					info.setContent(currentIp);
					HttpUtil.send(info);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					Thread.sleep(10*60*1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				continue;
			}
		}
	}
}
