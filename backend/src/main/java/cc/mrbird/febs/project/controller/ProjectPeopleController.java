package cc.mrbird.febs.project.controller;


import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.service.ProjectPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hyl
 */
@RestController
@RequestMapping("project")
public class ProjectPeopleController {
    @Autowired
    private ProjectPeopleService projectPeopleService;

    @GetMapping("details")
    public FebsResponse getProjectDetail(@RequestParam(name="pid") String pid){
        List<ProjectPeople> list =  this.projectPeopleService.findById(pid);
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }
}
