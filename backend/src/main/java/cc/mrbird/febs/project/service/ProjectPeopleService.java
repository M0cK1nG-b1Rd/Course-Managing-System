package cc.mrbird.febs.project.service;

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

    List<ProjectPeople> findById(String username);

    List<ProjectPeople> getAllPeopleInGroup(String sid) ;
}
