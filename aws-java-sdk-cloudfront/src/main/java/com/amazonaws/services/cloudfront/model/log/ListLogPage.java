package com.amazonaws.services.cloudfront.model.log;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.transform.StaxUnmarshallerContext;

public class ListLogPage {
	
	private int pageSize;
	
	private long totalElements;
	
	private long totalPages;
	
	private int pageNumber;
	
	private List<CdnLogSetting> content;
	
	
	public ListLogPage() {
		super();
		content = new ArrayList<CdnLogSetting>();
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public List<CdnLogSetting> getContent() {
		return content;
	}

	public void setContent(List<CdnLogSetting> content) {
		this.content = content;
	}

}
