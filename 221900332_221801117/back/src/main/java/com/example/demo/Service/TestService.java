package com.example.demo.Service;


import com.example.demo.Mapper.TestMapper;
import com.example.demo.proj.Test;
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
