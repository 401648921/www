package com.example.demo.Mapper;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ScheduleSelectSqlBuider {
    public String getSql(Map<String, Object> map){

        String sport = (String)map.get("sport");
        String venue = (String)map.get("venue");
        String time =  (String)map.get("time");

        if(time==null) time = "";
        if(venue==null) venue = "";
        if(sport==null) sport = "";


        String sqlWhere = "";
        if(!sport.equals("")||!venue.equals("")||!time.equals("")){
            sqlWhere +="where ";
            if(!sport.equals("")){
                sqlWhere+="sport = '"+sport + "' and ";
            }
            if(!venue.equals("")){
                sqlWhere+="venue = '"+venue + "' and ";
            }
            if(!time.equals("")){
                sqlWhere+="time = '"+time + "' and ";
            }
            sqlWhere = sqlWhere.substring(0,sqlWhere.length() - 4);
        }
        System.out.println("select * from schedule" +sqlWhere);
        return "select * from schedule " +sqlWhere;

    }
}
