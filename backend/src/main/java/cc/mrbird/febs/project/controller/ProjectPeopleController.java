package cc.mrbird.febs.project.controller;


import cc.mrbird.febs.common.authentication.JWTUtil;
import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.ProjectUtil;
import cc.mrbird.febs.project.dao.TUserInfoMapper;
import cc.mrbird.febs.project.domain.PeopleInGroup;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.service.ProjectPeopleService;
import cc.mrbird.febs.project.service.TUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

//    @GetMapping("details")
//    public FebsResponse getProjectDetail(@RequestParam(name="pid") String sid){
//        List<ProjectPeople> list =  this.projectPeopleService.findBySid(sid);
//        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
//    }

    //查看同组的成员信息（权限：学生）
    @GetMapping("same_group")
    public FebsResponse getPeopleInSameGroup(@RequestParam(name="pid") String pid) {
        List<PeopleInGroup> list = this.projectPeopleService.getAllPeopleInGroup(ProjectUtil.getSid(),pid);
        if(list.isEmpty()){
            return new FebsResponse().code("404").message("not found").status("not found");
        }
        return new FebsResponse().code("200").message("请求成功").status("success").data(list);
    }

    //新增成员信息（权限：项目经理）
    @PostMapping("member_info")
    public FebsResponse addProjectPeople(@RequestBody LinkedHashMap<String,Object> projectPeoples) throws FebsException{
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
    public FebsResponse getMyProjectPeople(@RequestParam(value = "pid" ,required = false) String pid) throws FebsException{
        try {
            String sid = ProjectUtil.getSid();
            List<ProjectPeople> data = this.projectPeopleService.getMyProjectPeople(sid,pid);
            return new FebsResponse().code("200").message("请求成功").status("success").data(data);
        } catch (Exception e) {
            message = "请求成功";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

//    //查看成员信息（权限：学生）
//    //TODO
//    @GetMapping("member_info")
//    public FebsResponse getAllProjectPeople(@RequestParam(value = "pid") String pid) throws FebsException{
//        try {
//            List<ProjectPeople> peoples = this.projectPeopleService.findByPid(pid);
//            return new FebsResponse().code("200").message("查询信息成功").status("success").data(peoples);
//        } catch (Exception e) {
//            message = "查询信息失败";
//            log.error(message, e);
//            throw new FebsException(message);
//        }
//    }

    //查看全部成员信息（权限：老师）
    @GetMapping("all_member_info")
    public FebsResponse getProjectPeople(@RequestParam(value = "pid",required = false) String pid ) throws FebsException {
        try {
            List<TUserInfo> data= this.tUserInfoService.getProjectPeoples(pid);
            return new FebsResponse().code("200").message("查询信息成功").status("success").data(data);
        } catch (Exception e) {
            message = "查询信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    //修改成员信息（权限：项目经理）
    @PutMapping("my_member_info")
    public FebsResponse updateProjectPeople(@RequestBody LinkedHashMap<String,Object> projectPeoples) throws FebsException{
        try {
            String sid = ProjectUtil.getSid();
            //TODO 想好实现细节
            this.projectPeopleService.updateMyProjectPeoples(projectPeoples);
            return new FebsResponse().code("200").message("请求成功").status("success");
        } catch (Exception e) {
            message = "请求失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }


    //修改成员信息（权限：老师）
    @PutMapping("member_info")
    public FebsResponse updateProjectPeople(@RequestBody LinkedHashMap<String,Object> projectPeoples, @RequestParam(value = "pid",required = false) String pid) throws FebsException{
        try {
            this.projectPeopleService.updateProjectPeoples(projectPeoples,pid);
            return new FebsResponse().code("200").message("请求成功").status("success");
        } catch (Exception e) {
            message = "请求失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
