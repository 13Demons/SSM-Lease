package com.tian.ssm.service.impl;

import com.tian.ssm.bean.AdminInfo;
import com.tian.ssm.mapper.AdminInfoMapper;
import com.tian.ssm.service.AdminInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public List<AdminInfo> loginAdmin(AdminInfo adminInfo) {
        return adminInfoMapper.loginAdmin(adminInfo);
    }

    @Override
    public List<AdminInfo> findAllAdmin() {
        return adminInfoMapper.findAllAdmin();
    }
}
