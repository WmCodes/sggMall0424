package xyz.drafter.gmall0424.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.drafter.gmall0424.bean.SpuInfo;
import xyz.drafter.gmall0424.service.ManageService;

import java.util.List;

/**
 * @author drafter
 * @date 2020/4/27
 * @desciption
 */
@RestController
public class SpuManageController {


    @Reference
    private ManageService manageService;

    // http://127.0.0.1:8081/spuList?catalog3Id=63
    @RequestMapping("spuList")
    public List<SpuInfo> spuList(SpuInfo spuInfo){
        return manageService.getSpuList(spuInfo);
    }
}
