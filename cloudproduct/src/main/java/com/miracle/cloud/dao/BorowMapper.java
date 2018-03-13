package com.miracle.cloud.dao;

import com.miracle.cloud.bean.Borow;
import com.miracle.cloud.bean.BorowExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BorowMapper {
    long countByExample(BorowExample example);

    int deleteByExample(BorowExample example);

    int insert(Borow record);

    int insertSelective(Borow record);

    List<Borow> selectByExample(BorowExample example);

    int updateByExampleSelective(@Param("record") Borow record, @Param("example") BorowExample example);

    int updateByExample(@Param("record") Borow record, @Param("example") BorowExample example);
}