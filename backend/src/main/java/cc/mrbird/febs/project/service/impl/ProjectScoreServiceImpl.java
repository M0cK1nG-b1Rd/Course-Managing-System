package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.project.domain.ProjectScore;
import cc.mrbird.febs.project.dao.ProjectScoreMapper;
import cc.mrbird.febs.project.domain.ProjectScoringRules;
import cc.mrbird.febs.project.service.ProjectScoreService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public class ProjectScoreServiceImpl extends ServiceImpl<ProjectScoreMapper, ProjectScore> implements ProjectScoreService {


    @Override
    public void addProjectScore(List<ProjectScore> projectScores) {
        this.baseMapper.addProjectScore(projectScores);
    }

    @Override
    public void addProjectScoringRules(List<ProjectScoringRules> projectScoringRules){
        this.baseMapper.addProjectScoringRules(projectScoringRules);
    }

    @Override
    public List<ProjectScoringRules> getRules() {
        return baseMapper.selectList(new QueryWrapper());
    }
}
