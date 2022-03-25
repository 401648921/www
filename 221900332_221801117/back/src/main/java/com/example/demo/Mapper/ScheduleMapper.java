package com.example.demo.Mapper;

import com.example.demo.proj.Schedule;
import com.example.demo.proj.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface ScheduleMapper {
    @Select("select * from schedule where sport = #{sport}")
    public List<Schedule> selectById(String sport);

    @Insert("insert into icePot (result,period1,period2,athletef1,athletem1,athletef2,athletem2,documentcode) values (#{result},#{period1},#{period2},#{athletef1},#{athletem1},#{athletef2},#{athletem2},#{documentcode})")
    public void insertIcePot(String result,String period1,String period2,String athletef1,String athletem1,String athletef2,String athletem2,String documentcode);

    @Insert("insert into iceball (result,homeathlete,homeposition,awayathlete,awayposition,homedetail,awaydetail,homeecharts,awayecharts,documentcode) values (#{result},#{homeathlete},#{homeposition},#{awayathlete},#{awayposition},#{homedetail},#{awaydetail},#{homeecharts},#{awayecharts},#{documentcode})")
    public void insertIceBall(String result,String homeathlete,String homeposition,String awayathlete,String awayposition,String homedetail,String awaydetail,String homeecharts,String awayecharts,String documentcode);

    @Insert("insert into ski (documentcode,detail) values (#{documentcode},#{detail})")
    public void insertSki(String documentcode,String detail);


    @SelectProvider(type=ScheduleSelectSqlBuider.class,method="getSql")
    public List<Schedule> find(Map<String,Object> map);


}
