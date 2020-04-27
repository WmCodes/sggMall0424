package xyz.drafter.gmall0424.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.drafter.gmall0424.bean.UserAddress;
import xyz.drafter.gmall0424.service.UserService;

import java.util.List;

/**
 * @author drafter
 * @date 2020/4/26
 * @desciption
 */
@Controller
public class OrderController {

    @Reference
    private UserService userService;

/*    @RequestMapping("trade")
    public String trade(){

        //返回一个视图名为index.html
        return "index";
    }*/

// http://localhost:8081/tradr?userId=1
    @RequestMapping("trade")
    @ResponseBody
    public List<UserAddress> trade(String userId){

        //返回一个视图名为index.html
        return userService.getUserAddressList(userId);
    }
}
