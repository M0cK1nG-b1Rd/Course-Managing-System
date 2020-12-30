package cc.mrbird.febs.project.controller;


import cc.mrbird.febs.common.authentication.JWTUtil;
import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.service.ProjectPeopleService;
import cc.mrbird.febs.project.service.TUserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
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

    @Autowired
    private TUserInfoService tUserInfoService;

    String getUsername(){
        String username="";
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isNotBlank(token)) {
            username = JWTUtil.getUsername(token);
        }
        return username;
    }

    @GetMapping("details")
    public FebsResponse getProjectDetail(@RequestParam(name="pid") String pid){
        List<ProjectPeople> list =  this.projectPeopleService.findById(pid);
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }


    @GetMapping("same_group")
    public FebsResponse getPeopleInSameGroup() {
        TUserInfo userInfo= tUserInfoService.findByUsername(this.getUsername());
        String sid= userInfo.getSid();
        List<ProjectPeople> list = this.projectPeopleService.getAllPeopleInGroup(sid);
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }
}
