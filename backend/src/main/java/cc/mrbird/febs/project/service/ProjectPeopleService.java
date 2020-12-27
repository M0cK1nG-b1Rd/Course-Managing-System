package cc.mrbird.febs.project.service;

import cc.mrbird.febs.project.domain.ProjectInfo;
import cc.mrbird.febs.project.domain.ProjectPeople;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public interface ProjectPeopleService extends IService<ProjectPeople> {

    List<ProjectPeople> findById(String username);
}
