package com.tian.ssm.controller;

import com.tian.ssm.bean.AdminInfo;
import com.tian.ssm.service.AdminInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class MainController {
    @Resource
    private AdminInfoService adminInfoService;


    @RequestMapping(value = "login")
    @ResponseBody
    public String loginAdmin(AdminInfo adminInfo){
        List<AdminInfo> adminInfos = adminInfoService.loginAdmin(adminInfo);
        if (!adminInfos.isEmpty()&&adminInfos!=null){
            return "redirect:index";
        }
        return "login";
    }




}
