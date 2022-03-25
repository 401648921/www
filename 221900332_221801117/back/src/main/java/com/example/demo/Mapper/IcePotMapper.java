package com.example.demo.Mapper;

import com.example.demo.proj.IcePot;
import org.apache.ibatis.annotations.Select;

public interface IcePotMapper {
    @Select("select * from icePot where documentcode = #{documentcode}")
    public IcePot selectByDocumentcode(String docomentcode);
}
