package com.amazonaws.services.cloudfront.model.log;

import java.util.ArrayList;
import java.util.List;

public class LogPage {

	private int pageSize;

	private long totalCount;

	private long totalPages;

	private int pageNo;

	private List<CdnLog> data;


	public LogPage() {
		super();
        data = new ArrayList<CdnLog>();
	}

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<CdnLog> getData() {
        return data;
    }

    public void setData(List<CdnLog> data) {
        this.data = data;
    }

    private String printData(){
        if (data.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        for (CdnLog cdnLog: data){
            sb.append(cdnLog.toString());
            sb.append(",");
        }
        sb.replace(sb.length()-1,sb.length(),"]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "LogPage{" +
                "pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", pageNo=" + pageNo +
                ", data=" + printData() +
                '}';
    }
}
