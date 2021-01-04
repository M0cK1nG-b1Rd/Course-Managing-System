package cc.mrbird.febs.project.controller;


import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.ProjectUtil;
import cc.mrbird.febs.project.domain.PeopleInGroup;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.service.ProjectPeopleService;
import cc.mrbird.febs.project.service.TUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author hyl
 */
@Slf4j
@RestController
@RequestMapping("project")
public class ProjectPeopleController {
    @Autowired
    private ProjectPeopleService projectPeopleService;

    private String message;
    @Autowired
    private TUserInfoService tUserInfoService;


    //查看同组的成员信息（权限：学生）
    @GetMapping("same_group")
    @RequiresPermissions("project:my")
    public FebsResponse getPeopleInSameGroup(@RequestParam(name = "pid") String pid) {
        List<PeopleInGroup> list = this.projectPeopleService.getAllPeopleInGroup(ProjectUtil.getSid(), pid);
        if (list.isEmpty()) {
            return new FebsResponse().code("404").message("not found").status("not found");
        }
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }

    //新增成员信息（权限：项目经理）
    @PostMapping("member_info")
    @RequiresPermissions("project:create")
    public FebsResponse addProjectPeople(@RequestBody LinkedHashMap<String, Object> projectPeoples) throws FebsException {
        try {
            this.projectPeopleService.createProjectPeoples(projectPeoples);
            return new FebsResponse().code("200").message("请求成功").status("success");
        } catch (Exception e) {
            message = "请求失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    //查看成员信息（权限：学生）
    @GetMapping("my_member_info")
    @RequiresPermissions("project:my")
    public FebsResponse getMyProjectPeople(@RequestParam(value = "pid", required = false) String pid) throws FebsException {
        try {
            String sid = ProjectUtil.getSid();
            List<ProjectPeople> data = this.projectPeopleService.getMyProjectPeople(sid, pid);
            return new FebsResponse().code("200").message("请求成功").status("success").data(data);
        } catch (Exception e) {
            message = "请求成功";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    //查看全部成员信息（权限：老师、项目经理）
    @GetMapping("all_member_info")
    @RequiresPermissions(value = {"project:all","project:create"},logical = Logical.OR)
    public FebsResponse getProjectPeople(@RequestParam(value = "pid", required = false) String pid) throws FebsException {
        try {
            List<TUserInfo> data = this.tUserInfoService.getProjectPeoples(pid);
            return new FebsResponse().code("200").message("查询信息成功").status("success").data(data);
        } catch (Exception e) {
            message = "查询信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    //修改成员信息（权限：项目经理）
    //TODO TEST
    @PutMapping("my_member_info")
    @RequiresPermissions("project:create")
    public FebsResponse updateMyProjectPeople(@RequestBody LinkedHashMap<String, Object> projectPeoples, @RequestParam("pid") String pid) throws FebsException {
        try {
            List<String> pids = ProjectUtil.getPids();
            if (pids.contains(pid)) {
                this.projectPeopleService.updateProjectPeoples(projectPeoples,pid);
                return new FebsResponse().code("200").message("请求成功").status("success");
            } else {
                throw new Exception("这不是你所有的项目啊喂");
            }
        } catch (Exception e) {
            message = "请求失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    //修改成员信息（权限：老师）
    @PutMapping("member_info")
    @RequiresPermissions(value = {"project:all","project:create"},logical = Logical.OR)
    public FebsResponse updateProjectPeople(@RequestBody LinkedHashMap<String, Object> projectPeoples, @RequestParam(value = "pid", required = false) String pid) throws FebsException {
        try {
            this.projectPeopleService.updateProjectPeoples(projectPeoples, pid);
            return new FebsResponse().code("200").message("请求成功").status("success");
        } catch (Exception e) {
            message = "请求失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
