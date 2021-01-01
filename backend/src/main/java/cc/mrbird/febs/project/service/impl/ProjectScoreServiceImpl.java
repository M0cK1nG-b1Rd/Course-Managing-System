package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.project.dao.ProjectScoringRulesMapper;
import cc.mrbird.febs.project.domain.ClassStatistics;
import cc.mrbird.febs.project.domain.ProjectScore;
import cc.mrbird.febs.project.dao.ProjectScoreMapper;
import cc.mrbird.febs.project.domain.ProjectScoringRules;
import cc.mrbird.febs.project.service.ProjectScoreService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public class ProjectScoreServiceImpl extends ServiceImpl<ProjectScoreMapper, ProjectScore> implements ProjectScoreService {
    @Autowired
    ProjectScoringRulesMapper projectScoringRulesMapper;

    @Autowired
    ProjectScoreMapper projectScoreMapper;


    @Override
    public void addProjectScore(ProjectScore projectScore) {
        this.save(projectScore);
    }

    @Override
    public void updateProjectScoringRules(int[] rules){
        for (int i=1;i<= rules.length;i++){
            ProjectScoringRules rule=  this.projectScoringRulesMapper.selectById(i);
            rule.setRatio(rules[i-1]);
            projectScoringRulesMapper.updateById(rule);
        }
    }

    @Override
    public float getGreaterThanInProject(String sid){
        return  this.baseMapper.getGreaterThanInProject(sid);
    }

    @Override
    public float getGreaterThanInClass(String sid){
        return  this.baseMapper.getGreaterThanInClass(sid);
    }

//    @Override
//    public float getStatisticsInProject(String sid){
//        return  this.baseMapper.getStatisticsInProject(sid);
//    }

    @Override
    public ClassStatistics getStatisticsInClass(String sid){
        return  this.baseMapper.getStatisticsInClass(sid);
    }

    @Override
    public ProjectScore getProjectScore(String sid){
        return this.baseMapper.getProjectScore(sid);
    }

    @Override
    public List<ProjectScore> getAllProjectScore() {
        return this.baseMapper.getAllProjectScore();
    }

    @Override
    public void releaseScore() {
        this.baseMapper.releaseScore();
    }

    @Override
    public void unreleaseScore() {
        this.baseMapper.unreleaseScore();
    }

}
