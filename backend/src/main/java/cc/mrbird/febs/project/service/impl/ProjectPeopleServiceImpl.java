package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.project.dao.ProjectInfoMapper;
import cc.mrbird.febs.project.domain.PeopleInGroup;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.dao.ProjectPeopleMapper;
import cc.mrbird.febs.project.service.ProjectPeopleService;
import cc.mrbird.febs.system.domain.Menu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
    public List<ProjectPeople> findBySid(String sid) {
        return this.baseMapper.findBySid(sid);
    }

    @Override
    public List<ProjectPeople> findByPid(String pid) {
        return  this.baseMapper.selectPureList(pid);
    }

    @Override
    public List<ProjectPeople> getMyProjectPeople(String sid,String pid) {
        return this.baseMapper.getMyProjectPeople(sid,pid);
    }

    @Override
    public void updateProjectPeoples(LinkedHashMap<String, Object> projectPeoples,String pid) {
        //先删除再添加记录，这样更简单一点
        this.baseMapper.deleteByPid(pid);
        this.createProjectPeoples(projectPeoples);
    }


    @Override
    public List<PeopleInGroup> getAllPeopleInGroup(String sid, String pid) {
        return this.baseMapper.getAllPeopleInGroup(sid,pid);
    }

    @Override
    public void createProjectPeoples(LinkedHashMap<String,Object> projectPeoples) {
        ProjectPeople projectPeople = new ProjectPeople();
        String pid = projectPeoples.get("pid").toString();
        ArrayList<LinkedHashMap> peoples = (ArrayList<LinkedHashMap>)projectPeoples.get("member");
        for (LinkedHashMap people:peoples) {
            String sid = people.get("sid").toString();
            String position =people.get("position").toString();
            projectPeople.setPid(pid);
            projectPeople.setSid(sid);
            projectPeople.setPosition(position);
            this.save(projectPeople);
        }
    }



}
