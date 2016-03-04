package com.amazonaws.services.cloudfront.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * An ContentPath list.
 * </p>
 */
@XmlRootElement(name = "ContentPathList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListContentPathsRequest extends AmazonWebServiceRequest implements Serializable, Cloneable {

	/**
     * 
     */
    private static final long serialVersionUID = 7397561735087371440L;
    
    @XmlElement(name = "UserId")
    private Long userId;
    
    /**
     * 查询的参数
     */
    @XmlElement(name = "QueryName")
    private String queryName;
    
    /**
     * 路径类型：文件刷新、目录刷新、文件预热
     */
    @XmlElement(name = "Type")
    private ContentPathTypeEnum type;
    
    /**
     * 开始时间
     */
    @XmlElement(name = "StartTime")
    private Date startTime;
    
    /**
     * 结束时间
     */
    @XmlElement(name = "EndTime")
    private Date endTime;
    
    /**
     * 第几页，从0开始的页数
     */
    @XmlElement(name = "PageIndex")
    private Integer pageIndex;
    
    /**
     * 页大小
     */
    @XmlElement(name = "PageSize")
    private Integer pageSize;
    
	/**
	 * The number of ContentPath batches that were created by the current
	 * AWS account.
	 */
	@XmlElement(name = "Quantity")
	private Integer quantity;

	/**
	 * A complex type that contains one InvalidationSummary element for each
	 * invalidation batch that was created by the current AWS account.
	 */
	@XmlElementWrapper(name = "Items")
    @XmlElement(name="ContentPath")
	private com.amazonaws.internal.ListWithAutoConstructFlag<ContentPath> items;

	/**
	 * Default constructor for a new InvalidationList object. Callers should use the
	 * setter or fluent setter (with...) methods to initialize this object after creating it.
	 */
	public ListContentPathsRequest() {
	}

	/**
	 * The number of invalidation batches that were created by the current
	 * AWS account.
	 *
	 * @return The number of invalidation batches that were created by the current
	 *         AWS account.
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * The number of invalidation batches that were created by the current
	 * AWS account.
	 *
	 * @param quantity The number of invalidation batches that were created by the current
	 *            AWS account.
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * The number of invalidation batches that were created by the current
	 * AWS account.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained together.
	 *
	 * @param quantity The number of invalidation batches that were created by the current
	 *            AWS account.
	 *
	 * @return A reference to this updated object so that method calls can be chained
	 *         together.
	 */
	public ListContentPathsRequest withQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * A complex type that contains one InvalidationSummary element for each
	 * invalidation batch that was created by the current AWS account.
	 *
	 * @return A complex type that contains one InvalidationSummary element for each
	 *         invalidation batch that was created by the current AWS account.
	 */
	public java.util.List<ContentPath> getItems() {
		if (items == null) {
			items = new com.amazonaws.internal.ListWithAutoConstructFlag<ContentPath>();
			items.setAutoConstruct(true);
		}
		return items;
	}

	/**
	 * A complex type that contains one InvalidationSummary element for each
	 * invalidation batch that was created by the current AWS account.
	 *
	 * @param items A complex type that contains one InvalidationSummary element for each
	 *            invalidation batch that was created by the current AWS account.
	 */
	public void setItems(java.util.Collection<ContentPath> items) {
		if (items == null) {
			this.items = null;
			return;
		}
		com.amazonaws.internal.ListWithAutoConstructFlag<ContentPath> itemsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<ContentPath>(
				items.size());
		itemsCopy.addAll(items);
		this.items = itemsCopy;
	}

	/**
	 * A complex type that contains one InvalidationSummary element for each
	 * invalidation batch that was created by the current AWS account.
	 * <p>
	 * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
	 * {@link #setItems(java.util.Collection)} or {@link #withItems(java.util.Collection)} if you want to override the
	 * existing values.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained together.
	 *
	 * @param items A complex type that contains one InvalidationSummary element for each
	 *            invalidation batch that was created by the current AWS account.
	 *
	 * @return A reference to this updated object so that method calls can be chained
	 *         together.
	 */
	public ListContentPathsRequest withItems(ContentPath... items) {
		if (getItems() == null)
			setItems(new java.util.ArrayList<ContentPath>(items.length));
		for (ContentPath value : items) {
			getItems().add(value);
		}
		return this;
	}

	/**
	 * A complex type that contains one InvalidationSummary element for each
	 * invalidation batch that was created by the current AWS account.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained together.
	 *
	 * @param items A complex type that contains one InvalidationSummary element for each
	 *            invalidation batch that was created by the current AWS account.
	 *
	 * @return A reference to this updated object so that method calls can be chained
	 *         together.
	 */
	public ListContentPathsRequest withItems(java.util.Collection<ContentPath> items) {
		if (items == null) {
			this.items = null;
		} else {
			com.amazonaws.internal.ListWithAutoConstructFlag<ContentPath> itemsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<ContentPath>(
					items.size());
			itemsCopy.addAll(items);
			this.items = itemsCopy;
		}

		return this;
	}


	@Override
	public ListContentPathsRequest clone() {
		return (ListContentPathsRequest) super.clone();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public ContentPathTypeEnum getType() {
		return type;
	}

	public void setType(ContentPathTypeEnum type) {
		this.type = type;
	}
	
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setItems(com.amazonaws.internal.ListWithAutoConstructFlag<ContentPath> items) {
		this.items = items;
	}
}
