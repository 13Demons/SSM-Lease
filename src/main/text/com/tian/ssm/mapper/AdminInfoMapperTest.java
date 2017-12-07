package com.tian.ssm.mapper;


import com.tian.ssm.bean.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;



/**
 * Created by dllo on 17/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class AdminInfoMapperTest {
    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Test
    public void loginAdmin() throws Exception {
        System.out.println(adminInfoMapper.loginAdmin(new AdminInfo("123","123")));
    }

}