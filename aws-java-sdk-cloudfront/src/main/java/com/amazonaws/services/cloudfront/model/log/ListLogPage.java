package com.amazonaws.services.cloudfront.model.log;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.transform.StaxUnmarshallerContext;

public class ListLogPage {
    private long totalCount;
    private long totalPages;
    private int pageSize;
    private int pageNo;
	
	private List<CdnLogSetting> data;
	
	
	public ListLogPage() {
		super();
        data = new ArrayList<CdnLogSetting>();
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

    public List<CdnLogSetting> getData() {
        return data;
    }

    public void setData(List<CdnLogSetting> data) {
        this.data = data;
    }

    private String printData(){
        if (data.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        for (CdnLogSetting cdnLogSetting: data){
            sb.append(cdnLogSetting.toString());
            sb.append(",");
        }
        sb.replace(sb.length()-1,sb.length(),"]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ListLogPage{" +
                "totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", data=" + printData() +
                '}';
    }
}
