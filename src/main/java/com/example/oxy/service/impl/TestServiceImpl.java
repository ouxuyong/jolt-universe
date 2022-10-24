package com.example.oxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oxy.mapper.TestDoMapper;
import com.example.oxy.model.TestModel;
import com.example.oxy.service.TestService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
@Slf4j
@Service
public class TestServiceImpl extends ServiceImpl<TestDoMapper, TestModel> implements TestService {
    @Autowired
    @Qualifier("dataSelectTaskExecutor")
    private Executor executor;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveTest(List<TestModel> testModelList) {
        this.save(new TestModel("主线程", "222666"));
        CompletableFuture.allOf(testModelList.stream().map(relateDataExtractWrapper -> CompletableFuture.runAsync(() -> {
            if(relateDataExtractWrapper.getName().equals("测试3")){
                log.error("触发异常 {}",relateDataExtractWrapper.getName());
                int i =1/10;
            }
            this.save(relateDataExtractWrapper);
        }, executor)).toArray(CompletableFuture[]::new)).join();
        log.info("执行完成");
        return true;
    }
}
