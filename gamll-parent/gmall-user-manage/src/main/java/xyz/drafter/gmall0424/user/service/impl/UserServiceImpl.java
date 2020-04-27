package xyz.drafter.gmall0424.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.drafter.gmall0424.bean.UserAddress;
import xyz.drafter.gmall0424.bean.UserInfo;
import xyz.drafter.gmall0424.service.UserService;
import xyz.drafter.gmall0424.user.mapper.UserAddressMapper;
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

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddres = new UserAddress();
        userAddres.setUserId(userId);
        return userAddressMapper.select(userAddres);
    }
}
