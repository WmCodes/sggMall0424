package xyz.drafter.gmall0424.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.drafter.gmall0424.bean.UserInfo;
import xyz.drafter.gmall0424.service.UserService;
import xyz.drafter.gmall0424.user.mapper.UserInfoMapper;

import java.util.List;

/**
 * @author drafter
 * @date 2020/4/24
 * @desciption
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }
}
