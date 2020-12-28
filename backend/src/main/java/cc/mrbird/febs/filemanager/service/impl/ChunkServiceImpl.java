package cc.mrbird.febs.filemanager.service.impl;

import cc.mrbird.febs.filemanager.dao.TChunkInfoMapper;
import cc.mrbird.febs.filemanager.model.TChunkInfo;
import cc.mrbird.febs.filemanager.service.ChunkService;
import cc.mrbird.febs.filemanager.util.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class ChunkServiceImpl implements ChunkService {

	@Resource
	TChunkInfoMapper tChunkInfoMapper;
	
    @Override
    public int saveChunk(TChunkInfo chunk) {
    	chunk.setId(SnowflakeIdWorker.getUUID()+SnowflakeIdWorker.getUUID());
    	return tChunkInfoMapper.insertSelective(chunk);
    }

    @Override
    public ArrayList<Integer> checkChunk(TChunkInfo chunk) {
    	return tChunkInfoMapper.selectChunkNumbers(chunk);
    }

	@Override
	public boolean checkChunk(String identifier, Integer chunkNumber) {
		return false;
	}

}
