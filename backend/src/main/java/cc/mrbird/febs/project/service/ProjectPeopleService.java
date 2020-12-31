package cc.mrbird.febs.project.service;

import cc.mrbird.febs.project.domain.PeopleInGroup;
import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import cc.mrbird.febs.system.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public interface ProjectPeopleService extends IService<ProjectPeople> {

    List<ProjectPeople> findBySid(String sid);

    List<PeopleInGroup> getAllPeopleInGroup(String sid, String pid) ;

    void createProjectPeoples(List<ProjectPeople> projectPeoples);

}
