package com.example.demo.Controller;

import com.example.demo.Mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Test2Controller {
    @Autowired
    TestMapper testMapper;

    public void insertTable(){
        testMapper.inject(1,1,1,1,1,"name");
    }
}
