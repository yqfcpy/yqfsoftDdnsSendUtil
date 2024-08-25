package com.yqfsoft.send.entity;

public class YqfsoftDdnsInfo {
	private String url;
	private String domain;
	private String content;
	private String sn;

	public YqfsoftDdnsInfo() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@Override
	public String toString() {
		return "YqfsoftDdnsInfo{" +
			"url='" + url + '\'' +
			", domain='" + domain + '\'' +
			", content='" + content + '\'' +
			", sn='" + sn + '\'' +
			'}';
	}
}
