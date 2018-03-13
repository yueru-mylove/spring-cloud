package com.miracle.cloud.dao;

import com.miracle.cloud.bean.Book;
import com.miracle.cloud.bean.BookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(String isbn);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(String isbn);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}