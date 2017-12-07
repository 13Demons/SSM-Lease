package com.tian.ssm.mapper;

import com.tian.ssm.bean.AdminInfo;

import java.util.List;

public interface AdminInfoMapper {
    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    List<AdminInfo> loginAdmin(AdminInfo adminInfo);

    List<AdminInfo> findAllAdmin();
}