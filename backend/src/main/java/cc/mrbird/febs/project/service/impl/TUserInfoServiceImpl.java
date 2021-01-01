package cc.mrbird.febs.project.service.impl;
import cc.mrbird.febs.project.domain.TUserInfo;
import cc.mrbird.febs.project.dao.TUserInfoMapper;
import cc.mrbird.febs.project.service.TUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyl
 */
@Service
public class TUserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, TUserInfo> implements TUserInfoService {
    private TUserInfoMapper tUserInfoMapper;

    @Autowired
    public TUserInfoServiceImpl(TUserInfoMapper tUserInfoMapper){
        this.tUserInfoMapper = tUserInfoMapper;
    }

    public TUserInfoServiceImpl(){

    }


    //Username其实就是sid，动数据库的代价太大了
    @Override
    public TUserInfo findByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        return tUserInfoMapper.selectOne(wrapper);
    }

    @Override
    public List<TUserInfo> getProjectPeoples(String pid) {
        List<TUserInfo> test =this.baseMapper.getProjectPeoples(pid);
        return this.baseMapper.getProjectPeoples(pid);
    }

    @Override
    public List<TUserInfo> getAllClass(){
        return this.baseMapper.getAllClass();
    }

    public List<TUserInfo> getAllStu(){
        return this.baseMapper.getAllStu();
    }
}
