package cc.mrbird.febs.project.controller;

import cc.mrbird.febs.common.authentication.JWTUtil;
import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.service.ProjectInfoService;
import cc.mrbird.febs.project.service.TUserInfoService;
import cc.mrbird.febs.system.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hyl
 */
@Slf4j
@Validated
@RestController
@RequestMapping("project")
public class ProjectInfoController {
    @Autowired
    private ProjectInfoService projectInfoService;

    @Autowired
    private TUserInfoService tUserInfoService;

    @Autowired
    private UserManager userManager;


    String getUsername(){
        String username="";
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isNotBlank(token)) {
             username = JWTUtil.getUsername(token);
        }
        return username;
    }


    @GetMapping("my")
    public FebsResponse projectInfo() {
        List<ProjectInfo> list = this.projectInfoService.findProjectInfo(this.getUsername());
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }

    @GetMapping("all")
    public FebsResponse projectInfoList() {
        List<ProjectInfo> list = this.projectInfoService.list();
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }


}
