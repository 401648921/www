package com.example.demo.Mapper;

import com.example.demo.proj.Total;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TotalMapper {
    @Select("select * from total")
    public List<Total> selectAll();

}
