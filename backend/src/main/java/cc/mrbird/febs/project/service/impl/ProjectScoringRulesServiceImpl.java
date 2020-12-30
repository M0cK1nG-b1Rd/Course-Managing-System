package cc.mrbird.febs.project.service.impl;

import cc.mrbird.febs.project.domain.ProjectScoringRules;
import cc.mrbird.febs.project.dao.ProjectScoringRulesMapper;
import cc.mrbird.febs.project.service.ProjectScoringRulesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public class ProjectScoringRulesServiceImpl extends ServiceImpl<ProjectScoringRulesMapper, ProjectScoringRules> implements ProjectScoringRulesService {

    @Override
    public List<ProjectScoringRules> getRules(){
            return baseMapper.selectList(new QueryWrapper());

    }
}
