package cc.mrbird.febs.project.dao;

import cc.mrbird.febs.project.domain.TUserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public interface TUserInfoMapper extends BaseMapper<TUserInfo> {

    List<TUserInfo> getProjectPeoples(String pid);

    List<TUserInfo> getAllClass();
}
