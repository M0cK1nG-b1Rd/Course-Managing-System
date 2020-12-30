package cc.mrbird.febs.project.controller;


import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.domain.ProjectScore;
import cc.mrbird.febs.project.domain.ProjectScoringRules;
import cc.mrbird.febs.project.service.ProjectScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hyl
 */
@Slf4j
@Validated
@RestController
@RequestMapping("project")
public class ProjectScoreController {

    private ProjectScoreService projectScoreService;

    private String message;
    @PostMapping("score")
    public FebsResponse addProjectScore(@RequestBody List<ProjectScore> projectScore) throws FebsException {
        try {
            //TODO 转换
            this.projectScoreService.addProjectScore(projectScore);
            return new FebsResponse().code("200").message("新增学生分数信息成功").status("success");
        } catch (Exception e) {
            message = "新增项目信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    @PostMapping("score/rules")
    public FebsResponse addProjectScoringRules(@RequestBody List<ProjectScoringRules> projectScoringRules) throws FebsException {
        try {
            this.projectScoreService.addProjectScoringRules(projectScoringRules);
            return new FebsResponse().code("200").message("新增打分规则信息成功").status("success");
        } catch (Exception e) {
            message = "新增打分规则信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    @GetMapping("score/rules")
    public FebsResponse getProjectScoringRules() throws FebsException {
        try {
            List<ProjectScoringRules> rules= this.projectScoreService.getRules();
            return new FebsResponse().code("200").message("新增打分规则信息成功").status("success").data(rules);
        } catch (Exception e) {
            message = "新增打分规则信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}
