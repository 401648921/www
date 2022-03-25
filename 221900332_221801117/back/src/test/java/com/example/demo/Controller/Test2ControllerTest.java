package com.example.demo.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.DaysBean;
import com.example.demo.Mapper.IcePotMapper;
import com.example.demo.Mapper.ScheduleMapper;
import com.example.demo.Mapper.TestMapper;
import com.example.demo.Tools;
import com.example.demo.TotalBean;
import com.example.demo.proj.IcePot;
import com.example.demo.proj.Schedule;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MapperScan("com.example.demo.Mapper")
@SpringBootTest
class Test2ControllerTest {
    @Autowired
    TestMapper testMapper;
    @Autowired
    ScheduleMapper scheduleMapper;

    @Autowired
    IcePotMapper icePotMapper;
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

    @Test
    void find() throws IOException {
        List<Schedule> list = scheduleMapper.selectById("冰壶");
        for(int i = 0;i<list.size();i++){
            String data = list.get(i).getDocumentcode();
            String path = "http://api.cntv.cn/Olympic/getBjOlyDtResult?serviceId=2022dongao&type=DT_RESULT&t=jsonp&cb=cbGetResult&code="+data;
            URL url = new URL(path); //抛出MalformedURLException
            HttpURLConnection con = null;
            BufferedReader buffer = null;
            StringBuffer resultBuffer = null;

            con = (HttpURLConnection) url.openConnection(); //抛出IOException
            con.setRequestMethod("GET"); //设置请求方式
            con.setRequestProperty("Content-Type", "application/json;charset=utf-8"); //设置编码方式
            int responseCode = con.getResponseCode();//获取响应码
            if(responseCode != HttpURLConnection.HTTP_OK){
                System.out.println("error");
            }

            InputStream inputStream = con.getInputStream();
            resultBuffer = new StringBuffer();
            String responseLine;
            buffer = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            while((responseLine = buffer.readLine()) != null){
                resultBuffer.append(responseLine);
            }
            String result = resultBuffer.toString();
            result = result.substring(12,result.length() - 2);
            //System.out.println(result);
            JSONObject json = JSONObject.parseObject(result);
            JSONObject data1 = json.getJSONObject("data");
            JSONObject dataSource= (JSONObject) data1.getJSONArray("dataSourceList").get(0);
            JSONObject cards = dataSource.getJSONObject("cards");
            JSONArray array = cards.getJSONArray("data");
            JSONObject home = (JSONObject) array.get(0);
            JSONObject away = (JSONObject) array.get(1);
            String athletef1 = ((JSONObject)home.getJSONArray("AthleteList").get(0)).getString("AthleteName");
            String athletem1 = ((JSONObject)home.getJSONArray("AthleteList").get(1)).getString("AthleteName");
            String athletef2 = ((JSONObject)away.getJSONArray("AthleteList").get(0)).getString("AthleteName");
            String athletem2 = ((JSONObject)away.getJSONArray("AthleteList").get(1)).getString("AthleteName");
            String race = home.getString("Result")+" : "+ away.getString("Result");
            JSONArray periods = cards.getJSONObject("periods").getJSONArray("period");
            String homeScore = "";
            String awayScore = "";
            for(int j = 0;j<periods.size();j++){
                homeScore += ((JSONObject)periods.get(j)).getString("HomeScore")+",";
                awayScore += ((JSONObject)periods.get(j)).getString("AwayScore")+",";
            }
            homeScore = homeScore.substring(0,homeScore.length()-1);
            awayScore = awayScore.substring(0,awayScore.length()-1);
            scheduleMapper.insertIcePot(race,homeScore,awayScore,athletef1,athletem1,athletef2,athletem2,data);



        }
    }
    @Test
    void find1() throws IOException {
        List<Schedule> list = scheduleMapper.selectById("冰球");
        for(int i = 0;i<list.size();i++){
            String data = list.get(i).getDocumentcode();
            String path = "http://api.cntv.cn/Olympic/getBjOlyDtResult?serviceId=2022dongao&type=DT_RESULT&t=jsonp&cb=cbGetResult&code="+data;
            URL url = new URL(path); //抛出MalformedURLException
            HttpURLConnection con = null;
            BufferedReader buffer = null;
            StringBuffer resultBuffer = null;

            con = (HttpURLConnection) url.openConnection(); //抛出IOException
            con.setRequestMethod("GET"); //设置请求方式
            con.setRequestProperty("Content-Type", "application/json;charset=utf-8"); //设置编码方式
            int responseCode = con.getResponseCode();//获取响应码
            if(responseCode != HttpURLConnection.HTTP_OK){
                System.out.println("error");
            }

            InputStream inputStream = con.getInputStream();
            resultBuffer = new StringBuffer();
            String responseLine;
            buffer = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            while((responseLine = buffer.readLine()) != null){
                resultBuffer.append(responseLine);
            }
            String result = resultBuffer.toString();
            result = result.substring(12,result.length() - 2);
            //System.out.println(result);
            JSONObject json = JSONObject.parseObject(result);
            JSONObject data1 = json.getJSONObject("data");
            JSONObject dataSource= (JSONObject) data1.getJSONArray("dataSourceList").get(0);
            JSONObject cards = dataSource.getJSONObject("cards");
            JSONArray array = cards.getJSONArray("data");
            JSONObject home = (JSONObject) array.get(0);
            JSONObject away = (JSONObject) array.get(1);
            String homeathlete = "";
            String homeposition = "";
            String awayathlete = "";
            String awayposition = "";
            JSONArray array1 = home.getJSONArray("AthleteList");
            JSONArray array2 = home.getJSONArray("AthleteList");
            for(int j = 0;j<array1.size();j++){
                homeathlete+=((JSONObject)array1.get(j)).getString("AthleteName")+",";
                homeposition+=((JSONObject)array1.get(j)).getString("Position")+",";
            }
            for(int j = 0;j<array2.size();j++){
                awayathlete+=((JSONObject)array2.get(j)).getString("AthleteName")+",";
                awayposition+=((JSONObject)array2.get(j)).getString("Position")+",";
            }
            homeathlete = homeathlete.substring(0,homeathlete.length() - 1);
            homeposition = homeposition.substring(0,homeposition.length() - 1);
            awayathlete = awayathlete.substring(0,awayathlete.length() -1);
            awayposition = awayposition.substring(0,awayposition.length() - 1);
            String race = home.getString("Result")+" : "+ away.getString("Result");
            String homedetail = home.getString("Result")+","+home.getString("SOG")+","+home.getString("PPG")+","+home.getString("FO")+","+home.getString("PIM")+","+home.getString("SHG");
            String awaydetail = away.getString("Result")+","+away.getString("SOG")+","+away.getString("PPG")+","+away.getString("FO")+","+away.getString("PIM")+","+away.getString("SHG");

            JSONArray periods = cards.getJSONObject("periods").getJSONArray("period");
            String homeecharts = "";
            String awayecharts = "";
            for(int j = 0;j<periods.size();j++){
                homeecharts += ((JSONObject)periods.get(j)).getString("HomeScore")+",";
                awayecharts += ((JSONObject)periods.get(j)).getString("AwayScore")+",";
            }
            homeecharts = homeecharts.substring(0,homeecharts.length()-1);
            awayecharts = awayecharts.substring(0,awayecharts.length()-1);
            scheduleMapper.insertIceBall(race,homeathlete,homeposition,awayathlete,awayposition,homedetail,awaydetail,homeecharts,awayecharts,data);

        }
    }

    @Test
    void find2() throws IOException {
        List<Schedule> list = scheduleMapper.selectById("自由式滑雪");
        for(int i = 0;i<list.size();i++){
            try {
                String data = list.get(i).getDocumentcode();
                String path = "http://api.cntv.cn/Olympic/getBjOlyDtResult?serviceId=2022dongao&type=DT_RESULT&t=jsonp&cb=cbGetResult&code=" + data;
                URL url = new URL(path); //抛出MalformedURLException
                HttpURLConnection con = null;
                BufferedReader buffer = null;
                StringBuffer resultBuffer = null;

                con = (HttpURLConnection) url.openConnection(); //抛出IOException
                con.setRequestMethod("GET"); //设置请求方式
                con.setRequestProperty("Content-Type", "application/json;charset=utf-8"); //设置编码方式
                int responseCode = con.getResponseCode();//获取响应码
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    System.out.println("error");
                }

                InputStream inputStream = con.getInputStream();
                resultBuffer = new StringBuffer();
                String responseLine;
                buffer = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while ((responseLine = buffer.readLine()) != null) {
                    resultBuffer.append(responseLine);
                }
                String result = resultBuffer.toString();
                result = result.substring(12, result.length() - 2);
                JSONObject json = JSONObject.parseObject(result);
                System.out.println(result);
                JSONObject data1 = json.getJSONObject("data");
                //System.out.println(result);
                if (data1.getInteger("total") == 0) {
                    System.out.println(data);
                    continue;
                }
                JSONObject dataSource = (JSONObject) data1.getJSONArray("dataSourceList").get(0);
                JSONObject cards = dataSource.getJSONObject("cards");
                JSONArray array = cards.getJSONArray("data");
                String detail = "";
                for (int j = 0; j < array.size(); j++) {
                    JSONObject element = (JSONObject) array.get(j);
                    JSONObject athletet = (JSONObject) (element.getJSONArray("AthleteList").get(0));
                    JSONObject resultOne = (JSONObject) (element.getJSONArray("ResultItemList").get(0));
                    detail += element.getString("Rank") + "," + athletet.getString("Order") + "," + athletet.getString("Bib") + "," + element.getString("NocName") + "," + athletet.getString("AthleteName") + "," + resultOne.getString("Result");
                }

                scheduleMapper.insertSki(data, detail);
            }catch (Exception e){

                continue;
            }
        }
    }
}