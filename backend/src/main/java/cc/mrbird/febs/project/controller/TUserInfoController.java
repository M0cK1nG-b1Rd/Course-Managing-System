package cc.mrbird.febs.project.controller;


import cc.mrbird.febs.common.domain.FebsResponse;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.service.TUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.List;

/**
 * @author hyl
 */
@Slf4j
@RestController
@RequestMapping("project")
public class TUserInfoController {

    @Autowired
    private TUserInfoService tUserInfoService;

    private String message;



    //查看全部班级信息（权限：老师）
    @GetMapping("all_class")
    public FebsResponse getAllClass() throws FebsException {
        try {
            List<TUserInfo> data= this.tUserInfoService.getAllClass();
            return new FebsResponse().code("200").message("查询信息成功").status("success").data(data);
        } catch (Exception e) {
            message = "查询信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    //查看全部学生信息（权限：老师）
    @GetMapping("all_stu")
    public FebsResponse getAllStu() throws FebsException {
        try {
            List<TUserInfo> data= this.tUserInfoService.getAllStu();
            return new FebsResponse().code("200").message("查询信息成功").status("success").data(data);
        } catch (Exception e) {
            message = "查询信息失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
