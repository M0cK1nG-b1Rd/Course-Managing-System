package cc.mrbird.febs.filemanager.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class TChunkInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
    /**
     * 当前文件块，从1开始
     */
    private Integer chunkNumber;
    /**
     * 每块大小
     */
    private Long chunkSize;
    /**
     * 当前分块大小
     */
    private Long currentChunkSize;
    /**
     * 总大小
     */
    private Long totalSize;
    /**
     * 文件标识
     */
    private String identifier;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 相对路径
     */
    private String relativePath;
    /**
     * 总块数
     */
    private Integer totalChunks;
    /**
     * 文件类型
     */
    private String type;

    /**
     * 块内容
     */
    private transient MultipartFile upfile;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getChunkNumber() {
		return chunkNumber;
	}

	public void setChunkNumber(Integer chunkNumber) {
		this.chunkNumber = chunkNumber;
	}

	public Long getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(Long chunkSize) {
		this.chunkSize = chunkSize;
	}

	public Long getCurrentChunkSize() {
		return currentChunkSize;
	}

	public void setCurrentChunkSize(Long currentChunkSize) {
		this.currentChunkSize = currentChunkSize;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public Integer getTotalChunks() {
		return totalChunks;
	}

	public void setTotalChunks(Integer totalChunks) {
		this.totalChunks = totalChunks;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
    
}
