package cc.mrbird.febs.filemanager.dao;

import cc.mrbird.febs.filemanager.model.TFileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TFileInfoMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(TFileInfo record);

    int insertSelective(TFileInfo record);

    TFileInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TFileInfo record);

    int updateByPrimaryKey(TFileInfo record);

	List<TFileInfo> selectFileByParams(TFileInfo fileInfo);
	
	List<TFileInfo> selectFileList(TFileInfo fileInfo, @Param("pid") String pid);

    List<TFileInfo> selectList();
}