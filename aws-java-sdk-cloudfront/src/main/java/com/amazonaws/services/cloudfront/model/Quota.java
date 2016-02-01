package com.amazonaws.services.cloudfront.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户配额及使用量
 */
@XmlRootElement(name = "Quota")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quota implements Serializable, Cloneable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4692411821506386432L;

    /** 刷新目录的使用量或者总量 . */
    @XmlElement(name = "InvalidationDir")
    private Long invalidationDir;
    
    /** 刷新文件的使用量或者总量. */
    @XmlElement(name = "InvalidationFile")
    private Long invalidationFile;
    
    /** 预加载文件的使用量或者总量. */
    @XmlElement(name = "Preload")
    private Long preload;

    /**
     * Gets the 刷新目录的使用量或者总量 .
     *
     * @return the 刷新目录的使用量或者总量 
     */
    public Long getInvalidationDir() {
        return invalidationDir;
    }

    /**
     * Sets the 刷新目录的使用量或者总量 .
     *
     * @param invalidationDir the new 刷新目录的使用量或者总量 
     */
    public void setInvalidationDir(Long invalidationDir) {
        this.invalidationDir = invalidationDir;
    }

    /**
     * Gets the 刷新文件的使用量或者总量.
     *
     * @return the 刷新文件的使用量或者总量
     */
    public Long getInvalidationFile() {
        return invalidationFile;
    }

    /**
     * Sets the 刷新文件的使用量或者总量.
     *
     * @param invalidationFile the new 刷新文件的使用量或者总量
     */
    public void setInvalidationFile(Long invalidationFile) {
        this.invalidationFile = invalidationFile;
    }

    /**
     * Gets the 预加载文件的使用量或者总量.
     *
     * @return the 预加载文件的使用量或者总量
     */
    public Long getPreload() {
        return preload;
    }

    /**
     * Sets the 预加载文件的使用量或者总量.
     *
     * @param preload the new 预加载文件的使用量或者总量
     */
    public void setPreload(Long preload) {
        this.preload = preload;
    }

	@Override
	public String toString() {
		return "Quota [invalidationDir=" + invalidationDir + ", invalidationFile=" + invalidationFile + ", preload="
				+ preload + "]";
	}
}
