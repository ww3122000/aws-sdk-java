package com.amazonaws.services.cloudfront.model.log;

import com.amazonaws.services.cloudfront.model.AccetypeEnum;

public class CdnLogSetting {
	
	private long domainId;
	
	private String domain;
	
	private AccetypeEnum type;
	
	private GranularityEnum granularity;
	
	private StatusEnum status;

	public long getDomainId() {
		return domainId;
	}

	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public AccetypeEnum getType() {
		return type;
	}

	public void setType(AccetypeEnum type) {
		this.type = type;
	}

	public GranularityEnum getGranularity() {
		return granularity;
	}

	public void setGranularity(GranularityEnum granularity) {
		this.granularity = granularity;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
