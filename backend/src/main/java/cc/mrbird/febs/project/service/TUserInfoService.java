package cc.mrbird.febs.project.service;

import cc.mrbird.febs.project.domain.TUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */

@Service
public interface TUserInfoService extends IService<TUserInfo> {
    TUserInfo findByUsername(String username);

     List<TUserInfo> getProjectPeoples(String pid);

    List<TUserInfo> getAllClass();

    List<TUserInfo> getAllStu();
}
