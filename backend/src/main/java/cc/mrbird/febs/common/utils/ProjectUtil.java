package cc.mrbird.febs.common.utils;

import cc.mrbird.febs.common.authentication.JWTUtil;
import cc.mrbird.febs.project.domain.ProjectScore;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.service.TUserInfoService;
import cc.mrbird.febs.project.service.impl.TUserInfoServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class ProjectUtil {


    @Autowired  // 注入
    private TUserInfoService tUserInfoService;

    // 声明对象
    public static ProjectUtil projectUtil;

    @PostConstruct // 初始化
    public void init(){
        projectUtil = this;
        projectUtil.tUserInfoService = this.tUserInfoService;
    }


    public static String getUsername(){
        String username="";
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isNotBlank(token)) {
            username = JWTUtil.getUsername(token);
        }
        return username;
    }

    public static String getSid(){
        TUserInfo userInfo= projectUtil.tUserInfoService.findByUsername(ProjectUtil.getUsername());
        return userInfo.getSid();
    }

}