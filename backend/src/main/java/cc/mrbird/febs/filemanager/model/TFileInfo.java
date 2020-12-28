package cc.mrbird.febs.filemanager.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件模型
 * @author caiyunlai
 *
 */
public class TFileInfo implements Serializable {

	private static final long serialVersionUID = 6969462437970901728L;

	//文件编号
	private String id;

	//文件名称
    private String filename;
    
    private String nameSearch;

    //文件MD5标识
    private String identifier;

    //文件总大小
    private Long totalSize;
    
    private String totalSizeName;

    //文件类型
    private String type;

    //文件存储地址
    private String location;
    
    //删除标志
    private String delFlag;
    
    //文件所属目标（项目、学生、档案等，预留字段）
    private String refProjectId;
    
    //上传人
    private String uploadBy;

    //上传时间
    private Date uploadTime;
    //格式化时间
    private String uploadTimeString;

    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
		if(1024*1024 > this.totalSize && this.totalSize >= 1024 ) {
			this.totalSizeName = String.format("%.2f",this.totalSize.doubleValue()/1024) + "KB";
		}else if(1024*1024*1024 > this.totalSize && this.totalSize >= 1024*1024 ) {
			this.totalSizeName = String.format("%.2f",this.totalSize.doubleValue()/(1024*1024)) + "MB";
		}else if(this.totalSize >= 1024*1024*1024 ) {
			this.totalSizeName = String.format("%.2f",this.totalSize.doubleValue()/(1024*1024*1024)) + "GB";
		}else {
			this.totalSizeName = this.totalSize.toString() + "B";
		}
	}

	public String getTotalSizeName() {
		return totalSizeName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getRefProjectId() {
		return refProjectId;
	}

	public void setRefProjectId(String refProjectId) {
		this.refProjectId = refProjectId;
	}

	public String getUploadBy() {
		return uploadBy;
	}

	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadTimeString() {
		return uploadTimeString;
	}

	public void setUploadTimeString(String uploadTimeString) {
		this.uploadTimeString = uploadTimeString;
	}
	
}
