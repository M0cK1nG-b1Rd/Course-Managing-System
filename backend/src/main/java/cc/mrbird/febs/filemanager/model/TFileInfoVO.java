package cc.mrbird.febs.filemanager.model;

import java.io.Serializable;

/**
 * 文件模型参数
 * @author JaredJia
 *
 */
public class TFileInfoVO implements Serializable {

	private static final long serialVersionUID = -668666237985927833L;

	//附件编号
	private String id;
	
	//附件类型
    private String fileType;
    
	//附件名称
    private String name;
    
    //附件总大小
    private Long size;
    
    //附件地址
    private String relativePath;

    //附件MD5标识
    private String uniqueIdentifier;

    //附件所属项目ID
    private String refProjectId;
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}

	public String getRefProjectId() {
		return refProjectId;
	}

	public void setRefProjectId(String refProjectId) {
		this.refProjectId = refProjectId;
	}
	
}
