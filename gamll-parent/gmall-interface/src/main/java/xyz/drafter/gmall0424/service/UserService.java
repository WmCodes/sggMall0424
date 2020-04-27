package xyz.drafter.gmall0424.service;

import xyz.drafter.gmall0424.bean.UserAddress;
import xyz.drafter.gmall0424.bean.UserInfo;

import java.util.List;

/**
 * @author drafter
 * @date 2020/4/24
 * @desciption
 */
public interface UserService {

    List<UserInfo> findAll();

    List<UserAddress> getUserAddressList(String userId);
}
