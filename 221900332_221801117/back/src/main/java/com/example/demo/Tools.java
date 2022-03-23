package com.example.demo;

import com.google.gson.Gson;

import java.io.*;

public class Tools {
    Gson gson = new Gson();

    public static String jsonToStr(String path){//将json文件转化为字符串类型
        String jsonStr = "";
        try {
            File jsonFile = new File(path);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),
                    "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("jsonToStr方法报错！");
            return null;
        }
    }

    public static DaysBean jsonAnalDays(String jsonStr){//使用Gson解析每日赛程的json并获取数据到javaBean
        Gson gson = new Gson();
        DaysBean bean = gson.fromJson(jsonStr, DaysBean.class);
        return bean;
    }

    public static TotalBean jsonAnalTotal(String jsonStr){//使用Gson解析total赛程的json并获取数据到javaBean
        Gson gson = new Gson();
        TotalBean bean = gson.fromJson(jsonStr, TotalBean.class);
        return bean;
    }

    public void injectJson(){

    }
}
