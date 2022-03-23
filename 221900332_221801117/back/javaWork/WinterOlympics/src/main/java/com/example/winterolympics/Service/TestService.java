package com.example.winterolympics.Service;

import com.example.winterolympics.Mapper.TestMapper;
import com.example.winterolympics.proj.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    @Autowired
    TestMapper testMapper;


    public Test test(int id){
        return testMapper.selectById(id);
    }
}
