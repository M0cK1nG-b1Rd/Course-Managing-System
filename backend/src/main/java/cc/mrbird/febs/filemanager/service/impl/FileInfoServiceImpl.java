package cc.mrbird.febs.filemanager.service.impl;

import cc.mrbird.febs.filemanager.dao.TFileInfoMapper;
import cc.mrbird.febs.filemanager.model.TFileInfo;
import cc.mrbird.febs.filemanager.service.FileInfoService;
import cc.mrbird.febs.filemanager.util.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件处理类
 * @author caiyunlai
 *
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

	@Resource
	TFileInfoMapper tFileInfoMapper;
	
    @Override
    public int addFileInfo(TFileInfo fileInfo) {
    	fileInfo.setId(SnowflakeIdWorker.getUUID()+SnowflakeIdWorker.getUUID());
        return tFileInfoMapper.insertSelective(fileInfo);
    }
    
    @Override
    public List<TFileInfo> selectFileByParams(TFileInfo fileInfo) {
        return tFileInfoMapper.selectFileByParams(fileInfo);
    }
    
    @Override
	public List<TFileInfo> selectFileList(TFileInfo file,String pid) {
		return tFileInfoMapper.selectFileList(file,pid);
	}

	@Override
	public int deleteFile(TFileInfo tFileInfo) {
		TFileInfo t = new TFileInfo();
		t.setId(tFileInfo.getId());
		t.setDelFlag("1");
		return tFileInfoMapper.updateByPrimaryKeySelective(t);
	}
}
