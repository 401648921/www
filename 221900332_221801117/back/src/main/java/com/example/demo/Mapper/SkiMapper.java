package com.example.demo.Mapper;

import com.example.demo.proj.IcePot;
import com.example.demo.proj.Ski;
import org.apache.ibatis.annotations.Select;

public interface SkiMapper {
    @Select("select * from ski where documentcode = #{documentcode}")
    public Ski selectByDocumentcode(String docomentcode);
}
