package com.example.winterolympics.Mapper;


import com.example.winterolympics.proj.Test;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;



@Repository
public interface TestMapper {

    @Select("select * from information where id = #{id}")
    public Test selectById(int id);


}
