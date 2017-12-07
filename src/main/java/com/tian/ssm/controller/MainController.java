package com.tian.ssm.controller;

import com.tian.ssm.bean.AdminInfo;
import com.tian.ssm.service.AdminInfoService;

import com.tian.ssm.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//.trim()
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class MainController {

    @Resource(name = "adminInfo")
    private AdminInfoService adminInfoService;
    private String text;


    @ResponseBody
    @RequestMapping(value = "login")
    public String loginAdminInfo(AdminInfo adminInfo,String code,HttpSession session){
        AdminInfo admin = adminInfoService.loginAdmin(adminInfo);
        String code1 = (String) session.getAttribute("code");

        if (adminInfo.getName()==null&&adminInfo.getName().isEmpty()){
            return "error";
        }
        else if (adminInfo.getPassword()==null||adminInfo.getPassword().isEmpty()){
            return "errorNull";
        }
        else if (adminInfo.getName().length()<3||adminInfo.getName().length()>8){
            return "NameLength";
        }
        else if (adminInfo.getPassword().length()<3||adminInfo.getPassword().length()>8){
            return "PwdLength";
        }
        else if (!admin.getName().equals(adminInfo.getName())){
            return "NameError";
        }
        else if (!admin.getPassword().equals(adminInfo.getPassword())){
            return "PwdError";
        }
        else if (!code1.equals(code)){
            return "codeError";
        }
        return "success";

    }


    @RequestMapping(value = "lon")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/code")
    public void Verify(HttpServletRequest request,HttpSession session, HttpServletResponse response) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        text = verifyCode.getText();
        session.setAttribute("code",verifyCode.getText());
        VerifyCode.output(image,response.getOutputStream());

    }







}
