package cc.mrbird.febs.project.service;

import cc.mrbird.febs.project.domain.ProjectScoringRules;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public interface ProjectScoringRulesService extends IService<ProjectScoringRules> {
    List<ProjectScoringRules> getRules();
}
