package com.example.demo.Mapper;



import com.example.demo.proj.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;



public interface TestMapper {

    @Select("select * from information where id = #{id}")
    public Test selectById(int id);

    @Insert("insert into total(bronze,rank,value,silver,gold,name) " +
            "values (#{bronze},#{rank},#{value},#{sliver},#{gold},#{name})")
    public void inject(int bronze,int rank,int value,int sliver,int gold,String name);
}
