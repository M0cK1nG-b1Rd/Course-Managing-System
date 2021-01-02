package cc.mrbird.febs.project.service;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.system.domain.Dept;
import cc.mrbird.febs.system.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hyl
 */
@Service
public interface ProjectInfoService extends IService<ProjectInfo> {
    List<ProjectInfo> findProjectInfo(String username);


    List<ProjectInfo> findMyProjectInfo(String pid);

    long createProjectInfo(ProjectInfo projectInfo);

    ProjectInfo findByPid(String pid);

    void updateProjectInfo(ProjectInfo projectInfo, String pid);

    void deleteProjectInfo(String pid);

    List<ProjectInfo> findProjectInfoList(String pid);
}
