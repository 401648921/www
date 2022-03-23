package com.example.demo.Controller;


import com.example.demo.Service.TestService;
import com.example.demo.proj.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "测试Controller", tags = { "测试访问接口" })
@RequestMapping("/film")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "添加一部电影")
    @GetMapping("/addFilm")
    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数") })
    public Test test(HttpServletRequest request){
        return new Test();
    }
}
