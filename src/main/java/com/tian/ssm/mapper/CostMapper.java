package com.tian.ssm.mapper;

import com.tian.ssm.bean.Cost;

import java.util.List;

public interface CostMapper {
    int insert(Cost record);

    int insertSelective(Cost record);

}