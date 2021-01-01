package cc.mrbird.febs.project.controller;


import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.ProjectUtil;
import cc.mrbird.febs.project.domain.ProjectScore;
import cc.mrbird.febs.project.domain.ProjectScoringRules;
import cc.mrbird.febs.project.service.ProjectScoreService;
import cc.mrbird.febs.project.service.ProjectScoringRulesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author hyl
 */
@Slf4j
@Validated
@RestController
@RequestMapping("project")
public class ProjectScoreController {
    @Autowired
    private ProjectScoreService projectScoreService;

    @Autowired
    private ProjectScoringRulesService projectScoringRulesService;

    private String message;

    @PostMapping("score")
    public FebsResponse addProjectScore(@RequestBody ProjectScore projectScore) throws FebsException {
        try {
            this.projectScoreService.addProjectScore(projectScore);
            return new FebsResponse().code("200").message("新增学生分数信息成功").status("success");
        } catch (Exception e) {
            message = "新增项目信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @GetMapping("score")
    public FebsResponse getProjectScore() throws FebsException {
        try {
            String sid = ProjectUtil.getSid();
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("stuScore",this.projectScoreService.getProjectScore(sid));
            map.put("greaterThanInProject",this.projectScoreService.getGreaterThanInProject(sid));
            map.put("greaterThanInClass",this.projectScoreService.getGreaterThanInClass(sid));
            map.put("classStatistics",this.projectScoreService.getStatisticsInClass(sid));
//            this.projectScoreService.getStatisticsInProject(sid);
            return new FebsResponse().code("200").message("新增学生分数信息成功").status("success").data(map);
        } catch (Exception e) {
            message = "新增项目信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    @PostMapping("score/rules")
    public FebsResponse updateProjectScoringRules(@RequestBody LinkedHashMap<Object, Integer> projectScoringRules) throws FebsException {
        try {
            int process = projectScoringRules.get("process");
            int docs = projectScoringRules.get("docs");
            int completion = projectScoringRules.get("completion");
            int presentation = projectScoringRules.get("presentation");
            int[] score={process,docs,completion,presentation};
            this.projectScoreService.updateProjectScoringRules(score);
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
            List<ProjectScoringRules> rules = this.projectScoringRulesService.getRules();
            return new FebsResponse().code("200").message("查询成功").status("success").data(rules);
        } catch (Exception e) {
            message = "查询成功";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}
