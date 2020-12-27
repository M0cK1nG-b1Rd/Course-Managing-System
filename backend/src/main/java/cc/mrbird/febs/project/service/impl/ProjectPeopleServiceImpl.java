package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.project.dao.ProjectInfoMapper;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.dao.ProjectPeopleMapper;
import cc.mrbird.febs.project.service.ProjectPeopleService;
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
}
