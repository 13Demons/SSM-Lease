package com.tian.ssm.controller;

import com.tian.ssm.bean.AdminInfo;
import com.tian.ssm.service.AdminInfoService;

import com.tian.ssm.utils.AjaxResult;
import com.tian.ssm.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//.trim()
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class MainController {

    @Resource(name = "adminInfo")
    private AdminInfoService adminInfoService;
    private String text;

    /**
     * 登录
     * @param adminInfo
     * @param code
     * @param session
     * @return
     */
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
        else if ( admin==null||admin.getName()==null){
            return "NameError";
        }
        else if (!admin.getPassword().equals(adminInfo.getPassword())){
            return "PwdError";
        }
        else if (!code1.equalsIgnoreCase(code)){
            return "codeError";
        }
        return "success";

    }

    @RequestMapping(value = "lon")
    public String index(){
        return "index";
    }

    /**
     * 验证码
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/code")
    public void Verify(HttpSession session, HttpServletResponse response) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        text = verifyCode.getText();
        session.setAttribute("code",verifyCode.getText());
        VerifyCode.output(image,response.getOutputStream());
    }



    @RequestMapping(value = "Login")
    @ResponseBody
    public String login1(){
        return "sucess";
    }





    @RequestMapping(value = "RoleList")
    public String admin(){
        return "role/role_list";
    }

    @RequestMapping(value = "Role")
    //必须要有注解
    @ResponseBody
    public String admin1(){
        return "success";
    }


    /**
     *  角色管理
     * @return
     */
    @RequestMapping(value = "ReleMan")
    @ResponseBody
    public AjaxResult management(){
        return new AjaxResult(adminInfoService.findAllRole());
    }


    @RequestMapping(value = "btn_delete")
    @ResponseBody
    public String deleteAdmin(Integer adminId){
        adminInfoService.delete(adminId);
        return "btn_delete";
    }



}
