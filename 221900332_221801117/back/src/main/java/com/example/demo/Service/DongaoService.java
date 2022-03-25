package com.example.demo.Service;

import com.example.demo.Mapper.*;
import com.example.demo.proj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DongaoService {
    @Autowired
    TotalMapper totalMapper;
    @Autowired
    ScheduleMapper scheduleMapper;

    @Autowired
    IceballMapper iceballMapper;

    @Autowired
    IcePotMapper icePotMapper;

    @Autowired
    SkiMapper skiMapper;

    public Ski selectSki(String documentcode){
        return skiMapper.selectByDocumentcode(documentcode);
    }

    public Iceball selectIceball(String documentcode){
        return iceballMapper.selectByDocumentcode(documentcode);
    }


    public IcePot selectIcePot(String documentcode){
        return icePotMapper.selectByDocumentcode(documentcode);
    }

    public List<Schedule> selectSchedule(String time,String venue,String sport){
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("sport",sport);
        map.put("time",time);
        map.put("venue",venue);
        return scheduleMapper.find(map);
    }


    public List<Total> getTotals(){
        return totalMapper.selectAll();
    }
}
l