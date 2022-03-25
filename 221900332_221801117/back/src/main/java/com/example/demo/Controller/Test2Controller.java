package com.example.demo.Controller;

import com.example.demo.Mapper.TestMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(value = "测试Controller", tags = { "测试访问接口" })
@RequestMapping("/film")
public class Test2Controller {
    @Autowired
    TestMapper testMapper;

    public void insertTable(){
        testMapper.inject(1,1,1,1,1,"name");
    }
}
