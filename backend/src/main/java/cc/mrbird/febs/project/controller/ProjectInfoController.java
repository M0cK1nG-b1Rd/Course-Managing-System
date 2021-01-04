package cc.mrbird.febs.project.controller;

import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.ProjectUtil;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.service.ProjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    private String message;

    //查看我的项目（总览，不包括项目细节）（权限：学生）
    @GetMapping("my")
    @RequiresPermissions("project:my")
    public FebsResponse getProjectInfoByUserName() throws FebsException {
        try {
            List<ProjectInfo> list = this.projectInfoService.findMyProjectInfo(ProjectUtil.getSid());
            return new FebsResponse().code("200").message("请求成功").status("success").data(list);
        } catch (Exception e) {
            message = "未找到用户对应项目，请等待项目被创建";
            log.error(message, e);
            throw new FebsException(message);
        }
//        for (ProjectInfo projectInfo:list) {
//            if (projectInfo.getPid().toString().equals(pid)) {
//                return new FebsResponse().code("200").message("请求成功").status("success").data(projectInfo);
//            }
//        }
//        return new FebsResponse().code("404").message("未找到数据").status("not found");
    }

    //查看所有项目（权限：老师）
    @GetMapping("all")
    @RequiresPermissions("project:all")
    public FebsResponse projectInfoList(@RequestParam(value = "pid", required = false) String pid) throws FebsException {
        try {
            List<ProjectInfo> list = this.projectInfoService.findProjectInfoList(pid);
            return new FebsResponse().code("200").message("查询成功").status("success").data(list);
        } catch (Exception e) {
            message = "查询失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    //创建新的项目（权限：学生）
    @PostMapping
    @RequiresPermissions("project:create")
    public FebsResponse addProjectInfo(@RequestBody @Valid ProjectInfo projectInfo) throws FebsException {
        try {
            long pid = this.projectInfoService.createProjectInfo(projectInfo);
            LinkedHashMap<String, Long> map = new LinkedHashMap<>();
            map.put("pid", pid);
            return new FebsResponse().code("200").message("新增项目信息成功").status("success").data(map);
        } catch (Exception e) {
            message = "新增项目信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    //更新项目总体信息（权限：老师，项目经理）
    //TODO TEST
    @PutMapping
    @RequiresPermissions("project:all")
    public FebsResponse updateProjectInfo(@RequestBody @Valid ProjectInfo projectInfo, @RequestParam String pid) throws FebsException {
        try {
            this.projectInfoService.updateProjectInfo(projectInfo, pid);
            return new FebsResponse().code("200").message("更改项目信息成功").status("success");
        } catch (Exception e) {
            message = "更改项目信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    //删除项目（权限：老师，项目经理）
    @DeleteMapping
    @RequiresPermissions("project:all")
    public FebsResponse deleteProjectInfo(@RequestParam String pid) throws FebsException {
        try {
            this.projectInfoService.deleteProjectInfo(pid);
            return new FebsResponse().code("200").message("更改项目信息成功").status("success");
        } catch (Exception e) {
            message = "更改项目信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

}
