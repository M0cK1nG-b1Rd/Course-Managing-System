package cc.mrbird.febs.project.dao;

import cc.mrbird.febs.project.domain.ProjectInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public interface ProjectInfoMapper extends BaseMapper<ProjectInfo> {
    List<ProjectInfo> getProjectInfoByUsername(String username);
}
