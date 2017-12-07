package com.tian.ssm.service;

import com.tian.ssm.bean.AdminInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface AdminInfoService {
    List<AdminInfo>loginAdmin(AdminInfo adminInfo);

    List<AdminInfo> findAllAdmin();
}
