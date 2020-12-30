package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.dao.ProjectInfoMapper;
import cc.mrbird.febs.project.service.ProjectInfoService;
import cc.mrbird.febs.system.domain.Menu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hyl
 */
@Service
public class ProjectInfoServiceImpl extends ServiceImpl<ProjectInfoMapper, ProjectInfo> implements ProjectInfoService {
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    public ProjectInfoServiceImpl(ProjectInfoMapper projectInfoMapper){
        this.projectInfoMapper = projectInfoMapper;
    }

    public ProjectInfoServiceImpl( ){

    }

    @Override
    public List<ProjectInfo> findProjectInfo(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("group_leader",username);
        return (List<ProjectInfo>) projectInfoMapper.selectList(wrapper);
    }
}
