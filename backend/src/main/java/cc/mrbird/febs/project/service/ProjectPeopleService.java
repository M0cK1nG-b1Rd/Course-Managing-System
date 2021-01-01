package cc.mrbird.febs.project.service;

import cc.mrbird.febs.project.domain.PeopleInGroup;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.system.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author hyl
 */
@Service
public interface ProjectPeopleService extends IService<ProjectPeople> {

    List<ProjectPeople> findBySid(String sid);

    List<PeopleInGroup> getAllPeopleInGroup(String sid, String pid) ;

    void createProjectPeoples(LinkedHashMap<String,Object> projectPeoples);

    List<ProjectPeople> findByPid(String pid);

    List<ProjectPeople> getMyProjectPeople(String sid,String pid);
}
