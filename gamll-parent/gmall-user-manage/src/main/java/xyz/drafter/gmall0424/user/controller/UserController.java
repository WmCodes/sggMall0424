package xyz.drafter.gmall0424.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.drafter.gmall0424.bean.UserInfo;
import xyz.drafter.gmall0424.service.UserService;

import java.util.List;

/**
 * @author drafter
 * @date 2020/4/24
 * @desciption
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        return userService.findAll();
    }
}
