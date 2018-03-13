package com.miracle.cloud.dao;

import com.miracle.cloud.bean.BookStock;
import com.miracle.cloud.bean.BookStockExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookStockMapper {
    long countByExample(BookStockExample example);

    int deleteByExample(BookStockExample example);

    int deleteByPrimaryKey(String isbn);

    int insert(BookStock record);

    int insertSelective(BookStock record);

    List<BookStock> selectByExample(BookStockExample example);

    BookStock selectByPrimaryKey(String isbn);

    int updateByExampleSelective(@Param("record") BookStock record, @Param("example") BookStockExample example);

    int updateByExample(@Param("record") BookStock record, @Param("example") BookStockExample example);

    int updateByPrimaryKeySelective(BookStock record);

    int updateByPrimaryKey(BookStock record);
}