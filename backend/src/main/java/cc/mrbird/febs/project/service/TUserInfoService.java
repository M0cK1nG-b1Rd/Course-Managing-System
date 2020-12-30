package cc.mrbird.febs.project.service;

import cc.mrbird.febs.project.domain.TUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author hyl
 */
public interface TUserInfoService extends IService<TUserInfo> {
    TUserInfo findByUsername(String username);
}
