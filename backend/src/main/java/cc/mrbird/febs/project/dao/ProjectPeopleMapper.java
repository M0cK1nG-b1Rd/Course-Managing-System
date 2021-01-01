package cc.mrbird.febs.project.dao;

import cc.mrbird.febs.project.domain.PeopleInGroup;
import cc.mrbird.febs.project.domain.ProjectPeople;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public interface ProjectPeopleMapper extends BaseMapper<ProjectPeople> {
    List<PeopleInGroup> getAllPeopleInGroup(String sid, String pid);

    List<ProjectPeople> getPeopleInSameGroup(@Param("sid") String sid);

    List<ProjectPeople> getMyProjectPeople(String sid,String pid);

//    void createProjectPeoples(List<ProjectPeople> projectPeoples);
}
