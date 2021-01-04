package cc.mrbird.febs.filemanager.service;

import cc.mrbird.febs.filemanager.model.TFileInfo;

import java.util.List;

public interface FileInfoService {
	
	 int addFileInfo(TFileInfo fileInfo);
	
	 List<TFileInfo> selectFileByParams(TFileInfo fileInfo);
	
	 /**
     * 查询
     *
     * @param file 查询条件
     * @return List
     */
    List<TFileInfo> selectFileList(TFileInfo file,String pid);
                    
    
    /**
     * 删除
     * @param tFileInfo
     * @return
     */
    int deleteFile(TFileInfo tFileInfo);

    List<TFileInfo> findAll();
}
