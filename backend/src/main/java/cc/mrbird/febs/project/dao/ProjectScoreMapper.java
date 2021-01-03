package cc.mrbird.febs.project.dao;

import cc.mrbird.febs.project.domain.ClassStatistics;
import cc.mrbird.febs.project.domain.ProjectScore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public interface ProjectScoreMapper extends BaseMapper<ProjectScore> {
//    void addProjectScore(List<ProjectScore> projectScores);
    
    float getGreaterThanInProject(String sid);

    float getGreaterThanInClass(String sid);

//    float getStatisticsInProject(String sid);

    ClassStatistics getStatisticsInClass(String sid);

    ProjectScore getProjectScore(String sid);

    List<ProjectScore> getAllProjectScore();

    void releaseScore();

    void unreleaseScore();

    void updateProjectScore(@Param("projectScore") ProjectScore projectScore);

    void addProjectScore(@Param("projectScore") ProjectScore projectScore);
}
