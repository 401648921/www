package com.example.demo.Mapper;

import com.example.demo.proj.Iceball;
import org.apache.ibatis.annotations.Select;

public interface IceballMapper {
    @Select("select * from iceball where documentcode = #{documentcode}")
    public Iceball selectByDocumentcode(String docomentcode);
}
