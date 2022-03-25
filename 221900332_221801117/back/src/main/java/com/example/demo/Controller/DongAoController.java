package com.example.demo.Controller;

import com.example.demo.Service.DongaoService;
import com.example.demo.proj.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "东奥相关接口", tags = { "东奥访问接口" })
@RequestMapping("/DongAo")
public class DongAoController {

    @Autowired
    DongaoService dongaoService;

    @ApiOperation(value = "查询自由式滑雪")
    @GetMapping("/getSki")
    public Ski selectSki(String documentcode){
        return dongaoService.selectSki(documentcode);
    }
    @ApiOperation(value = "查询冰球")
    @GetMapping("/getIceBall")
    public Iceball selectIceball(String documentcode){
        return dongaoService.selectIceball(documentcode);
    }

    @ApiOperation(value = "查询冰壶")
    @GetMapping("/getIcePot")
    public IcePot selectIcePot(String documentcode){
        return dongaoService.selectIcePot(documentcode);
    }
    @ApiOperation(value = "查询每日赛程")
    @GetMapping("/getSchedule")
    public List<Schedule> selectSchedule(String time, String venue, String sport){
        return dongaoService.selectSchedule(time,venue,sport);
    }

    @ApiOperation(value = "查询奖牌榜")
    @GetMapping("/getTotal")
    public List<Total> getTotals(){
        return dongaoService.getTotals();
    }
}
