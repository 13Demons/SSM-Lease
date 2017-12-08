package com.tian.ssm.mapper;

import com.tian.ssm.bean.AdminInfo;

import java.util.List;

public interface AdminInfoMapper {

    /**
     * 登录
     * @param adminInfo
     * @return
     */
    AdminInfo loginAdmin(AdminInfo adminInfo);

    /**
     * 角色管理
     * @return
     */
    List<AdminInfo> findAllRole();

    /**
     * 修改
     * @param adminInfo
     */
    void update(AdminInfo adminInfo);

    /**
     * 删除
     * @param adminId
     */
    void delete(Integer adminId);


}