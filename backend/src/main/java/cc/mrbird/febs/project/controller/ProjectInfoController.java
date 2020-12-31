package cc.mrbird.febs.project.controller;

import cc.mrbird.febs.common.authentication.JWTUtil;
import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.service.ProjectInfoService;
import cc.mrbird.febs.project.service.ProjectPeopleService;
import cc.mrbird.febs.project.service.TUserInfoService;
import cc.mrbird.febs.system.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;

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

    private String message;

    String getUsername(){
        String username="";
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isNotBlank(token)) {
             username = JWTUtil.getUsername(token);
        }
        return username;
    }

    //我的项目（总览，不包括项目细节）
    @GetMapping("my")
    public FebsResponse getProjectInfoByUserName() {
        TUserInfo tUserInfo = tUserInfoService.findByUsername(this.getUsername());
        String sid = tUserInfo.getSid();
        List<ProjectInfo> list = this.projectInfoService.findMyProjectInfo(sid);
//        for (ProjectInfo projectInfo:list) {
//            if (projectInfo.getPid().toString().equals(pid)) {
//                return new FebsResponse().code("200").message("请求成功").status("success").data(projectInfo);
//            }
//        }
//        return new FebsResponse().code("404").message("未找到数据").status("not found");
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }

    @GetMapping("all")
    public FebsResponse projectInfoList(@RequestParam(value = "pid",required = false) String pid) {
        if(pid==null){
            List<ProjectInfo> list = this.projectInfoService.list();
            return new FebsResponse().code("200").message("请求成功").status("success").data(list);
        }else {
            ProjectInfo one = this.projectInfoService.findByPid(pid);
            return new FebsResponse().code("200").message("请求成功").status("success").data(one);
        }//IService提供的方法和BaseMapper提供的方法有啥区别？
    }

    @PostMapping("new")
    public FebsResponse addProjectInfo(@RequestBody @Valid ProjectInfo projectInfo) throws FebsException {
        try {
            long pid= this.projectInfoService.createProjectInfo(projectInfo);
            LinkedHashMap<String, Long> map = new LinkedHashMap<>();
            map.put("pid",pid);
            return new FebsResponse().code("200").message("新增项目信息成功").status("success").data(map);
        } catch (Exception e) {
            message = "新增项目信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}
