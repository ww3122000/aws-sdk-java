package com.amazonaws.services.cloudfront.model.log;

import com.amazonaws.services.cloudfront.model.AccetypeEnum;

public class CdnLogSetting {

    private Long id;

    private Long userId;

    private Long domainId;

	private String domain;

    private String bucket;
	
	private AccetypeEnum type;
	
	private GranularityEnum granularity;
	
	private StatusEnum status;

    private Long updateTime;

    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDomainId() {
        return domainId;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CdnLogSetting{" +
                "id=" + id +
                ", userId=" + userId +
                ", domainId=" + domainId +
                ", domain='" + domain + '\'' +
                ", bucket='" + bucket + '\'' +
                ", type=" + type +
                ", granularity=" + granularity +
                ", status=" + status +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
