package com.example.demo.Controller;

import com.example.demo.DaysBean;
import com.example.demo.Mapper.TestMapper;
import com.example.demo.Tools;
import com.example.demo.TotalBean;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@MapperScan("com.example.demo.Mapper")
@SpringBootTest
class Test2ControllerTest {
    @Autowired
    TestMapper testMapper;
    @Test
    void insertTable() {

        String[] jsonStr = new String[21];
        jsonStr[0]=Tools.jsonToStr("target/test-classes/com/static/total.json");//0为total的json字符串
        jsonStr[1]="";

//        String totalStr = "null";
        for (int i = 2; i < 10; i++) {
            jsonStr[i]=Tools.jsonToStr("target/test-classes/com/static/020"+i+".json");
        }
        for (int i = 10; i <=20 ; i++) {
            jsonStr[i]=Tools.jsonToStr("target/test-classes/com/static/02"+i+".json");
        }
        DaysBean db;
//        TotalBean tb = Tools.jsonAnalTotal(jsonStr[0]); total 数据注入
//        for (int i = 0; i < tb.data.medalsList.size(); i++) {
//            testMapper.inject(Integer.parseInt(tb.data.medalsList.get(i).bronze),
//                    Integer.parseInt(tb.data.medalsList.get(i).rank),
//                    Integer.parseInt(tb.data.medalsList.get(i).count),
//                    Integer.parseInt(tb.data.medalsList.get(i).silver),
//                    Integer.parseInt(tb.data.medalsList.get(i).gold),
//                    tb.data.medalsList.get(i).countryname);
//            System.out.println(i);
//        }
//        for (int i = 2; i <= 20; i++) {
//            db = Tools.jsonAnalDays(jsonStr[i]);
//            for (int j = 0; j < db.data.matchList.size(); j++) {
//                System.out.println("size:"+db.data.matchList.size()+",i:"+i+",j:"+j);
//
//                testMapper.daysInject(db.data.matchList.get(j).id,db.data.matchList.get(j).documentcode,
//                        db.data.matchList.get(j).enddatecn,db.data.matchList.get(j).itemcodename,
//                        db.data.matchList.get(j).title,db.data.matchList.get(j).homename,
//                        db.data.matchList.get(j).awayname, db.data.matchList.get(j).venuename);
//            }
//        }


//        testMapper.inject(1,1,1,1,1,"name");
    }
}