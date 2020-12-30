package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.project.dao.ProjectScoringRulesMapper;
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

    @Override
    public void addProjectScore(List<ProjectScore> projectScores) {
        this.baseMapper.addProjectScore(projectScores);
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
    public List<ProjectScoringRules> getRules() {
        return baseMapper.selectList(new QueryWrapper());
    }
}
