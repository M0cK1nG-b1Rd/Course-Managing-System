package cc.mrbird.febs.filemanager.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 文件上传结果
 * @author caiyunlai
 *
 */
public class UploadResult implements Serializable {
	
	private static final long serialVersionUID = -9000695051292877324L;

	//是否跳过上传（已上传的可以直接跳过，达到秒传的效果）
	private boolean skipUpload;

	//已经上传的文件块编号，可以跳过，断点续传
    private ArrayList<Integer> uploadedChunks;

    //返回结果码
    private String status;

    //返回结果信息
    private String message;

    //已上传完整附件的地址
    private String location;

	public boolean isSkipUpload() {
		return skipUpload;
	}

	public void setSkipUpload(boolean skipUpload) {
		this.skipUpload = skipUpload;
	}

	public ArrayList<Integer> getUploadedChunks() {
		return uploadedChunks;
	}

	public void setUploadedChunks(ArrayList<Integer> uploadedChunks) {
		this.uploadedChunks = uploadedChunks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
