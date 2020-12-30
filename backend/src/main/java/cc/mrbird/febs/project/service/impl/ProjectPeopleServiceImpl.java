package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.project.dao.ProjectInfoMapper;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.dao.ProjectPeopleMapper;
import cc.mrbird.febs.project.service.ProjectPeopleService;
import cc.mrbird.febs.system.domain.Menu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public class ProjectPeopleServiceImpl extends ServiceImpl<ProjectPeopleMapper, ProjectPeople> implements ProjectPeopleService {
    private ProjectPeopleMapper projectPeopleMapper;

    @Autowired
    public ProjectPeopleServiceImpl(ProjectPeopleMapper projectPeopleMapper){
        this.projectPeopleMapper = projectPeopleMapper;
    }

    public ProjectPeopleServiceImpl( ){

    }

    @Override
    public List<ProjectPeople> findById(String pid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("pid",pid);
        return (List<ProjectPeople>) projectPeopleMapper.selectList(wrapper);
    }

    @Override
    public List<ProjectPeople> getAllPeopleInGroup(String sid) {
        return this.baseMapper.getAllPeopleInGroup(sid);
    }
}
