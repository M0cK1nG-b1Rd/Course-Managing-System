package cc.mrbird.febs.project.dao;

import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.domain.ProjectScore;
import cc.mrbird.febs.project.domain.ProjectScoringRules;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author hyl
 */

public interface ProjectScoreMapper extends BaseMapper<ProjectScore> {
    void addProjectScore(List<ProjectScore> projectScores);

}
