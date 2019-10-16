package com.cpf.backend.user.mapper;

import com.cpf.backend.user.entity.Tjob;

public interface TjobMapper {
    int deleteByPrimaryKey(Long jobId);

    int insert(Tjob record);

    int insertSelective(Tjob record);

    Tjob selectByPrimaryKey(Long jobId);

    int updateByPrimaryKeySelective(Tjob record);

    int updateByPrimaryKey(Tjob record);
}